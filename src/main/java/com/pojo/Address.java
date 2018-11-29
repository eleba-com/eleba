package com.pojo;

public class Address {

    private Integer id;

    private Integer uId;

    private String addr;

    private Integer aDefault;

    private String contract_man;

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