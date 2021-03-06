package com.pojo;

import java.util.Date;
import java.util.List;

/**
* @Description:    订单实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 16:58
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 16:58
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Order {

    private String merchantName;

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    private String head_addr;

    public String getHead_addr() {
        return head_addr;
    }

    public void setHead_addr(String head_addr) {
        this.head_addr = head_addr;
    }

    private String pNameAndNumner;

    public String getpNameAndNumner() {
        return pNameAndNumner;
    }

    public void setpNameAndNumner(String pNameAndNumner) {
        this.pNameAndNumner = pNameAndNumner;
    }

    /**
     * 订单id
     */

    //12-17 整合订单项列表
    private Orderitem[] orderitems;

    public Orderitem[] getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Orderitem[] orderitems) {
        this.orderitems = orderitems;
    }

    private Integer id;
    /**
     * 购物车id
     */
    private String oiId;
    /**
     * 下单时间
     */
    private Date create_time;
    /**
     * 顾客ID
     */
    private Integer uid;
    /**
     * 地址
     */
    private String addr;
    /**
     * 金额
     */
    private Float total_price;
    /**
     * 状态
     */
    private String stated;

    /**
     * 商家id
     */
    private Integer mid;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getStated() {
        return stated;
    }

    public void setStated(String stated) {
        this.stated = stated;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOiId() {
        return oiId;
    }

    public void setOiId(String oiId) {
        this.oiId = oiId;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }
}