package com.controller;

import com.pojo.Merchant;
import com.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

/**
* @Description:    商铺控制类
* @Author:         jhao
* @CreateDate:     2018/11/26 9:52
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/26 9:52
* @UpdateRemark:   修改内容
* @Version:        1.0
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




}
