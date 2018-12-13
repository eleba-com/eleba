package com.pojo;

import java.util.Date;

/**
* @Description:    用户管理实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 16:50
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 16:50
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Managecus {
    /**
     * 管理员id
     */
    private Integer aid;
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 操作时间
     */
    private String operate_time;
    /**
     * 操作类型
     */
    private String operate_type;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getOperate_type() {
        return operate_type;
    }

    public void setOperate_type(String operate_type) {
        this.operate_type = operate_type;
    }
}