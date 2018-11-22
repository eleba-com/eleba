package com.util;

import org.apache.shiro.authc.UsernamePasswordToken;

public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {
    public UsernamePasswordCaptchaToken(){
        super();
    }
    public UsernamePasswordCaptchaToken(String username, String password) {
     super(username ,password);


}
}
