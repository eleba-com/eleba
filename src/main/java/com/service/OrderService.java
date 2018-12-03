package com.service;

import com.pojo.Order;

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



}
