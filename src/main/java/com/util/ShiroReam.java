package com.util;


import com.alibaba.druid.sql.ast.statement.SQLIfStatement;
import com.pojo.Customer;
import com.pojo.Manager;
import com.pojo.Merchant;
import com.service.CustmerService;
import com.service.ManagerService;
import com.service.MerchantService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
* @Description:    shiro登录验证、权限分配
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
   @Autowired
   private ManagerService managerService;


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
        //用户登录
        if(role==0){
            Customer customer=custmerService.findbyUserName(username);
            if (customer == null) {
                throw new UnknownAccountException();
            }
            if(customer.getClock()==1){
                throw new DisabledAccountException();
            }
            ByteSource salt = ByteSource.Util.bytes(customer.getPasswordsalt());
            //验证密码，需要在applicationContent.xml（shiro.xml）说明加密算法
            return new SimpleAuthenticationInfo(customer.getUsername(), customer.getPassword(), salt, getName());
        }
        //商家登录
        else if(role==1){
            System.out.println("==================");
            Merchant merchant =merchantService.findByMerchantName(username);
            if(merchant ==null){
                throw new UnknownAccountException();
            }if(Integer.parseInt(merchant.getmLock())==1){
                throw new DisabledAccountException();
            }if(Integer.valueOf(merchant.getState())==0){
                throw new UnsupportedTokenException();
            }if(Integer.valueOf(merchant.getState())==2){
                throw new   ExcessiveAttemptsException();
            }
            ByteSource salt =ByteSource.Util.bytes(merchant.getPasswordSalt());
            //验证密码
            return new SimpleAuthenticationInfo(merchant.getUsername(),merchant.getPassword(),salt,getName());
        }
        //管理员登录
        else if(role== 2){
            System.out.println("==================");
            Manager manager=managerService.findManagerByName(username);
            if(manager==null){
                throw new UnknownAccountException();
            }
            ByteSource salt=ByteSource.Util.bytes(manager.getPasswordSalt());
            return new SimpleAuthenticationInfo(manager.getUsername(),manager.getPassword(),salt,getName());
        }
       return new SimpleAuthenticationInfo();
    }
}
