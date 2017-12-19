package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

/**
 * 项目配置表
 * @author marccc
 */
@Data
@TableName("project_variable")
public class ProjectVariable {

    @TableId(value="id", type= IdType.AUTO)
    private String id;

    /**
     * 变量表意值
     */
    private String filed;

    /**
     * 变量配置
     */
    private String value;

}
