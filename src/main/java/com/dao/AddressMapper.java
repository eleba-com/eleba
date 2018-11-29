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
}