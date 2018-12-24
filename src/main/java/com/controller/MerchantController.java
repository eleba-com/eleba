package com.controller;

import com.pojo.Merchant;
import com.pojo.Product;
import com.service.MerchantService;
import com.service.OrderService;
import com.util.PrimaryKeyUtil;
import com.util.RetryLimitHashedCredentialsMatcher;
import com.util.Upload.UoloadImage;
import com.util.UsernamePasswordCaptchaToken;
import com.util.config.ImageConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.shiro.subject.Subject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
* @Description:    商家控制类
* @Author:         jhao 、jiehao
* @CreateDate:     2018/11/26 9:52
* @UpdateUser:     jhao、jiehao
* @UpdateDate:     2018/11/29 10:32
* @UpdateRemark:   修改了description，增加商家注册，登录方法
* @Version:        2.0
*/
@Controller
@RequestMapping("")
public class MerchantController {

    @Autowired
    private RetryLimitHashedCredentialsMatcher matcher;
    @Autowired
    MerchantService merchantService;

    @Autowired
    OrderService orderService;

    private UoloadImage uploadImage;
    /**
     * 直接返回所有商家类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 10:05
     */
    @RequestMapping("listMerType")
    @ResponseBody
    public Map listMerType(){
        Map<String,Object> map = new HashMap<>();
        List<String> list =  merchantService.listMerType();

        Iterator<String> ite = list.iterator();
        //小内容
//        Map<String,Object> map3 = new HashMap<>();
        List<Map<String,Object>> tmp_list = new LinkedList<>();
        int i = 0;
        while(ite.hasNext()){
            Map<String,Object> types = new HashMap<>();
            types.put("id",i);
            types.put("mtype",ite.next());
            i++;
            try{
                tmp_list.add(types);
                map.put("allMerTypes",tmp_list);

            }catch (Exception e){
                e.printStackTrace();
                System.out.println("出错了");
            }
        }
//        for(int j=0;j<list.size();j++){
//            map3.put("id",j);
//            map3.put("mtype",)
//        }
//        map3.put("types",types);

        return map;
    }

    /**
    * 通过食物类型查找商家用户名和销量
    * @author：      jiehao、jhao
    * @param
    * @return：
    * @exception：
    * @date：       2018/11/27 10:26
     * @Update    V2 添加生成评价的方法
    */
    @RequestMapping(value = "listMerchantByType",method = RequestMethod.GET)
    @ResponseBody
    public Map listMerchantByType(String mType){
        Map<String,Object> map = new HashMap<>();
        List<Merchant> merchants = merchantService.listMerchantByType(mType);
        if(merchants!=null){
            //v2
            Iterator<Merchant> iter = merchants.iterator();
            while(iter.hasNext()){
                double rate = Math.random()+4.0;
                rate=Math.floor(rate*10)/10;
                iter.next().setRate(rate);
            }
            map.put("merchants",merchants);
        }else {
            System.out.println("无此类型商家");
        }
        //key是rate value是自动生成的评分加入到map中4.0-5.0

        return map;
    }


    /**
    * 方法实现说明  商家注册
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 10:46
    */
    @RequestMapping(value = "MerchantRegister",method = RequestMethod.GET)
    @ResponseBody
    public Map MerchantRegister(Merchant merchant,HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        Merchant record=merchantService.findByMerchantName(merchant.getUsername());
        Merchant shopname=merchantService.findListMerchantByName(merchant.getShopName());
        Merchant user=merchantService.findMerchantByTel(merchant.getTell());
        if (record == null){
                if(shopname ==null) {
                    if (user == null) {
                    merchant.setPasswordSalt(PrimaryKeyUtil.getAllRandomString(4));
                    merchant.setPassword(new SimpleHash(matcher.getHashAlgorithmName(), merchant.getPassword(),
                            merchant.getPasswordSalt(), matcher.getHashIterations()).toString());
                    int number = merchantService.insertMerchant(merchant);
                    if (number > 0) {
                        map.put("status", "0");
                        map.put("message", "用户注册成功");
                    } else {
                        map.put("status", "1");
                        map.put("message", "用户注册失败");
                    }
                }
                else {
                        map.put("status","4");
                        map.put("message","电话号码重复");
                    }
                }else {
                    map.put("status","3");
                    map.put("message","店铺名重复");
                }
        }else{
            map.put("record",record);
            map.put("status","2");
            map.put("message","用户名重复");
        }
        return map;
    }

