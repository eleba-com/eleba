package com.dao;

import com.pojo.Order;

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
}