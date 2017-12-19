package com.mar.dto;

import java.util.Collections;
import java.util.List;

/**
 * <p>带有上传文件的实体接受类</p>
 * @author cyc
 * @since 2017-07-11
 */
public class EntityUpload<T>{

    private T entity;

    private List<String> upLoadFileId = Collections.emptyList();

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	public List<String> getUpLoadFileId() {
		return upLoadFileId;
	}

	public void setUpLoadFileId(List<String> upLoadFileId) {
		this.upLoadFileId = upLoadFileId;
	}

}
