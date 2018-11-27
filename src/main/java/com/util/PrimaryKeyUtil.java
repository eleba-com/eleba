package com.util;

import java.util.Random;

/**
* @Description:    生成X位随机数
* @Author:         jiehao
* @CreateDate:     2018/11/27 8:30
* @UpdateUser:     jiehao
* @UpdateDate:     2018/11/27 8:30
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class PrimaryKeyUtil {

    private static Random ran=new Random();


    //返回指定位数（x）的随机字符串
    public static String getAllRandomString(int x){
        char[] c = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f','g','h','i','j','k','l',
                'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        String str = "";
        for(int i=0; i<x; i++){
            int num = ran.nextInt(c.length);
            str += c[num];
        }
        return str;
    }
}
