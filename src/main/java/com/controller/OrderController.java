package com.controller;

import com.pojo.Order;
import com.pojo.Orderitem;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @Description:    订单控制类
* @Author:         jhao
* @CreateDate:     2018/11/30 11:13
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:13
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Controller
@RequestMapping("")
public class OrderController {

    @Autowired
    OrderService orderService;
    /**
    * @Description:    下单
    * @Author:         jhao
    * @CreateDate:     2018/11/30 16:54
    * @UpdateUser:     jhao
    * @UpdateDate:     12-7
    * @UpdateRemark:   更改下单逻辑，优化下单过程
    * @Version:        1.0
    */
    //old paramOrderitem[] orderitems,double total_price,int uid,String addr
    @ResponseBody
    @RequestMapping("insertOrder")
    public Map insertOrder(Order order){
        Map<String,Object> map = new HashMap<>();
        if(orderService.insert(order)){
            map.put("message","successful");
        }else {
            map.put("message","error");
        }

        return map;
    }

    /**
     * 取消订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 21:04
     */
    @ResponseBody
    @RequestMapping("cancelOrder")
    public Map cancelOrder(Order order){

        Map<String,Object> map = new HashMap<>();
        if(orderService.deleteOrderById(order)){
            map.put("message","sucessful");
        }else {
            map.put("message","error");
        }

        return map;
    }

    /**
     * 查看订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/7 10:46
     */
    @ResponseBody
    @RequestMapping("checkOrder")
    public Map checkOrder(Order order){

        Map<String,Object> map = new HashMap<>();
       List<Order> orderList = orderService.checkOrder(order.getUid());
        if (orderList!=null){
            map.put("order",orderList);
        }else {
            map.put("message","error");
        }

        return map;
    }
}
