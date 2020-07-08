package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
		
	//	회원가입------------------------------------------------------------------------
	public int join(UserVo userVo) {
		System.out.println("userService:join");
	
		userDao.insert(userVo);
		return 1;
	}
	
	//	로그인-------------------------------------------------------------------------
	public UserVo login(UserVo userVo) {
		System.out.println("userService:login");
		
		UserVo authUser = userDao.selectUser(userVo);
		return authUser;
	}
	
	
	//	로그아웃------------------------------------------------------------------------
	
	
	//	회원정보 수정---------------------------------------------------------------------
	
	//	방명록 작성----------------------------------------------------------------------
	
	//	방명록 삭제----------------------------------------------------------------------
	
	//	방명록 수정----------------------------------------------------------------------
	
	//	게시판 작성----------------------------------------------------------------------
	
	//	게시판 삭제----------------------------------------------------------------------
	
	//	게시판 수정----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
