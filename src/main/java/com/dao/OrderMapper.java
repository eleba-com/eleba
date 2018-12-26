package com.dao;

import com.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * 自己写的mapper配置 添加一条数据到订单表中
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/7 10:22
     */
    int inserted(Order order);

    /**
     *  顾客查看自己的订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/7 10:50
     */
    List<Order> checkOrder(int uid);

    /**
     * 通过订单id修改订单状态
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 10:17
     */
    int receiveOrder(Integer id);

    /**
     * 商家获取某些条件的订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/11 11:39
     */
    //List<Order> getOrders(@Param("mid") Integer mid, @Param("stated") String stated);
    List<Order> getOrders(@Param("mid") Integer mid);
    /**
     * 方法实现说明  根据id查找某个订单
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/20 10:00
     */
    Order findOrder(Integer id);


    /**
     * 方法实现说明  用户付款修改状态
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/20 10:14
     */
    int updateOrder(Order order);

    /**
     * 获取订单id
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/20 10:27
     */
    Integer getOrderId();


    /**
     * 改订单状态
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/24 11:04
     */
    int changeOrderState(Order order);

    /**
     *  顾客查看自己最新的三个订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/7 10:50
     */
    List<Order> check3Order(int uid);


    /**
    * 方法实现说明   插入订单地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/24 16:00
    */
    int updateOrderAddr(Order order);
}