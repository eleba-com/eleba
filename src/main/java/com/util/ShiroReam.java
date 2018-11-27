package com.util;


import com.pojo.Customer;
import com.service.CustmerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @Description:    java类作用描述
* @Author:         jiehao
* @CreateDate:     2018/11/22 16:11
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/22 16:11
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class ShiroReam extends AuthorizingRealm {

   @Autowired
    private CustmerService custmerService;


   /**
   * 方法实现说明
   * @author      jiehao
   * @param
   * @return
   * @exception  ：分配权限
   * @date        2018/11/22 16:21
   */
   @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        String username=principalCollection.getPrimaryPrincipal().toString();
       // String roleName=SecurityUtils.getSubject().getSession().getAttribute("roleName").toString();
//        if(username.equals("杰")){
//            simpleAuthorizationInfo.addRole("管理员");
//            System.out.println(simpleAuthorizationInfo.getRoles());
//            simpleAuthorizationInfo.addStringPermission("admin:*");
//        }
//        else{
//            simpleAuthorizationInfo.addRole("普通用户");
//            simpleAuthorizationInfo.addStringPermission("admin:user:view");
//        }

        return simpleAuthorizationInfo;
    }

    //登陆验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordCaptchaToken token= (UsernamePasswordCaptchaToken) authenticationToken;
        String username=token.getUsername();
        Customer customer=custmerService.findbyUserName(username);
        if (customer == null) {
            throw new UnknownAccountException();
        }
        ByteSource salt = ByteSource.Util.bytes(customer.getPasswordsalt());

        System.out.println(token.getPassword());
        System.out.println(customer.getPassword());
        System.out.println(customer.getPasswordsalt());
        System.out.println(salt);
        //验证密码，需要在applicationContent.xml（shiro.xml）说明加密算法
        return new SimpleAuthenticationInfo(customer.getUsername(), customer.getPassword(), salt, getName());
    }
}
