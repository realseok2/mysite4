package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVo;

@Repository
public class GuestbookDao {

//	기본설정-------------------------------------------------------
	
	@Autowired
	private SqlSession sqlSession;
	
//	방명록 리스트----------------------------------------------------
	
	public List<GuestbookVo> getList() {
		System.out.println("guestbookDao:getList");
		
		List<GuestbookVo> gList = sqlSession.selectList("guestbook.getList");
		System.out.println(gList.toString());
		return gList;
	}
	
//	방명록 추가-----------------------------------------------------
	
	public int add(GuestbookVo guestbookVo) {
		System.out.println("guestbookDao:add");
		System.out.println("dao : " + guestbookVo.toString());
		return sqlSession.insert("guestbook.insert", guestbookVo);
	}
	
//	방명록 삭제-----------------------------------------------------
	
	public int delete(GuestbookVo guestbookVo) {
		System.out.println("guestbookDao:delete");
		
		return sqlSession.delete("guestbook.delete", guestbookVo);
	}
	
	
	
//	방명록 수정-----------------------------------------------------
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
