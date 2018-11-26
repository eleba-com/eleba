package com.controller;


import com.pojo.Customer;
import com.service.CustmerService;
import com.util.PrimaryKeyUtil;
import com.util.RetryLimitHashedCredentialsMatcher;
import com.util.UsernamePasswordCaptchaToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("")
public class CustmerTest {

    @Autowired
    private RetryLimitHashedCredentialsMatcher matcher;

    @Autowired
    private CustmerService custmerService;


    @RequestMapping(value = "register",method = RequestMethod.GET)
    @ResponseBody
    public Map registerCustmer(Customer customer){
        //Customer record=new Customer();
        Map<String,Object> map = new HashMap<String, Object>();
//        customer.setUsername("jie");
//        customer.setPassword("1234");
        customer.setPasswordsalt(PrimaryKeyUtil.getAllRandomString(4));
        System.out.println(customer.getPasswordsalt());
        customer.setPassword(new SimpleHash(matcher.getHashAlgorithmName(),customer.getPassword(),customer.getPasswordsalt(),
                matcher.getHashIterations()).toString());//二次加密;
        System.out.println(customer.getPassword());
        if (custmerService.insert(customer)==1){
            map.put("status","0");
        }else {
            map.put("status","1");
        }
        return map;
    }

    @RequestMapping(value = "login",method = RequestMethod.GET)
    @ResponseBody
    public Map login(Customer customer){
        Map<String,Object> map = new HashMap<String, Object>();
        UsernamePasswordCaptchaToken token=new UsernamePasswordCaptchaToken(customer.getUsername(),customer.getPassword());
        Subject subject=SecurityUtils.getSubject();
        Session session=null;
        try {
            subject.login(token);
            map.put("status","0");
            //账号不存在
        }catch (UnknownAccountException e){
            map.put("status","1");
            //密码错误
        }catch (IncorrectCredentialsException e){
            map.put("status","2");

            char ch = 'a';




        }
        return map;

    }

}
