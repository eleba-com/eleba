package com.service.impl;
import com.dao.*;
import com.pojo.Managecus;
import com.pojo.Managemer;
import com.pojo.Manager;
import com.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.management.counter.perf.PerfInstrumentation;


/**
* @Description:    管理员service实现类
* @Author:         jiehao
* @CreateDate:     2018/11/30 17:31
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/30 17:31
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private ManagecusMapper managecusMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private ManagemerMapper managemerMapper;

    @Autowired
    private MerchantMapper merchantMapper;


    /**
    * 方法实现说明    通过名字找管理员
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:31
    */
    @Override
    public Manager findManagerByName(String username) {
        return managerMapper.findManagerByName(username);
    }

    /**
    * 方法实现说明  管理员注册
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:31
    */
    @Override
    public int addManager(Manager manager) {
        return managerMapper.insert(manager);
    }
    /**
    * 方法实现说明   记录管理员管理用户的操作
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 21:20
    */
    @Override
    public int insertMangerCus(Managecus managecus) {
        return managecusMapper.insertSelective(managecus);
    }

    /**
    * 方法实现说明   管理员封号
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 21:36
    */
    @Override
    public int updateCusLock(Integer uId, Integer clock) {
        return customerMapper.updateCusLock(uId,clock);
    }

    /**
    * 方法实现说明     记录管理员管理商家操作
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/12/3 8:44
    */
    @Override
    public int insertManagerMer(Managemer managemer) {
        return managemerMapper.insertSelective(managemer);
    }

    @Override
    public int updateMerLock(Integer mId, String mLock) {
        return merchantMapper.updateMerLock(mId,mLock);
    }
}
