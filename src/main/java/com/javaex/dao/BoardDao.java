package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVo;

@Repository
public class BoardDao {

	// 기본설정------------------------------------------------------------------

	@Autowired
	private SqlSession sqlSession;

	// 게시판 리스트----------------------------------------------------------------

	public List<BoardVo> getList() {
		System.out.println("boardDao:getList");

		List<BoardVo> bList = sqlSession.selectList("board.getList");
		System.out.println(bList.toString());
		return bList;
	}

	// 게시물 읽기-----------------------------------------------------------------

	public BoardVo getPost(int no) {
		System.out.println("boardDao:getPost");
		return sqlSession.selectOne("board.getPost", no);
	}
	
	public int count(int no) {
		System.out.println("boardDao:count");
		
		return sqlSession.update("board.count", no);
	}

	// 게시물 추가-----------------------------------------------------------------

	public int insert(BoardVo boardVo) {
		System.out.println("boardDao:insert");
		System.out.println("dao : " + boardVo.toString());

		return sqlSession.insert("board.insert", boardVo);
	}

	// 게시물 삭제-----------------------------------------------------------------

	public int delete(int no) {
		System.out.println("boardDao:delete");
		
		return sqlSession.delete("board.delete", no);
	}
	
	// 게시물 수정-----------------------------------------------------------------

	public int update(BoardVo boardVo) {
		System.out.println("boardDao:update");
		return sqlSession.update("board.update", boardVo);
	}
	
	// 게시물 검색-----------------------------------------------------------------	
	
	public List<BoardVo> select(String keyword) {
		System.out.println("boardDao:select");
		List<BoardVo> bList = sqlSession.selectList("board.keyword", keyword);
		return bList;
	}
	
	// 게시물 페이징----------------------------------------------------------------	
	
	
	
	
	
	
}
