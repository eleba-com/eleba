package com.service.impl;

import com.dao.ProductMapper;
import com.pojo.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @Description:    产品接口实现类
* @Author:         jhao
* @CreateDate:     2018/11/29 8:47
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/29 8:47
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductMapper productMapper;

    /**
     * 添加商品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 8:53
     */
    public boolean addProduct(Product product){
        try{
            productMapper.insert(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }

    /**
     * 通过商品id删除商品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:35
     */
    @Override
    public boolean deleteProduct(Product product) {
        try{
            productMapper.deleteByPrimaryKey(product.getId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     *  通过商品id更新产品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:32
     */
    @Override
    public boolean updateProduct(Product product) {
        try{
            productMapper.updateByPrimaryKey(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * list该商家所有的产品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:02
     */
    @Override
    public List<Product> listAllProduct(Product product) {
        System.out.println(productMapper.listAllProduct(product.getMid()).toString());
        return productMapper.listAllProduct(product.getMid());
    }


    /**
     * 通过商品的id获取该商品的图片url
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 15:21
     */
    @Override
    public String getAddress(int pid) {
        return productMapper.getAddress(Integer.valueOf(pid));
    }
}
