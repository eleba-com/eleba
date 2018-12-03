package com.dao;

import com.pojo.Orderitem;

import java.util.List;

public interface OrderitemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Orderitem record);

    int insertSelective(Orderitem record);

    Orderitem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Orderitem record);

    int updateByPrimaryKey(Orderitem record);

    List<Orderitem> listAll(int oid);
}