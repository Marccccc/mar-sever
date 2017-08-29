package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("role")
public class Role implements Serializable{

    private static final long serialVersionUID = 4128043745147699080L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private String describe;

    /**
     * 公共操作字段
     */
    @TableField(value="update_user",strategy= FieldStrategy.IGNORED)
    private long updateUser;
    @TableField(value="update_time",strategy= FieldStrategy.IGNORED)
    private Date updateTime;
    @TableField(value="create_user",strategy= FieldStrategy.IGNORED)
    private long createUser;
    @TableField(value="create_time",strategy= FieldStrategy.IGNORED)
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
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