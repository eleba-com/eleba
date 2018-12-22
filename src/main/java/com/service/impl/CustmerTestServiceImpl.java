package com.service.impl;

import com.dao.AddressMapper;
import com.dao.CustomerMapper;
import com.pojo.Address;
import com.pojo.Customer;
import com.pojo.Order;
import com.service.CustmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
* @Description:    用户service接口实现类
* @Author:         jiehao
* @CreateDate:     2018/11/29 18:28
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/29 18:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class CustmerTestServiceImpl implements CustmerService {

    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private AddressMapper addressMapper;

    /**
    * 方法实现说明  新增用户
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 18:30
    */
    @Override
    public int insert(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
    * 方法实现说明   通过名字查找用户信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 18:39
    */
    @Override
    public Customer findbyUserName(String userName) {
        return customerMapper.findByUserName(userName);
    }

    /**
     * 方法实现说明   用户新增地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 18:38
     */
    @Override
    public int addCustmerAddr(Address address) {
        return addressMapper.insertSelective(address);
    }

    /**
     * 方法实现说明   删除用户地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 19:29
     */
    @Override
    public int delCustmerAddr(Integer id) {
        return addressMapper.delCustmerAddr(id);
    }


    /**
    * 方法实现说明  查找用户地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 20:16
    */
    @Override
    public List<Address> findCustmerAddr(Integer uId) {
        return addressMapper.findCustmerAddr(uId);
    }

    /**
    * 方法实现说明   用户修改地址
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 20:46
    */
    @Override
    public int updateCustmerAddr(Address address) {
        return addressMapper.updateCustmerAddr(address);
    }

    /**
    * 方法实现说明   用户修改信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 21:06
    */
    @Override
    public int updateCustmerMessage(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    /**
     * 方法实现说明  查找用户信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 21:45
     */
    @Override
    public Customer findCustmerMessager(Integer id) {
        return customerMapper.findCustmerMessager(id);
    }

    /**
     * 寻找这个电话是否已经注册了
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/12 9:22
     */
    @Override
    public Customer findTel(String tel) {
        return customerMapper.findTel(tel);
    }

    /**
     * 方法实现说明   改地址为默认地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/17 16:38
     */
    @Override
    public int updateCusAddrDefault(Address address) {
        return addressMapper.updateCusAddrDefault(address);
    }

    /**
     * 方法实现说明  改原有默认地址为普通地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/17 16:50
     */
    @Override
    public int updateCusAddrCommon(Address address) {
        return addressMapper.updateCusAddrCommon(address);
    }
    /**
     * 方法实现说明  找原来默认地址
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/17 17:03
     */
    @Override
    public Address findAddressDefault(Integer uId) {
        return addressMapper.findAddressDefault(uId);
    }
}
