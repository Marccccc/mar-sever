package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("token")
public class Token implements Serializable {

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @TableField("is_validity")
    private boolean validity;//是否有效口令

    private int userId;//用户ID

    private String userName;//用户名称

    private Date createTime;//口令激活时间

    private Date destroyTime;//口令失效时间

}