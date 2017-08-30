package com.mar.dto;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>分页接受传出类</p>
 * @author cyc
 * @since 2017-07-11
 */
public class Page<T>{

    private int total; //总条数
    private int size = 10;//默认条数
    private int current = 1;//当前页

    private String orderMethod;//排序参数
    private String orderByField;//排序参数
    
    private Map<String, Object> condition = Collections.emptyMap();//查询参数
    
    private List<T> records = Collections.emptyList();
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public String getOrderByField() {
		return orderByField;
	}
	public void setOrderByField(String orderByField) {
		this.orderByField = orderByField;
	}
	public Map<String, Object> getCondition() {
		return condition;
	}
	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public String getOrderMethod() {
		return orderMethod;
	}
	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}
}
