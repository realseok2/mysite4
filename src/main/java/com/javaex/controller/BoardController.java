package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String writeForm(Model model, @PathVariable("user_no") int userNo) {
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

	// 게시물 수정-----------------------------------------------------------------

}
