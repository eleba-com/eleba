package com.service;

import com.pojo.Merchant;
import com.pojo.Product;

import java.util.List;

/**
 *
 *  商家service类
 *  @author          jhao、jiehao
 *  @CreateDate:    2018/11/24
 *  @UpdateUser:    jiehao
 * * @UpdateDate:     2018/11/29 11:14
 * * @UpdateRemark:   增加查找用户名接口
 * * @Version:        2.0
 */
public interface MerchantService {

    /**
     * 通过类型返回商家
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/24 9:55
     */
    public List<Merchant> listMerchantByType(String mType);

    /**
     * 直接返回所有商家类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 9:59
     */

    public List<String> listMerType();

    /**
     *    通过登录名查找商家信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 11:17
     */
    public Merchant findByMerchantName(String userName);


    /**
    * 通过店铺名查找id
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 15:29
    */
    public int merchantFindId(String shopName);

    /**
    *   通过店铺id查找菜式
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 15:46
    */
    public Product merchantFindProduct(Integer id);

    /**
     * 方法实现说明   查找商家用户信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 22:03
     */
    public Merchant findMerchantMessage(Integer id);

    /**
    * 方法实现说明    新增商家用户
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 10:06
    */
   public int insertMerchant(Merchant merchant);

   /**
   * 方法实现说明  查找店铺名是否重复
   * @author：      jiehao
   * @return：
   * @exception：
   * @date：       2018/12/21 9:40
   */
   public Merchant findListMerchantByName(String shopName);

   /**
   * 方法实现说明  更新商家信息
   * @author：      jiehao
   * @return：
   * @exception：
   * @date：       2018/12/21 9:47
   */
   public int updateMerchantMessage(Merchant merchant);


   public int merchantOpenOrShoring(Merchant merchant);
}
