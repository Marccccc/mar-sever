package com.mar.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mar.dao.UploadFileDao;
import com.mar.entity.UploadFile;
import com.mar.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

	private @Autowired
	UploadFileDao fileDao;
	
	@Override
	public long saveUploadFile(CommonsMultipartFile cmmonsMultipartFile) {
		String path="C:/business_directory/"+System.currentTimeMillis()+cmmonsMultipartFile.getOriginalFilename();
        File newFile=new File(path);
        UploadFile uploadFile=new UploadFile();
		uploadFile.setName(cmmonsMultipartFile.getOriginalFilename());
		uploadFile.setPath(path);
        try {
			cmmonsMultipartFile.transferTo(newFile);
			fileDao.insert(uploadFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
        return uploadFile.getId();
	}

	@Override
	public void linkUploadFile(List<Integer> fileList, String dependId) {
		for(Integer fileId:fileList){
			UploadFile uploadFile=fileDao.selectById(fileId);
            uploadFile.setDependId(dependId);
            fileDao.updateById(uploadFile);
		}
	}

	@Override
	public UploadFile get(int fileId) {
		return fileDao.selectById(fileId);
	}

	@Override
	public List<UploadFile> listBelongFile(String fileDependId) {
		return fileDao.selectList(new EntityWrapper<UploadFile>().eq("file_Belong_Id", fileDependId));
	}

}
