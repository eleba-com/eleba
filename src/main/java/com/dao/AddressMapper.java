package com.dao;

import com.pojo.Address;

public interface AddressMapper {

    int insert(Address record);

    int insertSelective(Address record);

    /**
     * 方法实现说明   删除用户地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 19:29
     */
    int delCustmerAddr(Integer id);


/**
* 方法实现说明  查找用户地址
* @author：      jiehao
* @return：
* @exception：
* @date：       2018/11/29 20:17
*/
    Address findCustmerAddr(Integer uId);

    /**
    * 方法实现说明  用户修改地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 20:47
    */
    int updateCustmerAddr(Address address);


    /**
     * 方法实现说明   改地址为默认地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/17 16:38
     */
    int updateCusAddrDefault(Address address);

    /**
     * 方法实现说明  改原有默认地址为普通地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/17 16:50
     */
    int updateCusAddrCommon(Address address);

    /**
     * 方法实现说明  找原来默认地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/17 17:03
     */
    Address findAddressDefault(Integer uId);
}