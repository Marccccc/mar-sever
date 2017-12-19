package com.mar.dto;

import lombok.Data;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>分页接受传出类</p>
 * @author cyc
 * @since 2017-07-11
 */
@Data
public class Page<T>{

    private long total; //总条数
    private int size = 10;//默认条数
    private int current = 1;//当前页

    private String orderMethod;//排序参数
    private String orderByField;//排序参数
    
    private Map<String, Object> conditions = new HashMap<>();//查询参数
    
    private List<T> records;

}
