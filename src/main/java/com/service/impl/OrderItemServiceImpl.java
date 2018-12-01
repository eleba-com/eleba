package com.service.impl;

import com.dao.OrderitemMapper;
import com.pojo.Order;
import com.pojo.Orderitem;
import com.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    OrderItemServiceImpl
* @Author:         jhao
* @CreateDate:     2018/11/30 11:21
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/30 11:21
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class OrderItemServiceImpl implements OrderItemService{


    @Autowired
    OrderitemMapper orderitemMapper;
    /**
     * 添加一个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 11:33
     */
    @Override
    public boolean insert(Orderitem orderitem) {
        try{
            orderitemMapper.insertSelective(orderitem);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }


    /**
     * 减少一个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 11:33
     */
    @Override
    public boolean deleteOneById(Orderitem orderitem) {
        if(orderitem.getNumbers()-1!=0){
            orderitem.setNumbers(orderitem.getNumbers()-1);
        }else{
            return false;
        }
        try{
            orderitemMapper.updateByPrimaryKeySelective(orderitem);
            return  true;

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }

    /**
     * 删除整个订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:29
     */
    @Override
    public boolean cancel(Orderitem orderitem) {
        try{
            orderitemMapper.deleteByPrimaryKey(orderitem.getId());
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 显示订单里所有的订单项
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/30 15:37
     */
    @Override
    public List<Orderitem> listAll(Order order) {
        return orderitemMapper.listAll(order.getId());
    }
}
