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


    Product findProductMessage(Integer mid);



    /**
     * 获取商家所有的商品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:26
     */
    List<Product> listAllProduct(Integer mid);

    /**
     * 根据产品id找出这个商品的图片地址
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 15:36
     */
    String getAddress(Integer pid);

    /**
     * getProductName
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/24 19:27
     */
    Product getProductName(int pid);
}