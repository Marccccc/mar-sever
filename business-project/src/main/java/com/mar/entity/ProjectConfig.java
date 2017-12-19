package com.mar.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 项目基础配置表
 * @author marccc
 */
@Data
public class ProjectConfig {

    /**
     * 在项目中设置的默认相应体
     */
    private List<DefaultReponseBody> defaultResponseBody=new LinkedList<>();
    private Set<RequestHeader> headers=new HashSet<>();

}
