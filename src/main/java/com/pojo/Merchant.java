package com.pojo;

public class Merchant {
    private Integer id;

    private String tell;

    private String mtype;

    private String username;

    private String password;

    private String addr;

    private String headAddr;

    private String mlock;

    private String state;

    private String stateMessageAddr;

    private String passwordsalt;

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
        return mtype;
    }

    public void setMtype(String mtype) {
        this.mtype = mtype;
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

    public String getHeadAddr() {
        return headAddr;
    }

    public void setHeadAddr(String headAddr) {
        this.headAddr = headAddr;
    }

    public String getMlock() {
        return mlock;
    }

    public void setMlock(String mlock) {
        this.mlock = mlock;
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