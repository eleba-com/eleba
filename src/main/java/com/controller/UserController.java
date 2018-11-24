package com.controller;

import com.pojo.Merchant;
import com.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    @Autowired
    MerchantService merchantService;

    @RequestMapping(value = "listMerchantByType",method = RequestMethod.GET)
    @ResponseBody
    public Map listMerchantByType(String mType){
        Map<String,Object> map = new HashMap<>();

        List<Merchant> merchants = merchantService.listMerchantByType(mType);
        if(merchants!=null){
            map.put("merchants",merchants);
        }else {
            System.out.println("无此类型商家");
        }
        return map;
    }
}
