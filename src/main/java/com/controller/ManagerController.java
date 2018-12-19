package com.controller;

import com.pojo.*;
import com.service.ManagerService;
import com.util.PrimaryKeyUtil;
import com.util.RetryLimitHashedCredentialsMatcher;
import com.util.UsernamePasswordCaptchaToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
* @Description:    管理员控制类
* @Author:         jiehao
* @CreateDate:     2018/11/30 17:28
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/30 17:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class ManagerController {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private RetryLimitHashedCredentialsMatcher matcher;
    /**
    * 方法实现说明   管理员注册
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:29
    */
    @RequestMapping(value = "managerRegister",method = RequestMethod.GET)
    @ResponseBody
    public Map managerRegister (Manager manager){
        Map<String,Object>map=new HashMap<>();
        Manager record=managerService.findManagerByName(manager.getUsername());
        if(record ==null){
            manager.setPasswordSalt(PrimaryKeyUtil.getAllRandomString(4));
            manager.setPassword(new SimpleHash(matcher.getHashAlgorithmName(),manager.getPassword(),
                    manager.getPasswordSalt(),matcher.getHashIterations()).toString());
            int number=managerService.addManager(manager);
            if (number>0){
                map.put("status","0");
                map.put("message","注册成功");
            }else {
                map.put("status","1");
                map.put("message","注册失败");
            }
        }else {
            map.put("status","2");
            map.put("stayus","用户名已存在");
        }
        return map;
    }

    /**
    * 方法实现说明   管理员登录
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:39
    */
    @RequestMapping(value = "managerLogin",method = RequestMethod.GET)
    @ResponseBody
    public Map managerLogin(Manager manager, Integer role, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        UsernamePasswordCaptchaToken token=new UsernamePasswordCaptchaToken(manager.getUsername(),
                manager.getPassword(),role);
        Subject subject=SecurityUtils.getSubject();
        try {
            subject.login(token);
            Manager record=managerService.findManagerByName(manager.getUsername());
            map.put("status","0");
            map.put("message","登录成功");
            map.put("manager",record);
        }catch (UnknownAccountException e){
            map.put("status","1");
            map.put("message","用户或密码错误");
        }catch (IncorrectCredentialsException e){
            map.put("status","2");
            map.put("message","账号或密码错误");
        }
        return map;
    }


    /**
    * 方法实现说明    管理员管理用户(封号)
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 20:13
    */
    @RequestMapping(value = "managerManageCus",method = RequestMethod.GET)
    @ResponseBody
    public Map managerManageCus(Managecus managecus,Integer clock ){
        Map<String,Object>map=new HashMap<>();
        System.out.println(clock);
        if(clock==0){
            managecus.setOperate_type("封号");
            clock=1;
        }else {
            managecus.setOperate_type("解封");
            clock=0;
        }
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        managecus.setOperate_time(df.format(new Date()));
        int number=managerService.insertMangerCus(managecus);
        if (number>0){
            int num=managerService.updateCusLock(managecus.getUid(),clock);
            if(num>0){
                map.put("status","0");
                map.put("message","修改成功");
            }else {
                map.put("status","1");
                map.put("message","修改失败");
            }
        }else {
            map.put("status","1");
            map.put("message","修改失败");
        }
        return map;
    }

    /**
    * 方法实现说明     管理员管理商家(封号)
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/3 8:27
    */
    @RequestMapping(value = "managerManageMer",method = RequestMethod.GET)
    @ResponseBody
    public Map managerManageMer(Managemer managemer,String mlock){
        Map<String,Object>map=new HashMap<>();
        if(Integer.parseInt(mlock)==0){
           managemer.setOperate_type("封号");
           mlock=String.valueOf(1);
        }else {
           managemer.setOperate_type("解封");
           mlock=String.valueOf(0);
        }
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        managemer.setOperate_time(df.format(new Date()));
        int number =managerService.insertManagerMer(managemer);
        if (number>0){
            int num=managerService.updateMerLock(managemer.getMid(),mlock);
            if (num>0){
                map.put("status","0");
                map.put("message","修改成功");
            }else {
                map.put("status","1");
                map.put("message","修改失败");
            }

        }else {
            map.put("status","1");
            map.put("nmessage","修改失败");
        }
        return map;
    }
    /**
    * 方法实现说明  分页查找顾客信息(需要优化，加查找功能)
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/7 16:04
    */
    @RequestMapping(value = "findAllUserMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map findAllUserMessage(Page record){
        Map<String,Object>map=new HashMap<>();
        List<Customer>customers=new ArrayList<Customer>();
        int total=managerService.findCustmerTotal();
        Page page=null;
        if( record.getPageNow()!=null){
            page= new Page(total,record.getPageNow());
            page.setPageSize(record.getPageSize());
            customers=managerService.managerFindCustmer(page.getStartPos(),page.getPageSize());
        }else {
            page=new Page(total,1);
            page.setPageSize(record.getPageSize());
            customers=managerService.managerFindCustmer(page.getStartPos(),page.getPageSize());
        }
        map.put("customer",customers);
        //map.put("page",page);
        return map;
    }

    /**
    * 方法实现说明  分页查找商家信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 8:55
    */
    @RequestMapping(value = "findAllMerchantMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map findAllMerchantMessage(Page record){
        Map<String,Object>map=new HashMap<>();
        List<Merchant>merchants=new ArrayList<Merchant>();
        int total=managerService.findMerchantTotal();
        Page page=null;
        if(record.getPageNow()!=null){
            System.out.println(String.valueOf(record.getPageNow()));
            page=new Page(total,record.getPageNow());
            page.setPageSize(record.getPageSize());
            merchants=managerService.managerFindMerchant(page.getStartPos(),page.getPageSize());

        }else {
            page=new Page(total,1);
            page.setPageSize(record.getPageSize());
            merchants=managerService.managerFindMerchant(page.getStartPos(),page.getPageSize());
        }
        map.put("merchant",merchants);
        return map;
    }

/**
* 方法实现说明  查看所有用户信息（可以带条件查询）
* @author：      jiehao
* @return：
* @exception：
* @date：       2018/12/10 17:05
*/
    @RequestMapping(value = "managerFindAllCustmer",method = RequestMethod.GET)
    @ResponseBody
    public Map managerFindAllCustmer(Customer customer){
        Map<String,Object>map=new HashMap<>();
        List<Customer>customers=new ArrayList<>();
        customers=managerService.managerFindAllCustmer(customer);
        map.put("customer",customers);
        return map;
    }

    /**
    * 方法实现说明  查看所有商家信息（可以带条件查询）
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 17:21
    */
    @RequestMapping(value = "managerFindAllMerchant",method = RequestMethod.GET)
    @ResponseBody
    public Map  managerFindAllMerchant(Merchant merchant){
        Map<String,Object>map=new HashMap<>();
        List<Merchant>merchants=new ArrayList<>();
        merchants=managerService.managerFindAllMerchant(merchant);
        map.put("merchant",merchants);
        return map;
    }

    /**
    * 方法实现说明    查找未审核注册商家
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/11 14:52
    */
    @RequestMapping(value = "findUnreviewedMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map findUnreviewedMessage(Merchant merchant){
        Map<String,Object>map=new HashMap<>();
        List<Merchant>merchants=new ArrayList<>();
        merchants=managerService.findUnreviewedMessage(merchant);
        for(int i=0;i<merchants.size();i++) {
            String addr = merchants.get(i).getState_message_addr();
            if (addr != null) {
            String[] address = addr.split(",");
            String[] order = new String[address.length];
            String imageUrl = "";
            for (int x = 0; x < address.length; x++) {
                order[x] = "localhost:8088/upload/images/" + address[x];
                System.out.println(order[x]);
                imageUrl = imageUrl + order[x] + ",";
            }
            merchants.get(i).setState_message_addr(imageUrl);
            //System.out.println(imageUrl);
        }
        }
        map.put("merchant",merchants);
        return map;
    }

    /**
    * 方法实现说明  管理员审核商家
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/11 16:08
    */
    @RequestMapping(value = "managerReviewMerchant",method = RequestMethod.GET)
    @ResponseBody
    public Map managerReviewMerchant(Managemer managemer,String state){
        Map<String,Object>map=new HashMap<>();
        //String state=String.valueOf(1);
        managemer.setOperate_type("审核商家");
        //设置日期格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // new Date()为获取当前系统时间
        managemer.setOperate_time(df.format(new Date()));
        int num=managerService.insertReviewMerchantMessage(managemer);
        if (num>0){
            int number=managerService.updateReviewMerchantMessage(managemer.getMid(),state);
            if (number>0){
                map.put("status","0");
                map.put("message","操作成功");
            }else {
                map.put("status","1");
                map.put("message","操作失败");
            }
        }else {
            map.put("status","1");
            map.put("message","操作失败");
        }
        return map;
    }


}
