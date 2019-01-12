package com.realboard.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.realboard.domain.BoardVO;
import com.realboard.service.BoardService;

@Controller
public class TestController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="test/testregister", method = RequestMethod.GET)
	public void testRegistserGet(Model model) {
		System.err.println("testRegister...Get");
	}
	
	@RequestMapping(value="test/testregister", method = RequestMethod.POST)
	public String testRegisterPost(BoardVO boardVO,Model model, RedirectAttributes rttr) {
		System.err.println("testRegister...POST");
		try {
			System.err.println("들어오니?");
			boardService.boardInsert(boardVO);
			
		} catch (Exception e) {
			System.err.println("에러입니다.");
		}
		model.addAttribute("result", "success");
		rttr.addFlashAttribute("msg", "success");
		return"redirect:/test/listAll"; 
		/* return"/test/testsuccess"; */
	}
	
	@RequestMapping(value="test/listAll" , method = RequestMethod.GET)
	public void listAll(Model model) {
		System.err.println("listAll...");
		BoardVO boardVO = new BoardVO();
		try {
			model.addAttribute("list", boardService.boardSelect(boardVO));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
