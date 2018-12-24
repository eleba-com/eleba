package com.service.impl;

import com.dao.MerchantMapper;
import com.dao.ProductMapper;
import com.pojo.Merchant;
import com.pojo.Product;
import com.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description:    类作用描述
* @Author:         jhao 、jiehao
* @CreateDate:     2018/11/24 10:13
* @UpdateUser:     jhao、jiehao
* @UpdateDate:     2018/11/29 11:19
* @UpdateRemark:   增加查找商家登录名
* @Version:        1.0
*/
@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    MerchantMapper merchantMapper;

    @Autowired
    ProductMapper productMapper;

    /**
     * 通过类型返回商铺list
     * @author      jhao
     * @param
     * @return      
     * @exception   
     * @date        2018/11/24 10:13
     */
    @Override
    public List<Merchant> listMerchantByType(String mType){
        return merchantMapper.listMerchantByType(mType);
    }

    /**
     *  返回所有店铺类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 10:04
     */
    @Override
    public List<String> listMerType(){
        return merchantMapper.listMerType();
    }



  /**
  * 方法实现说明       通过登录名查找商家信息
  * @author：      jiehao
  * @return：
  * @exception：
  * @date：       2018/11/29 11:17
  */
    @Override
    public Merchant findByMerchantName(String userName) {
        return merchantMapper.findByMerchantName(userName);
    }



    /**
    * 方法实现说明   通过店铺名字查找商家id
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 15:29
    */
    @Override
    public int merchantFindId(String shopName) {
        return merchantMapper.merchantFindId(shopName);
    }

    /**
    * 方法实现说明    通过店铺id查找菜式
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 15:45
    */
    @Override
    public Product merchantFindProduct(Integer mid) {
        return productMapper.findProductMessage(mid);
    }

    /**
     * 方法实现说明   查找用户信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 22:03
     */
    @Override
    public Merchant findMerchantMessage(Integer id) {
        return merchantMapper.findMerchantMessage(id);
    }

    /**
    * 方法实现说明   商家注册
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 10:12
    */
    @Override
    public int insertMerchant(Merchant merchant) {
        return merchantMapper.insertSelective(merchant);
    }
    /**
     * 方法实现说明  查找店铺名是否重复-
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/21 9:40
     */
    @Override
    public Merchant findListMerchantByName(String shopName) {
        return merchantMapper.findListMerchantByName(shopName);
    }

    /**
     * 方法实现说明  更新商家信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/21 9:47
     */
    @Override
    public int updateMerchantMessage(Merchant merchant) {
        return merchantMapper.updateByPrimaryKeySelective(merchant);
    }

    @Override
    public int merchantOpenOrShoring(Merchant merchant) {
        return merchantMapper.merchantOpenOrShoring(merchant);
    }


}
