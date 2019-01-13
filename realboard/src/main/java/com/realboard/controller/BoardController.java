package com.realboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.realboard.domain.BoardVO;
import com.realboard.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/board/register", method = RequestMethod.GET) 
	public void registerGET(BoardVO board , Model model)  {
		System.err.println("register....get");
	}
	
	@RequestMapping(value="/board/register", method = RequestMethod.POST)
	public String registPost(BoardVO board, RedirectAttributes rttr)  {
		System.err.println("register....post");
		try {
			BoardVO boardVO = new BoardVO();
			boardService.boardInsert(board);
			rttr.addFlashAttribute("msg", "success");
		} catch (Exception e) {
			System.err.println("registPost....error");
		}
		return "redirect:/board/success";
	}
	
	@RequestMapping(value="/board/success", method = RequestMethod.GET)
	public void boardSuccess(Model model) {
		System.err.println("boardSuccess...get");
	}
	
	@RequestMapping(value="/board/listAll", method = RequestMethod.GET)
	public void boardList(Model model) {
		System.err.println("boardList...get");
		try {
			BoardVO boardVO = new BoardVO();
			model.addAttribute("list", boardService.boardSelect(boardVO));
		} catch (Exception e) {
			System.err.println("boardList..error");
		}
	}
	
	@RequestMapping(value="/board/read", method = RequestMethod.GET)
	public void read(@RequestParam("bno") int bno, Model model) {
		System.err.println("read..get");
		try {
			BoardVO resultVO = new BoardVO();
			ArrayList<Integer> bnoArray = new ArrayList<Integer>();
			bnoArray.add(bno);
			resultVO.setBnoArray(bnoArray);
			model.addAttribute("boardVO",boardService.boardSelect(resultVO));
		} catch (Exception e) {
			System.err.println("read...error");
		}
	}
	
	@RequestMapping(value="/board/remove", method = RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		System.err.println("read..remove");
		try {
			BoardVO resultBoardVO = new BoardVO();
			resultBoardVO.setBno(bno);
			ArrayList<Integer> bnoArray = new ArrayList<Integer>();
			bnoArray.add(bno);
			resultBoardVO.setBnoArray(bnoArray);
			boardService.boareDelete(resultBoardVO);
		} catch (Exception e) {
			System.err.println("remove...error");
			return "remove...error";
		}
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="board/test", method = RequestMethod.GET)
	public void boardTest() {
		System.err.println("boardTest...get");
	}
	
}
