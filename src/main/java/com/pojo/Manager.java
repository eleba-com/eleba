package com.pojo;
/**
* @Description:    管理员实体类
* @Author:         jiehao
* @CreateDate:     2018/12/13 16:52
* @UpdateUser:     jiehao
* @UpdateDate:     2018/12/13 16:52
* @UpdateRemark:   修改内容
* @Version:        1.0
*/
public class Manager {
    /**
     * 管理员id
     */
    private Integer id;
    /**
     * 登录昵称
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 盐杂质
     */
    private String passwordSalt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }
}