 /**
 * 方法实现说明    商家登录
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 15:12
 */
    @RequestMapping(value = "MerchantLogin",method = RequestMethod.GET)
    @ResponseBody
    public Map MerchantLogin(Merchant merchant, Integer role, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        UsernamePasswordCaptchaToken token=new UsernamePasswordCaptchaToken(merchant.getUsername(),
                merchant.getPassword(),role);
        Subject subject=SecurityUtils.getSubject();
        HttpSession session=request.getSession();
        try {
            subject.login(token);
            Merchant record = merchantService.findByMerchantName(merchant.getUsername());
            session.setAttribute("id",record.getId());
            session.setAttribute("userName",record.getUsername());
            map.put("record",record);
            map.put("status","0");
            map.put("message","登录成功");

        }catch (UnknownAccountException e){
            map.put("status","1");
            map.put("message","账号或密码错误");
        }catch (IncorrectCredentialsException e){
            map.put("status","2");
            map.put("message","账号或密码错误");
        }catch (DisabledAccountException e){
            map.put("status","3");
            map.put("message","管理员被封号");
        }catch (UnsupportedTokenException e){
            map.put("status","4");
            map.put("message","商家还没通过审核");
        }catch ( ExcessiveAttemptsException e){
            map.put("status","5");
            map.put("message","商家不予用过审核");

        }
        return map;
    }

 /**
 * 方法实现说明    通过商家用户名查找商家所有菜名(有错误，弃用)
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 15:16
 */

 @RequestMapping(value = "MerchantFindProduct",method = RequestMethod.GET)
 @ResponseBody
 public Map MerchantFindProduct(String shopName){
     Map<String,Object> map=new HashMap<>();
     //查找商家id
    int shopId=merchantService.merchantFindId(shopName);
    //查找商家菜式
     Product product = merchantService.merchantFindProduct(shopId);
     String addr=product.getPhoto_addr();
     if(addr!=null){
         String[] address = addr.split(",");
         String[] order = new String[address.length];
         String imageUrl = "";
         for (int x = 0; x < address.length; x++) {
             order[x] = "http:/localhost:8088/upload/images/" + address[x];
             System.out.println(order[x]);
             imageUrl = imageUrl + order[x] + ",";
         }
         product.setPhoto_addr(imageUrl);
     }
     map.put("product",product);
     return map;
 }
/**
* 方法实现说明   查找商家用户信息
* @author：      jiehao
* @return：
* @exception：
* @date：       2018/11/29 22:03
*/
 @RequestMapping(value = "findMerchantMessage",method = RequestMethod.GET)
 @ResponseBody
 public Map findMerchantMessage(Merchant recond){
     Map<String,Object> map = new HashMap<>();
     Merchant merchant=null;
     if(recond.getShopName()!=null){
         merchant=merchantService.findByMerchantName(recond.getShopName());
         if(merchant.getState_message_addr()!=null){
             merchant.setState_message_addr(ImageConfig.imageUrl+merchant.getState_message_addr());
         }if (merchant.getHead_addr()!=null){
             merchant.setHead_addr(ImageConfig.imageUrl+merchant.getHead_addr());
         }
     }else if (recond.getId()!=null){
         merchant=merchantService.findMerchantMessage(recond.getId());
         if(merchant.getState_message_addr()!=null){
             merchant.setState_message_addr(ImageConfig.imageUrl+merchant.getState_message_addr());
         }if (merchant.getHead_addr()!=null){
             merchant.setHead_addr(ImageConfig.imageUrl+merchant.getHead_addr());
         }
     }
     map.put("merchant",merchant);
     return map;
 }

 /**
 * 方法实现说明  商家更新信息
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/12/21 9:37
 */
 @RequestMapping(value = "updateMerchantMessage",method = RequestMethod.GET)
 @ResponseBody
 public Map updateMerchantMessage(Merchant merchant){
     Map<String,Object>map=new HashMap<>();
     int num=merchantService.updateMerchantMessage(merchant);
     if (num>0){
         map.put("status","0");
         map.put("message","修改成功");
     }else {
         map.put("status","1");
         map.put("message","修改失败");
     }

     return map;
 }


 /**
 * 方法实现说明   商铺营业,打烊
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/12/24 8:36
 */
 @RequestMapping(value = "merchantOpenOrShoring",method = RequestMethod.GET)
 @ResponseBody
 public Map merchantOpenOrShoring(Merchant merchant){
     Map<String,Object>map=new HashMap<>();
     System.out.println(merchant.getState());
     //商铺打烊
     if (merchant.getState().equals("3")){
         merchant.setState("1");
         System.out.println(merchant.getId());
         int num=merchantService.merchantOpenOrShoring(merchant);
         if (num>0){
             map.put("status","0");
             map.put("message","商铺已打烊");
         }else {
             map.put("status","1");
             map.put("message","打烊失败");
         }
     }
     //商铺营业
     else if (merchant.getState().equals("1")){
         merchant.setState("3");
         int num=merchantService.merchantOpenOrShoring(merchant);
         if (num>0){
             map.put("status","0");
             map.put("message","商铺开始营业");
         }else {
             map.put("status","1");
             map.put("message","营业失败");
         }
     }
     return map;
 }

}
