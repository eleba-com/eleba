package com.pojo;

import java.util.Date;
import java.util.List;

public class Order {

    //12-17 整合订单项列表
    private Orderitem[] orderitems;

    public Orderitem[] getOrderitems() {
        return orderitems;
    }

    public void setOrderitems(Orderitem[] orderitems) {
        this.orderitems = orderitems;
    }

    private Integer id;

    private String oiId;

    private Date create_time;

    private Integer uid;

    private String addr;

    private Long total_price;

    private String stated;

    //12-11添加mid属性
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

    public Long getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Long total_price) {
        this.total_price = total_price;
    }
}