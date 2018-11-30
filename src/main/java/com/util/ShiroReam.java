package com.util;


import com.pojo.Customer;
import com.pojo.Merchant;
import com.service.CustmerService;
import com.service.MerchantService;
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

   @Autowired
   private MerchantService merchantService;


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


        return simpleAuthorizationInfo;
    }

    /**
    * 方法实现说明    登录验证
    * @author：      jiehao
    * @param
    * @return：
    * @exception：
    * @date：       2018/11/29 10:24
    */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordCaptchaToken token= (UsernamePasswordCaptchaToken) authenticationToken;
        String username=token.getUsername();
        int role=token.getRole();
        System.out.println(role);
        if(role==0){
            Customer customer=custmerService.findbyUserName(username);
            if (customer == null) {
                throw new UnknownAccountException();
            }
            ByteSource salt = ByteSource.Util.bytes(customer.getPasswordsalt());
            //验证密码，需要在applicationContent.xml（shiro.xml）说明加密算法
            return new SimpleAuthenticationInfo(customer.getUsername(), customer.getPassword(), salt, getName());
        }else if(role==1){
            System.out.println("==================");
            Merchant merchant =merchantService.findByMerchantName(username);
            if(merchant ==null){
                throw new UnknownAccountException();
            }
            ByteSource salt =ByteSource.Util.bytes(merchant.getPasswordSalt());
            //验证密码
            return new SimpleAuthenticationInfo(merchant.getUsername(),merchant.getPassword(),salt,getName());
        }else if(role== 2){
            System.out.println("==================");
        }
       return new SimpleAuthenticationInfo();
    }
}
