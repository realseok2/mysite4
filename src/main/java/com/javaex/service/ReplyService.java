package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.ReplyDao;
import com.javaex.vo.ReplyVo;

@Service
public class ReplyService {

	//	기본설정-------------------------------------------------------------------
	
	@Autowired
	private ReplyDao replyDao;
	
	//	댓글게시판 리스트-------------------------------------------------------------------
	
	public List<ReplyVo> getList() {
		System.out.println("ReplyService : getList");
		
		return replyDao.getList();
	}
	
	//	댓글게시판 게시물 읽기----------------------------------------------------------------
	
	public ReplyVo read(int no) {
		System.out.println("ReplyService : read");
		
		replyDao.count(no);
		
		return replyDao.getPost(no);
	}
	
	//	댓글게시판 게시물 추가----------------------------------------------------------------
	
	public int write(ReplyVo replyVo) {
		System.out.println("ReplyService : write");
		
		return replyDao.insert(replyVo);
	}
	
	//	댓글게시판 게시물 삭제----------------------------------------------------------------
	
	public int delete(int no) {
		System.out.println("ReplyService : delete");
		
		return replyDao.delete(no);
	}
	
	//	댓글게시판 게시물 수정----------------------------------------------------------------
	
	public int update(ReplyVo replyVo) {
		System.out.println("ReplyService : update");
		
		return replyDao.update(replyVo);
	}
	
	//	댓글게시판 게시물 검색----------------------------------------------------------------
	
	public List<ReplyVo> search(String keyword) {
		System.out.println("ReplyService : search");
		
		List<ReplyVo> rList = replyDao.select(keyword);
		return rList;
	}
	
	
	
	
	
	//	댓글게시판 페이징-------------------------------------------------------------------
}
