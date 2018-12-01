package com.controller;

import com.pojo.Orderitem;
import com.service.OrderItemService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.nativejdbc.OracleJdbc4NativeJdbcExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.event.ObjectChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
* @Description:    订单项控制类
* @Author:         jhao
* @CreateDate:     2018/11/30 11:13
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:13
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class OrderItemController {

    @Autowired
    OrderItemService orderItemService;


    /**
     * 在购物车添加一条记录
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 14:58
     */
    @RequestMapping("addOrderItem")
    @ResponseBody
    public Map addOrderItem(Orderitem orderitem){

        Map<String,Object> map = new HashMap<>();
        if(orderItemService.insert(orderitem)){
            map.put("message","成功添加到购物车内！");

        }else{
            map.put("message","无法添加！");
        }
        return map;
    }

    /**
     * 减少购物车内某个商品的一个计数
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:19
     */
    @ResponseBody
    @RequestMapping("deleteOneById")
    public Map deleteOneById(Orderitem orderitem){
        Map<String,Object> map = new HashMap<>();
        if(orderItemService.deleteOneById(orderitem)){
            map.put("message","successful");
        }else{
            map.put("message","error");
        }

        return map;

    }

    @ResponseBody
    @RequestMapping("cancelOrderItem")
    public Map cancelOrderItem(Orderitem orderitem){
        Map<String,Object> map = new HashMap<>();
        if(orderItemService.cancel(orderitem)){
            map.put("message","successful");
        }else {
            map.put("message","error");
        }

        return map;
    }
}
