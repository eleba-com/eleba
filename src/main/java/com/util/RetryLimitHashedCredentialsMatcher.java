package com.util;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 密码验证
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    // 密码错误次数缓存
    private Cache<String, AtomicInteger> passwordRetryCache;

    // spring-shiro.xml 中的 bean id="credentialsMatcher" 配置
    public RetryLimitHashedCredentialsMatcher() {
//        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }




}