package com.service;

import com.pojo.Managecus;
import com.pojo.Managemer;
import com.pojo.Manager;

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


    public int updateMerLock(Integer mId,String mLock);
}
