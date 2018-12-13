package com.pojo;
/**
* @Description:    活动实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 17:05
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 17:05
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Activity {


    /**
     * 活动id
     */
    private Integer id;
    /**
     * 商家id
     */
    private Integer mid;
    /**
     * 活动内容
     */
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}