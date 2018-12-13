package com.pojo;
/**
* @Description:    评论实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 17:06
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 17:06
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Comments {
    /**
     * 评论id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 评论时间
     */
    private String comment_time;
    /**
     * 商家id
     */
    private Integer mid;
    /**
     * 订单id
     */
    private Integer oid;
    /**
     * 评论内容
     */
    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getComment_time() {
        return comment_time;
    }

    public void setComment_time(String comment_time) {
        this.comment_time = comment_time;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }
}