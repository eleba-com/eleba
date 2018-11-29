package com.controller;

import com.pojo.Merchant;
import com.pojo.Product;
import com.service.MerchantService;
import com.util.UsernamePasswordCaptchaToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.shiro.subject.Subject;
import javax.servlet.http.HttpServletRequest;
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

    /**
     * 直接返回所有商家类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 10:05
     */
    @Autowired
    MerchantService merchantService;
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

        return map;
    }

    /**
    * 通过食物类型查找商家用户名和销量
    * @author：      jiehao
    * @param
    * @return：
    * @exception：
    * @date：       2018/11/27 10:26
    */
    @RequestMapping(value = "listMerchantByType",method = RequestMethod.GET)
    @ResponseBody
    public Map listMerchantByType(String mType){
        Map<String,Object> map = new HashMap<>();
        List<Merchant> merchants = merchantService.listMerchantByType(mType);
        if(merchants!=null){
            map.put("merchants",merchants);

            System.out.println("能获取merchant "+ merchants.toString());
        }else {
            System.out.println("无此类型商家");
        }
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
    public Map MerchantRegister(Merchant merchant){
        Map<String,Object> map=new HashMap<>();
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
        Session session= (Session) request.getSession();
        try {
            subject.login(token);
            session.setAttribute("userName",merchant.getUsername());
            map.put("userName",session);
            map.put("status",0);

        }catch (UnknownAccountException e){
            map.put("status",1);
        }catch (IncorrectCredentialsException e){
            map.put("status",2);
        }
        return map;
    }

 /**
 * 方法实现说明    通过商家用户名查找商家所有菜名
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
     map.put("product",product);
     return map;
 }
/**
* 方法实现说明   查找用户信息
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
     if(recond.getUsername()!=null){
         merchant=merchantService.findByMerchantName(recond.getUsername());
     }else if (recond.getId()!=null){
         merchant=merchantService.findMerchantMessage(recond.getId());
     }
     map.put("merchant",merchant);
     return map;
 }



}
