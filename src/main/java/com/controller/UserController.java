package com.controller;

import com.pojo.Merchant;
import com.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;


/**
* @Description:    用户界面控制类
* @Author:         jhao
* @CreateDate:     2018/11/24 9:46
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/24 9:46
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class UserController {

    @RequestMapping(value = "test",method = RequestMethod.POST)
    @ResponseBody
    public Map test(MultipartFile file){
        System.out.println("test --------"+file);
        Map<String,Object>map=new HashMap<>();
        map.put("message","成功了");
        return map;
    }

    //test get order id
    @RequestMapping(value = "test1",method = RequestMethod.GET)
    @ResponseBody
    public Map test1(){
        System.out.println("test --------");
        Map<String,Object>map=new HashMap<>();
        map.put("message","成功了");
        return map;
    }

}
