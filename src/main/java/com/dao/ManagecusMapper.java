package com.dao;

import com.pojo.Managecus;

public interface ManagecusMapper {
    int insert(Managecus record);

    int insertSelective(Managecus record);
}