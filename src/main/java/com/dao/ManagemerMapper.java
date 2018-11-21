package com.dao;

import com.pojo.Managemer;

public interface ManagemerMapper {
    int insert(Managemer record);

    int insertSelective(Managemer record);
}