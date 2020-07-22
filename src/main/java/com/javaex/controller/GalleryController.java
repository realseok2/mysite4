package com.javaex.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

	// 기본설정-------------------------------------------------------

	@Autowired
	private GalleryService galleryService;

	// 갤러리 리스트----------------------------------------------------

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("GalleryController:list");

		List<GalleryVo> iList = galleryService.getList();
		model.addAttribute("iList", iList);
		System.out.println(iList.toString());

		return "gallery/list";
	}

	// 갤러리 추가-----------------------------------------------------

	@RequestMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("comments") String comments, @ModelAttribute GalleryVo galleryVo, HttpSession session) {
		System.out.println("GalleryController:upload");

		UserVo authUser = (UserVo) session.getAttribute("authUser");

		galleryVo.setUserNo(authUser.getNo());
		galleryVo.setComments(comments);

		galleryService.upload(file, galleryVo);

		return "redirect:list";
	}

	// 갤러리 보기-----------------------------------------------------

	@ResponseBody
	@RequestMapping("/view")
	public GalleryVo view(@RequestBody GalleryVo galleryVo) {
		System.out.println("GalleryController:view");

		return galleryService.view(galleryVo);
	}

	// 갤러리 삭제-----------------------------------------------------

	@ResponseBody
	@RequestMapping("/delete")
	public boolean delete(@RequestBody GalleryVo galleryVo, HttpSession session) {
		System.out.println("GalleryController:delete");

		UserVo authUser = (UserVo) session.getAttribute("authUser");

		galleryVo.setUserNo(authUser.getNo());

		return galleryService.delete(galleryVo);
	}

}
