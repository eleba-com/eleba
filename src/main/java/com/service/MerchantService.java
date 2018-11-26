package com.service;

import com.pojo.Merchant;

import java.util.List;

/**
 * Created by jhao on 2018/11/24.
 *  商家service类
 *  @author jhao
 */
public interface MerchantService {

    /**
     * 通过类型返回商家
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/24 9:55
     */
    public List<Merchant> listMerchantByType(String mType);

    /**
     * 直接返回所有商家类型
     * @author      jhao
     * @param
     * @return
     * @exception
     * @date        2018/11/26 9:59
     */
    public List<String> listMerType();
}
