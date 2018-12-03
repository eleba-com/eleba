package com.service;

import com.pojo.Order;
import com.pojo.Orderitem;

import java.util.List;

/**
* @Description:    OrderItemService
* @Author:         jhao
* @CreateDate:     2018/11/30 11:19
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:19
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface OrderItemService {

    /**
     * 添加一个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 11:30
     */
    public boolean insert(Orderitem orderitem);

    /**
     * 减少一个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 11:32
     */
    public boolean deleteOneById(Orderitem orderitem);

    /**
     * 删除整个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:29
     */
    public boolean cancel(Orderitem orderitem);

    /**
     * 显示订单里所有的订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:37
     */
    public List<Orderitem> listAll(Order order);
}
