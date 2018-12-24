package com.stack;

import com.pojo.Order;

import java.util.Stack;

/**
* @Description:    类作用描述
* @Author:         jhao
* @CreateDate:     2018/12/24 12:30
* @UpdateUser:     jhao
* @UpdateDate:     2018/12/24 12:30
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Tmp {

    public static Stack<Order> stack;
    private static Tmp tmp;

    private  Tmp(){

        stack = new Stack<>();
    }

    public static Tmp getTmp(){
        if(tmp == null){
            tmp = new Tmp();
        }

        return tmp;
    }

}
