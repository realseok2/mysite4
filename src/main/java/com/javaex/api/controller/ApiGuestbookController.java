package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping("/api/guestbook")
public class ApiGuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<GuestbookVo> list() {
		System.out.println("ApiGuestbookController:list");

		List<GuestbookVo> gList = guestbookService.getList();
		
		System.out.println(gList.toString());

		return gList;
	}
	
	@ResponseBody
	@RequestMapping("/write")
	public GuestbookVo write(@RequestBody GuestbookVo guestbookVo) {
		System.out.println("전-----ApiGuestbookController:write");
		System.out.println(guestbookVo.toString());
		
		GuestbookVo vo = guestbookService.addGuest(guestbookVo);
		System.out.println("후-----ApiGuestbookController:write" + vo.toString());
		
		return vo;
	}
	
	//ResponseBody 꼭 조심!!!!!!
	@ResponseBody
	@RequestMapping("/delete")
	public int delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("ApiGuestbookController:delete");
		System.out.println(guestbookVo.toString());
		int count = guestbookService.delete(guestbookVo);
		return count;
	}
	
	
	
	
	
	
	
	
	

}
