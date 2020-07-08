package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {

	//	기본설정-----------------------------------------------------------------
	@Autowired
	private UserService userService;

	//	회원가입-----------------------------------------------------------------	
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("/user/joinForm");

		return "/user/joinForm";
	}

	@RequestMapping("/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("userController:join");

		userService.join(userVo);

		return "redirect:/user/joinOk";
	}

	@RequestMapping("/joinOk")
	public String joinOk() {
		System.out.println("userController:joinOk");

		return "/user/joinOk";
	}
	
	//	로그인------------------------------------------------------------------
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("userController:loginForm");

		return "/user/loginForm";
	}

	@RequestMapping("/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("userController:login");
		
		UserVo authUser = userService.login(userVo);
				
		//	로그인 성공시
		if(authUser != null) {
			System.out.println("로그인 성공");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		
		//	로그인 실패시
		}else {
			System.out.println("로그인 실패");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	//	로그아웃-----------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}