package com.util;

/**
* @Description:
* @Author:         jiehao
* @CreateDate:     2018/11/27 8:28
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/27 8:28
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {
    public UsernamePasswordCaptchaToken(){
        super();
    }
    public UsernamePasswordCaptchaToken(String username, String password) {
     super(username ,password);


}
}
