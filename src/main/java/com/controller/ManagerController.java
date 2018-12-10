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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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





}