package com.util;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @Description:    密码验证
* @Author:         jiehao
* @CreateDate:     2018/11/27 8:29
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/27 8:29
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    // 密码错误次数缓存
    private Cache<String, AtomicInteger> passwordRetryCache;

    // spring-shiro.xml 中的 bean id="credentialsMatcher" 配置
    public RetryLimitHashedCredentialsMatcher() {
//        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }




}