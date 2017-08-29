package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("file")
public class UploadFile implements Serializable{

    private static final long serialVersionUID = 5076477416062292956L;

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件存储地址
     */
    private String path;

    /**
     * 文件依赖ID
     */
    private String dependId;

    /**
     * 公共操作字段
     */
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDependId() {
        return dependId;
    }

    public void setDependId(String dependId) {
        this.dependId = dependId;
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