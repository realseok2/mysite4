package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVo;


@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	// 기본설정-----------------------------------------------------------------
	@Autowired
	private GuestbookService guestbookService;

	// 방명록 리스트---------------------------------------------------------

	@RequestMapping("/addList")
	public String addList(Model model) {
		System.out.println("guestbookController:addList");
		
		List<GuestbookVo> gList = guestbookService.getList();
		model.addAttribute("gList", gList);
		
		return "guestbook/addList";
	}
		
	// 방명록 추가-----------------------------------------------------------

	@RequestMapping("/add")
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("guestbookController:add");
		System.out.println("컨트롤러 : " + guestbookVo.toString());		
		guestbookService.add(guestbookVo);

		return "redirect:/guestbook/addList";
	}
	
	// 방명록 삭제-----------------------------------------------------------
	
	@RequestMapping("/deleteForm/{no}")
	public String deleteForm(Model model, @PathVariable("no") int no) {
		System.out.println("guestbookController:deleteForm");
		
		model.addAttribute("no", no);
		return "guestbook/deleteForm";
		
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("guestbookController:delete");
		
		guestbookService.delete(guestbookVo);
		return "redirect:/guestbook/addList";
	}
		
	// 방명록 수정-----------------------------------------------------------

	
	
	
}
