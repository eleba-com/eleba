package com.service;

import com.pojo.*;

import java.util.List;

/**
* @Description:    管理员service接口
* @Author:         jiehao
* @CreateDate:     2018/11/30 17:30
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/30 17:30
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface ManagerService {


    /**
    * 方法实现说明  通过商家名字找管理员
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:30
    */
    public Manager findManagerByName(String username);


    /**
    * 方法实现说明  管理员注册
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:30
    */
    public int addManager(Manager manager);

    /**
    * 方法实现说明   记录管理员管理用户的操作
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 20:22
    */
    public int insertMangerCus(Managecus managecus);


    /**
    * 方法实现说明  管理员封号(用户)
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 21:36
    */
    public int updateCusLock(Integer uId,Integer clock);

    /**
    * 方法实现说明   记录管理员管理商家的操作
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/3 8:43
    */
    public int insertManagerMer(Managemer managemer);


    /**
    * 方法实现说明   管理员封号(商家)
    * @author：      jiehao
    * @return：      
    * @exception：
    * @date：       2018/12/3 9:46
    */
    public int updateMerLock(Integer mId,String mLock);

    /**
    * 方法实现说明  查找顾客注册总人数
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/7 15:28
    */
    public int findCustmerTotal();


    /**
    * 方法实现说明   分页查找顾客信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/7 16:06
    */
    public List<Customer> managerFindCustmer(Integer startPos,Integer pageSize);


    /**
    * 方法实现说明  查找注册商家总数量
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 8:56
    */
    public int findMerchantTotal();

    /**
    * 方法实现说明  分页查找商家信息
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 8:56
    */
    public List<Merchant> managerFindMerchant(Integer startPos,Integer pageSize);

    /**
    * 方法实现说明  查看所有用户信息（可以带条件查询）
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/10 17:06
    */
    public List<Customer> managerFindAllCustmer( Customer customer);

    /**
     * 方法实现说明  查看所有商家信息（可以带条件查询）
     * @author：      jiehao
     * @return：
     * @exception：
     * @date：       2018/12/10 17:21
     */
    public List<Merchant> managerFindAllMerchant(Merchant merchant);
}
