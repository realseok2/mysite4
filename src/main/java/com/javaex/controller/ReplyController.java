package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.ReplyService;
import com.javaex.vo.ReplyVo;

@Controller
@RequestMapping("/reply")
public class ReplyController {

	//	기본설정-------------------------------------------------------------------
	
	@Autowired
	private ReplyService replyService;
	
	//	댓글게시판 리스트--------------------------------------------------------------

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("ReplyController : list");
		
		List<ReplyVo> rList = replyService.getList();
		model.addAttribute("rList", rList);
		
		return "reply/list";
	}
	
	//	댓글게시판 게시물 읽기-----------------------------------------------------------
	
	@RequestMapping("/read/{no}")
	public String read(Model model, @PathVariable("no") int no) {
		System.out.println("ReplyController : read");
		ReplyVo replyVo = replyService.read(no);
		
		model.addAttribute("replyVo", replyVo);
		return "reply/read";
	}
	
	//	댓글게시판 게시물 추가-----------------------------------------------------------
	
	//	게시물 작성폼
	@RequestMapping("/writeForm/{userNo}")
	public String writeForm(Model model, @PathVariable("userNo") int userNo) {
		System.out.println("ReplyController : writeForm");
		
		model.addAttribute("userNo", userNo);
		
		return "reply/writeForm";
	}
	
	//	게시물 작성
	@RequestMapping("/write")
	public String write(@ModelAttribute ReplyVo replyVo) {
		System.out.println("ReplyController : write");
		
		replyService.write(replyVo);
		return "redirect:/reply/list";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//	댓글게시판 게시물 삭제-----------------------------------------------------------
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") int no) {
		System.out.println("ReplyController : delete");
		
		replyService.delete(no);
		return "redirect:/reply/list";
	}
	
	//	댓글게시판 게시물 수정-----------------------------------------------------------
	
	//	수정폼
	@RequestMapping("/modifyForm/{no}")
	public String modifyForm(Model model, @PathVariable("no")int no) {
		System.out.println("ReplyController : modifyForm");
		
		ReplyVo replyVo = replyService.read(no);
		model.addAttribute("replyVo", replyVo);
		
		return "reply/modifyForm";
	}
	
	//	수정
	@RequestMapping("/modify")
	public String modify(@ModelAttribute ReplyVo replyVo) {
		System.out.println("replyController : modify");
		
		replyService.update(replyVo);
		return "redirect:/reply/list";
	}
	
	//	댓글게시판 게시물 검색-----------------------------------------------------------
	
	@RequestMapping("/search")
	public String search(Model model, @RequestParam("keyword") String keyword) {
		System.out.println("ReplyController : search");
		
		List<ReplyVo> rList = replyService.search(keyword);
		model.addAttribute("rList", rList);
		System.out.println(rList.toString());
		return "reply/list";
	}
	
	//	댓글게시판 페이징--------------------------------------------------------------
	
	
	
	
}
