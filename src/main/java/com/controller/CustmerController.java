package com.controller;

import com.pojo.Address;
import com.pojo.Customer;
import com.pojo.Order;
import com.service.CustmerService;
import com.util.PrimaryKeyUtil;
import com.util.RetryLimitHashedCredentialsMatcher;
import com.util.UsernamePasswordCaptchaToken;
import com.util.config.AddressDefaultConfig;
import com.util.config.ImageConfig;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import javax.servlet.http.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    用户控制类
* @Author:         jiehao
* @CreateDate:     2018/11/29 10:29
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/29 10:29
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class CustmerController {

    @Autowired
    private RetryLimitHashedCredentialsMatcher matcher;

    @Autowired
    private CustmerService custmerService;


    /**
    * 方法实现说明  用户注册
    * @author：      jiehao
    * @param
    * @return：
    * @exception：
    * @date：       2018/11/29 10:22
    */
    @RequestMapping(value = "register",method = RequestMethod.GET)
    @ResponseBody
    public Map registerCustmer(Customer customer) {
        //Customer record=new Customer();
        System.out.println("进入了方法");
        Map<String, Object> map = new HashMap<String, Object>();
        Customer user = custmerService.findbyUserName(customer.getUsername());
        Customer record = custmerService.findCustmerBytel(customer.getTell());
        if (user == null) {
            if (record == null) {
            customer.setPasswordsalt(PrimaryKeyUtil.getAllRandomString(4));
            System.out.println(customer.getPasswordsalt());
            //二次加密;
            customer.setPassword(new SimpleHash(matcher.getHashAlgorithmName(), customer.getPassword(), customer.getPasswordsalt(),
                    matcher.getHashIterations()).toString());
            System.out.println(customer.getPassword());
            if (custmerService.insert(customer) == 1) {
                //注册成功
                map.put("status", "0");
                map.put("message", "注册成功");
            } else {
                //注册失败
                map.put("status", "1");
                map.put("message", "注册失败");
            }
        }
        else {
                map.put("status","3");
                map.put("message","电话号码重复");
            }
    }
        else {
            //用户名重复
            map.put("status","2");
            map.put("message","用户名重复");
        }
        return map;
    }

    /**
    * 方法实现说明    用户登录
    * @author：      jiehao
    * @param
    * @return：
    * @exception：
    * @date：       2018/11/29 10:23
    */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public Map login(Customer customer, Integer role, HttpServletRequest request){
        Map<String,Object> map = new HashMap<String, Object>();
        UsernamePasswordCaptchaToken token=new UsernamePasswordCaptchaToken(customer.getUsername(),
                customer.getPassword(),role);
        Subject subject=SecurityUtils.getSubject();
        HttpSession session=  (HttpSession)request.getSession();
        try {
            subject.login(token);
            Customer record=custmerService.findbyUserName(customer.getUsername());
            session.setAttribute("username",record.getUsername());
            session.setAttribute("id",record.getId());
            map.put("status","0");
            map.put("message","登录成功");
            map.put("record",record);
            //账号不存在
        }catch (UnknownAccountException e){
            map.put("status","1");
            map.put("message","账号或密码错误");
            //密码错误
        }catch (IncorrectCredentialsException e){
            map.put("status","2");
            map.put("message","账号或密码错误");
        } catch (DisabledAccountException e){
            map.put("status","3");
            map.put("message","用户已被封号");
        }
        return map;
    }
 /**
 * 方法实现说明   增加用户外卖地址
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 16:27
 */
 @RequestMapping(value = "addCustmerAddr",method = RequestMethod.GET)
 @ResponseBody
 public Map addCustmerAddr(Address address){
     Map<String,Object>map =new HashMap<>();
     int number=custmerService.addCustmerAddr(address);
     if (number ==1){
         map.put("status","0");
         map.put("message","新增成功");
     }else {
         map.put("status","1");
         map.put("message","增加失败");
     }
     return map;
 }

 /**
 * 方法实现说明   删除用户地址
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 19:29
 */
 @RequestMapping(value = "delCustmerAddr",method = RequestMethod.GET)
 @ResponseBody
 public Map delCustmerAddr(Address address){
     Map<String,Object> map=new HashMap<>();
     int number=custmerService.delCustmerAddr(address.getId());
     if(number>0){
         map.put("status","0");
         map.put("message","删除成功");
     }else {
         map.put("status","1");
         map.put("message","删除失败");
     }
     return map;
 }

/**
* 方法实现说明   查找用户地址
* @author：      jiehao
* @return：
* @exception：
* @date：       2018/11/29 20:15
*/
 @RequestMapping(value = "findCustmerAddr",method = RequestMethod.GET)
 @ResponseBody
 public Map findCustmerAddr(Address address){
     Map<String,Object> map=new HashMap<>();
     //Address addr=custmerService.findCustmerAddr(address.getuId());
     List<Address> addrs=custmerService.findCustmerAddr(address.getuId());
     map.put("address",addrs);
     return map;
 }

 /**
 * 方法实现说明   用户修改地址
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 20:45
 */
 @RequestMapping(value = "updateCustmerAddr",method = RequestMethod.GET)
 @ResponseBody
 public Map updateCustmerAddr(Address address){
     Map<String,Object> map=new HashMap<>();
     int number = custmerService.updateCustmerAddr(address);
     if(number>0){
         map.put("status","0");
         map.put("message","修改用户地址成功");
     }else {
         map.put("status","1");
         map.put("message","修改用户地址失败");
     }
     return map;
 }
 /**
 * 方法实现说明   用户修改收货地址为默认状态(参数：id，uId)
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/12/17 16:00
 */
 @RequestMapping(value = "updateCusAddrDefault",method = RequestMethod.GET)
 @ResponseBody
 public Map updateCusAddrDefault(Address address){
     Map<String,Object>map=new HashMap<>();
     Address record=custmerService.findAddressDefault(address.getuId());
     if (record!=null){
         address.setaDefault(1);
         int num=custmerService.updateCusAddrCommon(address);
         if (num>0){
             address.setaDefault(AddressDefaultConfig.aDefault);
             int number=custmerService.updateCusAddrDefault(address);
             if (number>0){
                 map.put("status","0");
                 map.put("message","设置成功");
             }
             else {
                 record.setaDefault(AddressDefaultConfig.aDefault);
                 custmerService.updateCusAddrDefault(record);
                 map.put("status","1");
                 map.put("message","设置失败");
             }
         }else {
             record.setaDefault(AddressDefaultConfig.aDefault);
             custmerService.updateCusAddrDefault(record);
             map.put("status","1");
             map.put("message","设置失败");
         }
     }
     else {
         address.setaDefault(AddressDefaultConfig.aDefault);
         int number=custmerService.updateCusAddrDefault(address);
         if (number>0){
             map.put("status","0");
             map.put("message","设置成功");
         }
         else {
             map.put("status","1");
             map.put("message","设置失败");
         }
     }
     return map;
 }




 /**
 * 方法实现说明  用户修改信息
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 21:05
 */
 @RequestMapping(value = "updateCustmerMessage",method = RequestMethod.GET)
 @ResponseBody
 public Map updateCustmerMessage(Customer customer){
     Map<String,Object> map=new HashMap<>();
     if (customer.getPassword()!=null){
         customer.setPasswordsalt(PrimaryKeyUtil.getAllRandomString(4));
         customer.setPassword(new SimpleHash(matcher.getHashAlgorithmName(), customer.getPassword(), customer.getPasswordsalt(),
                 matcher.getHashIterations()).toString());
     }
     int number=custmerService.updateCustmerMessage(customer);
     if(number > 0){
         map.put("status","0");
         map.put("message","修改用户信息成功");
     }else {
         map.put("status","1");
         map.put("message","修改用户信息失败");
     }
     return map;
 }

 /**
 * 方法实现说明  查找用户信息（可以带条件查询）
 * @author：      jiehao
 * @return：
 * @exception：
 * @date：       2018/11/29 21:45
 */
 @RequestMapping(value = "findCustmerMessager",method = RequestMethod.GET)
 @ResponseBody
 public Map findCustmerMessager(Customer record){
     Map<String,Object> map=new HashMap<>();
     Customer customer=null;
     if(record.getUsername()!=null){
         customer=custmerService.findbyUserName(record.getUsername());
         if(customer.getHeadAddr()!=null){
             customer.setHeadAddr(ImageConfig.imageUrl+customer.getHeadAddr());
         }
     }else if(record.getId()!=null){
         customer=custmerService.findCustmerMessager(record.getId());
         if(customer.getHeadAddr()!=null){
             customer.setHeadAddr(ImageConfig.imageUrl+customer.getHeadAddr());
         }
     }
     map.put("customer",customer);
     return map;
 }


}
