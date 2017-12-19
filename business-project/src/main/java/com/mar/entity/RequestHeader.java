package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 项目配置表
 * @author marccc
 */
@Data
@TableName("project")
public class RequestHeader {

    private String name;
    private String value;
    private String description;

}
