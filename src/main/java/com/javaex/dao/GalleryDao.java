package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	// 기본설정-------------------------------------------------------

	@Autowired
	private SqlSession sqlSession;

	// 갤러리 리스트----------------------------------------------------

	public List<GalleryVo> getList() {
		System.out.println("GalleryDao:getList");

		List<GalleryVo> iList = sqlSession.selectList("gallery.getList");
		System.out.println(iList.toString());

		return iList;
	}

	// 갤러리 추가-----------------------------------------------------

	public int insert(GalleryVo galleryVo) {
		System.out.println("GalleryDao:insert");

		return sqlSession.insert("gallery.insert", galleryVo);
	}

	// 갤러리 보기-----------------------------------------------------

	public GalleryVo view(GalleryVo galleryVo) {
		System.out.println("GalleryDao:view");

		return sqlSession.selectOne("gallery.selectImage", galleryVo);
	}

	// 갤러리 삭제-----------------------------------------------------

	public int delete(GalleryVo galleryVo) {
		System.out.println("GalleryDao.delete");

		return sqlSession.delete("gallery.delete", galleryVo);
	}
}
