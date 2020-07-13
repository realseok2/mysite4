package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	//	기본설정------------------------------------------------------------------------
	@Autowired
	private UserDao userDao;
		
	//	회원가입------------------------------------------------------------------------
	public int join(UserVo userVo) {
		System.out.println("userService:join");
	
		return userDao.insert(userVo);
	}
	
	//	로그인-------------------------------------------------------------------------
	public UserVo login(UserVo userVo) {
		System.out.println("userService:login");
		
		return userDao.selectUser(userVo);
	}
	
	//	회원정보 수정---------------------------------------------------------------------
	
	public UserVo getUser(int no) {
		System.out.println("userService:getUser");
		
		return userDao.getUser(no);
	}
	
	public int updateUser(UserVo userVo) {
		System.out.println("userService:updateUser");

		return userDao.updateUser(userVo);
	}
	
	
	
	
	
	
	//	방명록 작성----------------------------------------------------------------------
	
	//	방명록 삭제----------------------------------------------------------------------
	
	//	방명록 수정----------------------------------------------------------------------
	
	//	게시판 작성----------------------------------------------------------------------
	
	//	게시판 삭제----------------------------------------------------------------------
	
	//	게시판 수정----------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
