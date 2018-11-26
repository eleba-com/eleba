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

    private String stateMessageAddr;

    private String passwordsalt;

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

    public String getMtype() {
        return mType;
    }

    public void setMtype(String mtype) {
        this.mType = mtype;
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



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateMessageAddr() {
        return stateMessageAddr;
    }

    public void setStateMessageAddr(String stateMessageAddr) {
        this.stateMessageAddr = stateMessageAddr;
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }
}