package com.pojo;
/**
* @Description:    商品实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 17:03
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 17:03
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Product {
    /**
     * 商品id
     */
    private Integer id;
    /**
     * 产品名字
     */
    private String name;
    /**
     * 产品价格
     */
    private Long price;
    /**
     * 产品图片地址
     */
    private String photo_addr;
    /**
     * 商家id
     */
    private Integer mid;
    /**
     * 剩余数量
     */
    private Integer acount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPhoto_addr() {
        return photo_addr;
    }

    public void setPhoto_addr(String photo_addr) {
        this.photo_addr = photo_addr;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getAcount() {
        return acount;
    }
    public void setAcount(Integer acount) {
        this.acount = acount;
    }
}