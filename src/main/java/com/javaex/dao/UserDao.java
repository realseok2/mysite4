package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

//	기본설정------------------------------------------------------------------------ 
	@Autowired
	private SqlSession sqlSession;
	
//	회원가입------------------------------------------------------------------------
	
	public int insert(UserVo userVo) {
		System.out.println("UserDao:insert");
				
		return sqlSession.insert("user.insert", userVo);
	}
	
//	로그인-------------------------------------------------------------------------
	
	public UserVo selectUser(UserVo userVo) {
		System.out.println("UserDao:selectUser");
		System.out.println(userVo.toString());
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);

		return authUser;
	}
	
//	회원정보 수정----------------------------------------------------------------------
	
	public UserVo getUser(int no) {
		System.out.println("UserDao:getUser");
		
		return sqlSession.selectOne("user.getUser", no);
	}
	
	public int updateUser(UserVo userVo) {
		System.out.println("UserDao:updateUser");
		System.out.println(userVo.toString());

		return sqlSession.update("user.updateUser", userVo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
