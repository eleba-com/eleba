package com.dao;

import com.pojo.Merchant;

import java.util.List;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
    
    /**
     * 方法实现说明
     * @author      jhao
     * @param       
     * @return      
     * @exception   
     * @date        2018/11/24 10:08
     */
    List<Merchant> listMerchantByType(String mType);
}