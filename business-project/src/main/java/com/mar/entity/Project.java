package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

/**
 * 项目基础表
 * @author marccc
 */
@Data
@TableName("project")
public class Project{

    @TableId(value="id", type= IdType.AUTO)
    private String id;

    /**
     * 项目邀请编码
     */
    private String invitationCode;

    /**
     * 项目地址
     */
    private String url;

    /**
     * 项目名称
     */
    @Length(min = 4,max = 12,message = "项目名称应为4-12位字符")
    private String name;

    /**
     * 公共操作字段
     */
    @TableField(value = "create_user", strategy= FieldStrategy.IGNORED)
    private long updateUser;
    @TableField(value = "create_time", strategy=FieldStrategy.IGNORED)
    private Date updateTime;
    @TableField(strategy=FieldStrategy.IGNORED)
    private long createUser;
    @TableField(strategy=FieldStrategy.IGNORED)
    private Date createTime;

}
