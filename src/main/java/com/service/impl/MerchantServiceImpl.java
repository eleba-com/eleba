package com.service.impl;

import com.dao.MerchantMapper;
import com.pojo.Merchant;
import com.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
* @Description:    类作用描述
* @Author:         jhao
* @CreateDate:     2018/11/24 10:13
* @UpdateUser:     jhao
* @UpdateDate:     2018/11/24 10:13
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
@Service
public class MerchantServiceImpl implements MerchantService{

    @Autowired
    MerchantMapper merchantMapper;

    /**
     * 通过类型返回商铺list
     * @author      jhao
     * @param
     * @return      
     * @exception   
     * @date        2018/11/24 10:13
     */
    public List<Merchant> listMerchantByType(String mType){
        return merchantMapper.listMerchantByType(mType);
    }

    /**
     *  返回所有店铺类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 10:04
     */
    public List<String> listMerType(){
        return merchantMapper.listMerType();
    };


}
