package com.controller;

import com.dao.CustomerMapper;
import com.pojo.Customer;
import com.service.CustmerService;
import com.util.sendMessage.SendMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    使用手机号码注册并登陆
* @Author:         jhao
* @CreateDate:     2018/11/23 22:07
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/23 22:07
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class SendMessageController {

    @Autowired
    CustmerService custmerService;
    /**
     * 这个方法用于获取验证码
     * @author      jhao
     * @param       tel
     * @return      java.util.Map
     * @exception
     * @date        2018/11/23 22:56
     */
    @RequestMapping(value = "registerByTel",method = RequestMethod.GET)
    @ResponseBody
    public Map registerByTel(String tel){
            BigInteger b = new BigInteger(tel);

            System.out.println(b);
            System.out.println(b.intValue());
            //int tels = Integer.valueOf(tel);
            return SendMessages.sendMessage(b);
    }


    @ResponseBody
    @RequestMapping("loginByTel")
    public Map loginByTel(String tel){
        Map<String,Object> map = new HashMap<>();
        Customer customer = custmerService.findTel(tel);
        if(customer!=null){
            map.put("tag",true);
            map.put("message",customer);
        }else {
            map.put("tag",false);
            map.put("message","error");
        }
        return  map;
    }

}
