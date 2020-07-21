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
	
	
	
//	방명록 글 저장(ajax)-----------------------------------------------------
	
	public void insertSelectKey(GuestbookVo guestbookVo) {
		System.out.println("guestbookDao:insertSelectKey");
		
		System.out.println("전-----" + guestbookVo.toString());			//	no값 없음
		sqlSession.insert("guestbook.insertSelectKey", guestbookVo);
		System.out.println("후-----" + guestbookVo.toString());			//	no값 있음
	}
	
	//글 자여오기(ajax로 자신이 등록한 글)
	public GuestbookVo selectByNo(int no) {
		return sqlSession.selectOne("guestbook.selectByNo", no);
	}
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
