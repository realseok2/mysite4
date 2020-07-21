package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 게시판 페이징 리스트------------------------------------------------------------

	public Map<String, Object> getList2(int crtPage) {
		System.out.println("boardService:getList2");
		
		//리스트 가져오기-------------------------------------------------------------
		
			//페이지당 글 갯수
			int listCnt	= 10;
			
			//현재 페이지 계산
			crtPage = (crtPage>0) ? crtPage : (crtPage = 1) ;	//crtPage 0 보다 작으면 1Page 처리	
			//		위 방식과 같은 의미
			//		if(crtPage>0) {
			//			crtPage = crtPage;
			//		} else {
			//			crtPage = 1;
			//		}
			
			//시작 글 번호 startRnum
			int startRnum = (crtPage-1)*listCnt;	//	1page --> 0		+1 db에서 계산
			
			//끝 글 번호 endRnum
			int endRnum = startRnum + listCnt;		//	1Page --> 10	db에서 그대로 사용
			
			System.out.println("crtPage : " + crtPage);
			System.out.println("startRnum : " + startRnum);
			System.out.println("endRnum : " + endRnum);
			
			
			List<BoardVo> list = boardDao.getList2(startRnum, endRnum);
	

		//totalCount 페이지 버튼 영역---------------------------------------------------
			//전체 글 갯수
			int totalCount = boardDao.totalCount();
			
			//페이지당 버튼 갯수
			int pageBtnCount = 5;
			
			//1		-->		1 ~ 5
			//2		--> 	1 ~ 5
			//3		--> 	1 ~ 5
			//4		--> 	1 ~ 5
			//5		--> 	1 ~ 5
			//6		-->		5 ~ 10
			//11	--> 	11 ~ 15
			
			//마지막 버튼 번호
			int endPageBtnNo = (int)Math.ceil(crtPage/(double)pageBtnCount) * pageBtnCount;
			
			//시작 버튼 번호
			int startPageBtnNo = endPageBtnNo - (pageBtnCount-1);
			
			//다음 화살표 유무 next
			boolean next = false;
			if(endPageBtnNo*listCnt < totalCount) {
				next = true;
			} else {
				endPageBtnNo = (int)Math.ceil(totalCount/(double)listCnt);
			}
			
			//이전 화살표 유무 prev
			boolean prev = false;
			if(startPageBtnNo != 1) {
				prev = true;
			}
			
			Map<String, Object> pMap = new HashMap<String, Object>();
			pMap.put("prev", prev);
			pMap.put("startPageBtnNo", startPageBtnNo);
			pMap.put("endPageBtnNo", endPageBtnNo);
			pMap.put("next", next);
			pMap.put("bList", list);
						
			return pMap;
	
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
