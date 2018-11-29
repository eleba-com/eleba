package com.dao;

import com.pojo.Product;

import java.util.List;

public interface ProductMapper {
    /**
     * 这是自动生成的方法 在service里调用了
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 14:57
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 这是自动生成的方法 在service里调用了
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 14:57
     */
    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * 获取商家所有的商品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:26
     */
    List<Product> listAllProduct(Integer mid);
}