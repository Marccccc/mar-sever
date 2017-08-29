package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>基础用户类</p>
 */
@Data
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

}
