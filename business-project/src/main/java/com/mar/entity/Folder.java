package com.mar.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * 树节点中的文件夹
 * @author cyc
 */
@Data
@TableName("node")
public class Folder extends BaseNode{
    /**
     * 文件夹节点描述
     */
    private String description;
}
