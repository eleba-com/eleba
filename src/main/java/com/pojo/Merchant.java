package com.pojo;

public class Merchant {
    private Integer id;

    private String tell;

    private String mType;

    private String username;

    private String password;

    private String addr;

    private String head_addr;

    private String mLock;

    private String state;

    private String state_message_addr;

    private String passwordSalt;

    private String shopName;

    private String sale;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getHead_addr() {
        return head_addr;
    }

    public void setHead_addr(String head_addr) {
        this.head_addr = head_addr;
    }

    public String getmLock() {
        return mLock;
    }

    public void setmLock(String mLock) {
        this.mLock = mLock;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState_message_addr() {
        return state_message_addr;
    }

    public void setState_message_addr(String state_message_addr) {
        this.state_message_addr = state_message_addr;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
}