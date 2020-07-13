package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	// 기본설정------------------------------------------------------------------

	@Autowired
	private BoardService boardService;

	// 게시판 리스트----------------------------------------------------------------

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("boardController:list");

		List<BoardVo> bList = boardService.getList();
		model.addAttribute("bList", bList);
		System.out.println(bList.toString());

		return "board/list";
	}

	// 게시물 읽기-----------------------------------------------------------------

	@RequestMapping("/read/{no}")
	public String read(Model model, @PathVariable("no") int no) {
		System.out.println("boardController:read");

		BoardVo boardVo = boardService.read(no);
		model.addAttribute("boardVo", boardVo);

		return "board/read";
	}

	// 게시물 추가-----------------------------------------------------------------

	@RequestMapping("/writeForm/{userNo}")
	public String writeForm(Model model, @PathVariable("userNo") int userNo) {
		System.out.println("boardController:writeForm");

		model.addAttribute("userNo", userNo);
		return "board/writeForm";
	}

	@RequestMapping("/write")
	public String write(@ModelAttribute BoardVo boardVo) {
		System.out.println("boardController:write");
		System.out.println("컨트롤러 : " + boardVo.toString());

		boardService.write(boardVo);
		return "redirect:/board/list";
	}

	// 게시물 삭제-----------------------------------------------------------------

	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") int no) {
		System.out.println("boardController:delete");
		
		boardService.delete(no);
		return "redirect:/board/list";
	}
	
	// 게시물 수정-----------------------------------------------------------------

	@RequestMapping("/modifyForm/{no}")
	public String modifyForm(Model model, @PathVariable("no") int no) {
		System.out.println("boaedController:modifyForm");
		
		BoardVo boardVo = boardService.read(no);
		model.addAttribute("boardVo", boardVo);
		System.out.println("수정폼 : " + boardVo.toString());
		return "board/modifyForm";
	}
	
	@RequestMapping("/modify")
	public String modify(@ModelAttribute BoardVo boardVo) {
		System.out.println("boardController:modify");
		
		boardService.update(boardVo);
		System.out.println("수정 : " + boardVo.toString());
		return "redirect:/board/list";
	}
	
	// 게시물 검색-----------------------------------------------------------------
	
	@RequestMapping("/search")
	public String search(Model model, @RequestParam("keyword") String keyword) {
		System.out.println("boardController:search");
		
		List<BoardVo> bList = boardService.search(keyword);
		model.addAttribute("bList", bList);
		System.out.println("컨트롤러 : " + bList.toString());
		return "board/list";
	}
	
	// 게시물 페이징----------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
