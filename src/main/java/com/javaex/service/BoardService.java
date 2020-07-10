package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;

@Service
public class BoardService {

	// 기본설정------------------------------------------------------------------

	@Autowired
	private BoardDao boardDao;

	// 게시판 리스트----------------------------------------------------------------

	public List<BoardVo> getList() {
		System.out.println("boardService:getList");

		return boardDao.getList();
	}

	// 게시물 읽기-----------------------------------------------------------------

	public BoardVo read(int no) {
		System.out.println("boardService:read");

		boardDao.count(no);
		
		return boardDao.getPost(no);
	}

	// 게시물 추가-----------------------------------------------------------------

	public int write(BoardVo boardVo) {
		System.out.println("boardService:write");
		System.out.println("서비스 : " + boardVo.toString());

		return boardDao.insert(boardVo);
	}

	// 게시물 삭제-----------------------------------------------------------------

	public int delete(int no) {
		System.out.println("boardService:delete");
		
		return boardDao.delete(no);
	}
	
	// 게시물 수정-----------------------------------------------------------------

	public int update(BoardVo boardVo) {
		System.out.println("boardService:update");
		
		return boardDao.update(boardVo);
	}

	// 게시물 검색-----------------------------------------------------------------	
	
	public List<BoardVo> search(String keyword) {
		System.out.println("boardService:search");
		List<BoardVo> bList = boardDao.select(keyword);
		
		return bList;
	}
	
	// 게시물 페이징----------------------------------------------------------------	
	
	
	
	
	
	
	
	
	
	
}
