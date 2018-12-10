package com.dao;

import com.pojo.Merchant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
    
    /**
     * 方法实现说明
     * @author      jhao
     * @param       
     * @return      
     * @exception   
     * @date        2018/11/24 10:08
     */
    List<Merchant> listMerchantByType(String mType);

    /**
     * 返回所有商家类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 14:51
     */
    List<String> listMerType();

    /**
    * 方法实现说明   通过登录名查找商家信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 11:22
    */
    Merchant findByMerchantName(String userName);


    /**
    * 方法实现说明   通过店铺名查找商家id
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 15:30
    */
    int merchantFindId(String shopName);

    /**
     * 方法实现说明   查找用户信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 22:03
     */
    Merchant findMerchantMessage(Integer id);

    /**
     * 方法实现说明   管理员封号(商家)
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/3 9:46
     */
    int updateMerLock(@Param("mId")Integer mId,@Param("mLock")String mLock);



    /**
    * 方法实现说明  查找商家总人数
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 9:00
    */
    public int findMerchantTotal();


    /**
    * 方法实现说明  分页查找商家信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 9:00
    */
    public List<Merchant> managerFindMerchant(@Param("startPos") Integer startPos, @Param("pageSize") Integer pageSize);

    /**
     * 方法实现说明  查看所有商家信息（可以带条件查询）
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/10 17:21
     */
    List<Merchant> managerFindAllMerchant(Merchant merchant);

}