package com.mar.service;

import com.mar.entity.UploadFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * <p>上传的文件服务</p>
 * @author CC
 */
public interface FileService {
	
	/**
	 * 保存上传服务
	 * @param cmmonsMultipartFile
	 * @return
	 */
	public long saveUploadFile(CommonsMultipartFile cmmonsMultipartFile);

	public void linkUploadFile(List<Integer> fileIdList, String dependId);
	
	public UploadFile get(int fileId);
	
	public List<UploadFile> listBelongFile(String fileDependId);
	
}
