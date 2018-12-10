package com.service;

import com.pojo.Order;
import org.aspectj.weaver.ast.Or;

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

}
