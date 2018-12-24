package com.service;

import com.pojo.Order;
import org.aspectj.weaver.ast.Or;

import java.util.Date;
import java.util.List;

/**
* @Description:    OrderService
* @Author:         jhao
* @CreateDate:     2018/11/30 11:19
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface OrderService {

    /**
     * 添加订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 11:22
     */
    public boolean insert(Order order);

    /**
     * 取消订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 11:23
     */
    public boolean deleteOrderById(Order order);

    /**
     *  查看订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/7 10:52
     */
    public List<Order> checkOrder(int uid);

    /**
     * 通过订单id修改订单状态
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 10:17
     */
    public boolean receiveOrder(int id);


    /**
     * 商家获取某些条件的订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 11:39
     */
    public List<Order> getOrders(Integer mid,String stated);


    /**
    * 方法实现说明  根据id查找某个订单
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/20 10:00
    */
    public Order findOrder(Integer id);

    /**
    * 方法实现说明  用户付款修改状态
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/20 10:14
    */
    public int updateOrder(Order order);

    /**
     * 获取订单id
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/20 10:27
     */
    public Integer getOrderId();


    /**
     * changeOrderState
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/24 11:05
     */
    public int changeOrderState(Order order);
}
