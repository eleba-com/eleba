package com.pojo;

public class Product {
    private Integer id;

    private String name;

    private Long price;

    private String photo_addr;

    private Integer mid;

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