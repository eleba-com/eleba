package com.pojo;

public class Orderitem {
    private Integer id;

    private Integer pid;

    private Integer oid;

    private Integer numbers;

    /**
     *
     *  12-7  jhao
     *  更新说明，添加了三个字段uid，status，price
     */
    private Integer uid;

    private String status1;

    private Long price;

    //仅在pojo中添加一个存储地址的变量
    private String photo_addr;

    public String getPhoto_addr() {
        return photo_addr;
    }

    public void setPhoto_addr(String photo_addr) {
        this.photo_addr = photo_addr;
    }

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status) {
        this.status1 = status;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }
}