package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	// 기본설정-------------------------------------------------------

	@Autowired
	private GalleryDao galleryDao;

	// 갤러리 리스트----------------------------------------------------

	public List<GalleryVo> getList() {
		System.out.println("GalleryService:getList");

		List<GalleryVo> iList = galleryDao.getList();
		return iList;
	}

	// 갤러리 추가-----------------------------------------------------

	public int upload(MultipartFile file, GalleryVo galleryVo) {
		System.out.println("GalleryService:imageUpload");

		// 데이터 추출*****************************************************
		// ************************************************************

		// 파일이 저장될 위치
		String saveDir = "C:\\JavaStudy\\upload";

		// 업로드 할 때의 파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName : " + orgName);

		// 확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName : " + exName);

		// 업로드된 파일의 이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName : " + saveName);

		// 파일 경로
		String filePath = saveDir + "\\" + saveName;
		System.out.println("filePath : " + filePath);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize :" + fileSize);

		// 데이터 복사*****************************************************
		// ************************************************************

		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);
			bout.close();

		} catch (IOException e) {
			e.printStackTrace();

		}

		// 이미지 정보 담기
		galleryVo.setOrgName(orgName);
		galleryVo.setSaveName(saveName);
		galleryVo.setFilePath(filePath);
		galleryVo.setFileSize(fileSize);

		return galleryDao.insert(galleryVo);
	}

	// 갤러리 보기-----------------------------------------------------

	public GalleryVo view(GalleryVo galleryVo) {
		System.out.println("GalleryService:view");

		return galleryDao.view(galleryVo);
	}

	// 갤러리 삭제-----------------------------------------------------

	public boolean delete(GalleryVo galleryVo) {
		System.out.println("GalleryService:delete");
		int count = galleryDao.delete(galleryVo);
		return (count == 1);
	}

}
