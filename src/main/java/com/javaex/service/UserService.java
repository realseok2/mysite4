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
		
	//	id중복체크(ajax)------------------------------------------------------------------
	
	public boolean checkId(String id) {
		System.out.println("userService:checkId");
		
		UserVo userVo = userDao.selectUser(id);
		boolean result = true;
		
		if(userVo == null) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
