package com.controller;

import com.pojo.Order;
import com.pojo.Orderitem;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

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

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    ProductService productService;

    /**
    * @Description:    下单
    * @Author:         jhao
    * @CreateDate:     2018/11/30 16:54
    * @UpdateUser:     jhao
    * @UpdateDate:     12-10
    * @UpdateRemark:   更改下单逻辑，包含了订单项的改变
    * @Version:        2.0
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
     * 取消订单 逻辑待改
     * 这里取消了的订单在订单项的状态里算是已经结算了的，需要加一个操作去修改这个订单项的状态
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
     * @param   order
     * @return
     * @exception
     * @date        2018/12/7 10:46
     * @Update  V2 查看的是最新三条已经完成的订单
     *
     */
    @ResponseBody
    @RequestMapping("checkOrder")
    public Map checkOrder(Order order){

        Map<String,Object> map = new HashMap<>();
       List<Order> orderList = orderService.checkOrder(order.getUid());
        if (orderList!=null){
            //在这里将所有的orderItem查出来一并返回给前端
            //这边是可以整合到OrderItemService中的！
            Iterator<Order> iter = orderList.iterator();

            List<Map> orderitems = new ArrayList<>();
            while(iter.hasNext()){
                String s = iter.next().getOiId();
                String[] strs = s.split(",");
                Map<Integer,Object> mapOrderItem = new HashMap<>();
                for(int i=0;i<strs.length;i++){
                    //这里逐个做查询
                    Orderitem orderitem = orderItemService.checkDetails(Integer.parseInt(strs[i]));

                    //去数据库找图
                    String addr = productService.getAddress(orderitem.getPid());
                    System.out.println("addr = "+ addr);
                    orderitem.setPhoto_addr(addr);
                    mapOrderItem.put(i,orderitem);
                }
                orderitems.add(mapOrderItem);
            }
            System.out.println("到这里了啊");
            map.put("orders",orderList);
            map.put("orderItemList",orderitems);
        }else {
            map.put("message","error");
        }

        return map;
    }
}
