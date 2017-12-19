package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
import java.util.List;

/**
 * 基础用户类
 */
@Data
@TableName("user")
public class User{

    @TableId(value="id", type= IdType.AUTO)
    private int id;
    //登录账户
    @Length(min = 3,max = 12,message = "登录账户为4-12位")
    private String account;
    //用户名称
    @Length(min = 2,max = 12,message = "用户名为4-12位")
    private String name;
    //密码
    @Length(min = 4,max = 12,message = "密码为4-12位")
    private String password;
    //是否可用
    @TableField("is_status")
    private boolean status;
    //电话
    private String telephone;
//    //所属公司
//    @TableField(value = "company_id",el = "company.id")
//    private Company company;
    //所属角色
    @TableField(exist = false)
    private List<Role> roles;
    //最后登录时间
    @TableField("last_login_time")
    private Date lastLoginTime;

    /**
     * 公共操作字段
     */
    @TableField(strategy= FieldStrategy.IGNORED)
    private long updateUser;
    @TableField(strategy=FieldStrategy.IGNORED)
    private Date updateTime;
    @TableField(strategy=FieldStrategy.IGNORED)
    private long createUser;
    @TableField(strategy=FieldStrategy.IGNORED)
    private Date createTime;
}
