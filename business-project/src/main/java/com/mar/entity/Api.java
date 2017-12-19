package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * api主题
 * @author marccc
 */
@Data
@TableName("api")
public class Api extends BaseNode{

    @TableId(value="id", type= IdType.AUTO)
    private String id;

    /**
     * 请求名称
     */
    private String name;
    /**
     * 请求地址
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求方法体
     */
    private String formatter;

}
