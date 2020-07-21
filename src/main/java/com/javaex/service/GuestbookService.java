package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {

//	기본설정-------------------------------------------------------
	
	@Autowired
	private GuestbookDao guestbookDao;
	
//	방명록 리스트----------------------------------------------------
	
	public List<GuestbookVo> getList() {
		System.out.println("guestbookService:getList");
		
		return guestbookDao.getList();
	}
	
//	방명록 추가-----------------------------------------------------
	
	public int add(GuestbookVo guestbookVo) {
		System.out.println("guestbookService:add");
		System.out.println("서비스 : " + guestbookVo.toString());
		return guestbookDao.add(guestbookVo);
	}
	
//	방명록 삭제-----------------------------------------------------
	
	public int delete(GuestbookVo guestbookVo) {
		System.out.println("guestbookService:delete");
		
		return guestbookDao.delete(guestbookVo);
	}
	
//	방명록 글 저장(ajax)-----------------------------------------------------
	
	public GuestbookVo addGuest(GuestbookVo guestbookVo) {
		System.out.println("guestbookService:addGuest");
		
		//저장
		guestbookDao.insertSelectKey(guestbookVo);
		
		int no = guestbookVo.getNo();		//	연구해 볼 것. return으로 받지 않고
		System.out.println("selectKey로 받은 no값 = " + no);
		
		//저장한 데이터 가져오기
		return guestbookDao.selectByNo(no);
		
	}
	
	
	
	

	
}
