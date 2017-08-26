package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>基础用户类</p>
 */
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1470583504364159865L;

    @TableId(value="id", type= IdType.AUTO)
    private int id;

    private String account;//登录账户

    private String name;//用户名称

    private boolean status;//是否可用

    private String telephone;//电话

    private String password;//密码

    @TableField("last_login_time")
    private Date lastLoginTime;//最后登录时间

    /**
     * 公共操作字段
     */
    @TableField(value="update_user",strategy= FieldStrategy.IGNORED)
    private long updateUser;
    @TableField(value="update_time",strategy=FieldStrategy.IGNORED)
    private Date updateTime;
    @TableField(value="create_user",strategy=FieldStrategy.IGNORED)
    private long createUser;
    @TableField(value="create_time",strategy=FieldStrategy.IGNORED)
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(long updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(long createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
