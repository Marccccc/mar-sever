package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("file")
public class UploadFile {

    @TableId(value = "id", type = IdType.AUTO)
    private long id;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件存储地址
     */
    private String path;

    /**
     * 文件依赖ID
     */
    private String dependId;

    /**
     * 公共操作字段
     */
    @TableField(value = "create_user", strategy = FieldStrategy.IGNORED)
    private long createUser;
    @TableField(value = "create_time", strategy = FieldStrategy.IGNORED)
    private Date createTime;

}