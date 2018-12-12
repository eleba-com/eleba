package com.dao;

import com.pojo.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    /**
    * 方法实现说明  通过名字查找用户信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/29 21:07
    */
    Customer findByUserName(String userName);

    /**
     * 方法实现说明  查找用户信息
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/11/29 21:45
     */
    Customer findCustmerMessager(Integer id);

    /**
    * 方法实现说明  管理员封号(用户)
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 21:36
    */
    int updateCusLock(@Param("uId") Integer uId,@Param("clock") Integer clock);

    /**
    * 方法实现说明    查找顾客注册总人数
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/7 15:32
    */
    int findCustmerTotal();


    /**
    * 方法实现说明   分页查找顾客信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/7 16:06
    */
    List<Customer> managerFindCustmer(@Param("startPos") Integer startPos,@Param("pageSize") Integer pageSize);

/**
* 方法实现说明 查看所有用户信息（可以带条件查询）
* @author：      jiehao
* @return：
* @exception：
* @date：       2018/12/10 17:05
*/
    List<Customer>managerFindAllCustmer(Customer customer);

    /**
     * 寻找这个电话是否已经注册了
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/12/12 9:22
     */
    Customer findTel(String tel);
}