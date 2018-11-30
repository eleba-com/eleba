package com.service;


import com.pojo.Address;
import com.pojo.Customer;
import org.springframework.stereotype.Service;

/**
* @Description:    用户service接口
* @Author:         jiehao
* @CreateDate:     2018/11/29 18:27
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/29 18:27
* @UpdateRemark:   修改内容
* @Version:        1.0
*/

public interface CustmerService {

    /**
    * 方法实现说明   新增用户
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 18:29
    */
    public int insert(Customer customer);


    /**
    * 方法实现说明 通过名字查找用户信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 18:30
    */
    public Customer findbyUserName(String userName);

    /**
    * 方法实现说明   用户新增地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 18:38
    */
    public int addCustmerAddr(Address address);

    /**
     * 方法实现说明   删除用户地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 19:29
     */
    public int delCustmerAddr(Integer id);

    /**
    * 方法实现说明  查找用户地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 20:16
    */
    public Address findCustmerAddr(Integer uId);

    /**
    * 方法实现说明  用户修改地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 20:46
    */
    public int updateCustmerAddr(Address address);


    /**
    * 方法实现说明   修改用户信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 21:06
    */
    public int updateCustmerMessage(Customer customer);

    /**
     * 方法实现说明  查找用户信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 21:45
     */
    public Customer findCustmerMessager(Integer id);
}
