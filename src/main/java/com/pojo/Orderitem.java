package com.pojo;
/**
* @Description:    购物车实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 17:00
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 17:00
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Orderitem {
    /**
     * 购物车id
     */
    private Integer id;
    /**
     * 商品id
     */
    private Integer pid;
    /**
     * 订单id
     */
    private Integer oid;
    /**
     * 数量
     */
    private Integer numbers;

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