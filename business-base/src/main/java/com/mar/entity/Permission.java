package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
@TableName("permission")
public class Permission{

    @TableId(value = "code")
    private String code;

    private String name;

    private String description;

}