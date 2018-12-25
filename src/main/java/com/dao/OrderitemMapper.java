package com.dao;

import com.pojo.Orderitem;
import com.pojo.Product;

import java.util.List;

public interface OrderitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    Orderitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);

    List<Orderitem> listAll(int oid);

    /**
     * 添加一个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 8:37
     */
    int addOrderItem(Orderitem orderitem);

    /**
     * 根据订单状态和订单的用户id获取订单项id
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 8:39
     */
    List<Orderitem> getOrderItemId(int uid);


    /**
     * 更改订单项的status状态，o->1
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 9:29
     */
    int updateStatus1(int uid);

    /**
     * 查看订单详细信息
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 11:49
     */
    Orderitem checkDetails(int id);


    /**
     * getProductName
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/25 16:27
     */
    Product getProductName(int id);
}