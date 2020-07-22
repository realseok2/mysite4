package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public String restore(MultipartFile file) {
		System.out.println("FileUploadService:restore");
		//**************************************************************************************************
		//데이터 추출*******************************************************************************************
		
		String saveDir = "C:\\JavaStudy\\upload";
		
		//원래파일 이름 추출---------------------------------------------------------------------------------------
		String orgName = file.getOriginalFilename();
		System.out.println("orgName : " + orgName);
		
		//확장자-----------------------------------------------------------------------------------------------
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName : " + exName);
		
		//저장파일이름-------------------------------------------------------------------------------------------
		//currentTimeMillis() --> 시간
		//UUID.randomUUID().toString() --> 랜덤값을 이메일 주소형식으로 생성
		//exName --> 확장자 이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName : " + saveName);
		
		//파일경로(file path)-----------------------------------------------------------------------------------
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath : " + filePath);
		
		//파일사이즈---------------------------------------------------------------------------------------------
		long fileSize = file.getSize();
		System.out.println("fileSize : " + fileSize);		
		
		//***************************************************************************************************
		//파일 서버에 복사*****************************************************************************************
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout =  new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
				
		//파일 --> 필요한 정보추출 --> DB에 저장
		//no :
		//orgName : LeeHyoRi.jpg
		//exName : .jpg
		//saveName : 15953202547896a67b1ed-6501-407b-aa35-1d010d38f0fb.jpg
		//filePath : C:\\JavaStudy\\upload\\15953202547896a67b1ed-6501-407b-aa35-1d010d38f0fb.jpg
		//fileSize : 87271
	
	return saveName;
	
	}
}
