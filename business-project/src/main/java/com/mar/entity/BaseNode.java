package com.mar.entity;

import lombok.Data;

/**
 * 目录树节点
 * @author cyc
 */
@Data
public abstract class BaseNode {
    private String name;
    private BaseNode fatherNode;
}
