package com.util.config;

/**
* @Description:    订单状态常量接口
* @Author:         jhao
* @CreateDate:     2018/12/7 9:30
* @UpdateUser:     jhao
* @UpdateDate:     2018/12/7 9:30
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public interface OrderConfig {

    /**
     * 下单且未接单
     */
    public static String madeOrder = "0";

    /**
     * 已读
     */
    public static String readOrder = "1";

    /**
     * 已接单
     */
    public static String receivedOrder = "2";

    /**
     * 请求催单
     */
    public static String reminder = "3";

    /**
     * 申请退单
     */
    public static String refund = "4";

    /**
     * 已完成订单
     */
    public static String orderComplete = "5";

    /**
     * 已完成退单
     */
    public static String refunded = "6";
}
