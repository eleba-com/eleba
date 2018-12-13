package com.pojo;

/**
* @Description:    地址实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 17:06
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 17:06
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Address {

    /**
     *    地址id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer uId;
    /**
     * 地址
     */
    private String addr;
    /**
     * 默认（0为默认，1为不默认）
     */
    private Integer aDefault;
    /**
     *  联系人
     */
    private String contract_man;
    /**
     * 联系电话
     */
    private String contract_tel;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getaDefault() {
        return aDefault;
    }

    public void setaDefault(Integer aDefault) {
        this.aDefault = aDefault;
    }

    public String getContract_man() {
        return contract_man;
    }

    public void setContract_man(String contract_man) {
        this.contract_man = contract_man;
    }

    public String getContract_tel() {
        return contract_tel;
    }

    public void setContract_tel(String contract_tel) {
        this.contract_tel = contract_tel;
    }
}