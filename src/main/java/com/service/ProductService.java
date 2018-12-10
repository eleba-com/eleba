package com.service;


import com.pojo.Product;

import java.util.List;

/**
* @Description:    产品接口
* @Author:         jhao
* @CreateDate:     2018/11/29 8:46
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/29 8:46
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface ProductService {

    /**
     * 添加商品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 8:53
     */
    public boolean addProduct(Product product);

    /**
     * 删除某个产品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:02
     */
    public boolean deleteProduct(Product product);

    /**
     * 更新某个产品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:02
     */
    public boolean updateProduct(Product product);

    /**
     * list该商家所有的产品
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/29 9:02
     */
    public List<Product> listAllProduct(Product product);

    /**
     * 通过商品的id获取该商品的图片url
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/10 15:19
     */
    public String getAddress(int pid);
}
