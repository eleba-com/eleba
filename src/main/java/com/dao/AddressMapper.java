package com.dao;

import com.pojo.Address;

public interface AddressMapper {
    int insert(Address record);

    int insertSelective(Address record);
}