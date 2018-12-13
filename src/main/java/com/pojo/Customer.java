package com.pojo;
/**
* @Description:    顾客实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 16:39
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 16:39
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Customer {
    /**
     * 用户id
     */
    private Integer id;
    /**
     * 用户电话号码
     */
    private String tell;
    /**
     * 登录昵称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 地址id（弃用）
     */
    private Integer addrId;
    /**
     * 头像地址
     */
    private String head_addr;
    /**
     * vip地址
     */
    private Integer vip;
    /**
     * 0为正常，1为封号
     */
    private Integer clock;
    /**
     * 盐杂质，后台生成
     */
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

    public Integer getAddrId() {
        return addrId;
    }

    public void setAddrId(Integer addrId) {
        this.addrId = addrId;
    }

    public String getHeadAddr() {
        return head_addr;
    }

    public void setHeadAddr(String headAddr) {
        this.head_addr = headAddr;
    }

    public Integer getVip() {
        return vip;
    }

    public void setVip(Integer vip) {
        this.vip = vip;
    }

    public Integer getClock() {
        return clock;
    }

    public void setClock(Integer clock) {
        this.clock = clock;
    }

    public String getPasswordsalt() {
        return passwordsalt;
    }

    public void setPasswordsalt(String passwordsalt) {
        this.passwordsalt = passwordsalt;
    }
}