package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 项目相应体默认配置
 * @author cyc
 */
@Data
@TableName("default_response_body")
public class DefaultResponseBody {

    @TableId(value="id", type= IdType.AUTO)
    private String id;

    @Length(min = 4,max = 12,message = "默认返回体应为2-8位字符")
    private String name;

    @TableField(value = "project_id",el = "project.id")
    private Project project;

    /**
     * 默认Json格式
     */
    private String defaultJson;

}
