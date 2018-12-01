package com.service.impl;

import com.pojo.Order;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    OrderService orderService;
    /**
     * 添加一个订单
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:45
     */
    @Override
    public boolean insert(Order order) {
        try{
            orderService.insert(order);
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
            orderService.deleteOrderById(order);
            return  true;

        }catch (Exception e){
            return false;
        }

    }
}
