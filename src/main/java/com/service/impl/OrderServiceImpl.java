package com.service.impl;

import com.dao.OrderMapper;
import com.pojo.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    /**
     * 添加一个订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @UpdateRemark:   12-7
     *                   1. 系统自动生成时间戳填入订单表中
     * @date        2018/11/30 15:45
     */
    @Override
    public boolean insert(Order order) {
        //12-7 使用util下date与pojo整合
        order.setCreate_time(new Date());
        try{
            orderMapper.inserted(order);
            return true;
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
     * 查看订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/7 10:53
     */
    @Override
    public List<Order> checkOrder(int uid) {
        return orderMapper.checkOrder(uid);
    }
}
