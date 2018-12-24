package com.pojo;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
* @Description:    商家实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 16:53
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 16:53
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Merchant {
    /**
     * 商家id
     */
    private Integer id;
    /**
     * 商家电话号码
     */
    private String tell;
    /**
     * 经营类型
     */
    private String mType;
    /**
     * 登录昵称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 店铺地址
     */
    private String addr;
    /**
     * 头像地址
     */
    private String head_addr;
    /**
     *  0为正常，1为封号
     */
    private String mLock;
    /**
     * 0为未审核，1为已审核（打烊），2为不予通过审核，3为营业
     */
    private String state;
    /**
     * 审核图片地址
     */
    private String state_message_addr;
    /**
     * 盐杂质
     */
    private String passwordSalt;
    /**
     * 店铺名
     */
    private String shopName;
    /**
     * 销量
     */
    private String sale;
    /**
     * 上传文件
     */
    private MultipartFile imageFile;
    /**
     * 身份证名字
     */
    private String idName;

    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 评分
     */
    private double rate;
    /**
     * 起送价
     */
    private double starting_price;
    /**
     * 配送费
     */
    private double start_fee;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
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

    public MultipartFile getImageFile() {
        return imageFile;
    }
    public void setImageFile(MultipartFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getIdName() {
        return idName;
    }

    public void setIdName(String idName) {
        this.idName = idName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public double getStarting_price() {
        return starting_price;
    }

    public void setStarting_price(double starting_price) {
        this.starting_price = starting_price;
    }

    public double getStart_fee() {
        return start_fee;
    }

    public void setStart_fee(double start_fee) {
        this.start_fee = start_fee;
    }
}