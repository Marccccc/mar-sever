package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@TableName("role")
public class Role implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    private String name;

    private String code;

    private String describe;
//
//    @TableField(value = "company_id", el = "company.id")
//    private Company company;//所属公司

    private List<Permission> permissions;

    /**
     * 公共操作字段
     */
    @TableField(strategy = FieldStrategy.IGNORED)
    private long updateUser;
    @TableField(strategy = FieldStrategy.IGNORED)
    private Date updateTime;
    @TableField(strategy = FieldStrategy.IGNORED)
    private long createUser;
    @TableField(strategy = FieldStrategy.IGNORED)
    private Date createTime;

}