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

    private int role;

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public UsernamePasswordCaptchaToken(){
        super();
    }
    public UsernamePasswordCaptchaToken(String username, String password,int role) {
     super(username ,password);
     this.role=role;
}
}
