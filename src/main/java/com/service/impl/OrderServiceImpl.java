package com.service.impl;

import com.dao.OrderMapper;
import com.pojo.Order;
import com.pojo.Orderitem;
import com.service.OrderItemService;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
* @Description:    OrderServiceImpl
* @Author:         jhao
* @CreateDate:     2018/11/30 11:20
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:20
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderItemService orderItemService;
    /**
     * 添加一个订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @UpdateRemark:   V4 需求更变
     * @date    更新时间    18-12-17
     */
    @Override
    public boolean insert(Order order) {
        //12-7 使用util下date与pojo整合

        //12-17更改需求
        Orderitem[] orderitems = null;

        orderitems = order.getOrderitems();
//        Iterator<Orderitem> iter =orderitems.iterator();
//        while(iter.hasNext()){
//            orderItemService.addOrderItem(iter.next());
//        }
        //这里还没有将uid填补进去

        if(orderitems!=null){
            for (int i=0;i<orderitems.length;i++){
                orderitems[i].setUid(order.getUid());
                orderItemService.addOrderItem(orderitems[i]);
            }
        }

        List<Orderitem> orderitems1 = orderItemService.getOrderItemId(order.getUid());
        System.out.println("ids = "+orderitems1.toString());
        //这里整合订单项的所有id到order表的oi_id
        StringBuffer oi_id = new StringBuffer();
        Iterator<Orderitem> iter1 = orderitems1.iterator();
        while(iter1.hasNext()){

            oi_id.append(iter1.next().getId());
            oi_id.append(",");
        }

        if (oi_id.equals("[]")){
            System.out.println("订单项id无法获取");
        }


        System.out.println("sb.toString = " + oi_id.toString());
        order.setOiId(oi_id.toString());

        //这里还没有修改
        try{
            orderMapper.inserted(order);
            //这里还要修改订单项的状态
            if(orderItemService.updateStatus1(order.getUid())!=0){
                return true;
            }else {
                System.out.println("订单项状态修改失败，但已经下单了");
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除一个订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:45
     */
    @Override
    public boolean deleteOrderById(Order order) {
        try{
            //orderMapper.deleteOrderById(order);
            return  true;

        }catch (Exception e){
            return false;
        }

    }

    /**
     * 查看完成的最新三条订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @Update      v2.0查看完成的最新三条订单
     * @date        2018/12/7 10:53
     */
    @Override
    public List<Order> checkOrder(int uid) {
        List<Order> lists = null;
        lists = orderMapper.checkOrder(uid);
        if (lists!=null){
            //debug
//            Iterator<Order> iter = lists.iterator();
//            while(iter.hasNext()){
//                System.out.println(iter.next());
//                System.out.println();
//            }
        }
        return lists;
    }

    /**
     * 通过订单id修改订单状态
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 10:17
     */
    @Override
    public boolean receiveOrder(int id) {
        try{
            orderMapper.receiveOrder(Integer.valueOf(id));

            return true;
        }catch (Exception e){

            e.printStackTrace();
            return false;
        }

    }

    /**
     * 商家获取某些条件的订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 11:39
     */
    @Override
    public List<Order> getOrders(Integer mid, String stated) {
        return orderMapper.getOrders(Integer.valueOf(mid),stated);
    }

    /**
     * 获取订单id
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/20 10:28
     */
    @Override
    public Integer getOrderId() {
        return orderMapper.getOrderId()-1;
    }

    @Override
    public int changeOrderState(Order order) {
        return orderMapper.changeOrderState(order);
    }

    @Override
    public List<Order> check3Order(int uid) {
        return orderMapper.check3Order(uid);
    }

    /**
     * 方法实现说明  根据id查找某个订单
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/20 10:00
     */
    @Override
    public Order findOrder(Integer id) {
        return orderMapper.findOrder(id);
    }

    /**
     * 方法实现说明  用户付款修改状态
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/20 10:14
     */
    @Override
    public int updateOrder(Order order) {
        return orderMapper.updateOrder(order);
    }

    /**
     * 方法实现说明   插入订单地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/24 16:00
     */
    @Override
    public int updateOrderAddr(Order order) {
        return orderMapper.updateOrderAddr(order);
    }
}
