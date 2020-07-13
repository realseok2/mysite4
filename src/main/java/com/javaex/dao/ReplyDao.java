package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.ReplyVo;

@Repository
public class ReplyDao {

	//	기본설정-------------------------------------------------------------------
	
	@Autowired
	private SqlSession sqlSession;
	
	//	댓글게시판 리스트-------------------------------------------------------------------
	
	public List<ReplyVo> getList() {
		System.out.println("ReplyDao : getList");
		
		List<ReplyVo> rList = sqlSession.selectList("reply.getList");
		System.out.println(rList.toString());
		return rList;
	}
	
	//	댓글게시판 게시물 읽기----------------------------------------------------------------
	
	//	게시물 읽기
	public ReplyVo getPost(int no) {
		System.out.println("ReplyDao : getPost");
		return sqlSession.selectOne("reply.getPost", no);
	}
	
	//	게시물 조회수
	public int count(int no) {
		System.out.println("ReplyDao : count");
		return sqlSession.update("reply.count", no);
	}
	
	//	댓글게시판 게시물 추가----------------------------------------------------------------
	
	public int insert(ReplyVo replyVo) {
		System.out.println("ReplyDao : insert");
		System.out.println(replyVo.toString());
		return sqlSession.insert("reply.insert", replyVo);
		
	}
	
	
	//	댓글게시판 게시물 삭제----------------------------------------------------------------
	
	public int delete(int no) {
		System.out.println("ReplyDao : delete");
		return sqlSession.delete("reply.delete", no);
	}
	
	//	댓글게시판 게시물 수정----------------------------------------------------------------
	
	public int update(ReplyVo replyVo) {
		System.out.println("ReplyDao : update");
		return sqlSession.update("reply.update", replyVo);
	}
	
	//	댓글게시판 게시물 검색----------------------------------------------------------------
	
	public List<ReplyVo> select(String keyword) {
		System.out.println("ReplyDao : select");
		List<ReplyVo> rList = sqlSession.selectList("reply.keyword", keyword);
		return rList;
	}
	
	
	
	
	
	//	댓글게시판 페이징-------------------------------------------------------------------
}
