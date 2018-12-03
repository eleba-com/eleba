package com.dao;

import com.pojo.Manager;
import com.pojo.Merchant;


public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);


    /**
    * 方法实现说明   通过名字找管理员
    * @author：      jiehao
    * @return：
    * @exception：
    * @date：       2018/11/30 17:32
    */
    Manager findManagerByName(String userName);



}