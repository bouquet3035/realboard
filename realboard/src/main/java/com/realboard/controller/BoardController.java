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
import com.realboard.paging.Criteria;
import com.realboard.paging.PageMaker;
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
	
	@RequestMapping(value="/board/modify", method = RequestMethod.GET)
	public void modifyGET (int bno, Model model) throws Exception {
		BoardVO boardVO = new BoardVO();
		ArrayList<Integer> bnoArray = new ArrayList<Integer>();
		bnoArray.add(bno);
		boardVO.setBnoArray(bnoArray);
		model.addAttribute("boardVO",boardService.boardSelect(boardVO));
	}
	
	@RequestMapping(value="/board/modify", method = RequestMethod.POST)
	public String modifyPOST (BoardVO boardVO, RedirectAttributes rttr) throws Exception {
		System.err.println("modifyPOST ... post");
		System.err.println(boardVO.toString());
		BoardVO resultBoardVO = boardVO;
		ArrayList<Integer> bnoArray = new ArrayList<Integer>();
		bnoArray.add(boardVO.getBno());
		resultBoardVO.setBnoArray(bnoArray);
		boardService.boardUpdate(boardVO);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="board/test", method = RequestMethod.GET)
	public void boardTest() {
		System.err.println("boardTest...get");
	}
	
	@RequestMapping(value="board/listCri", method = RequestMethod.GET)
	public void listCri (Criteria cri,Model model) {
		System.err.println("cri.getPage() ====>" + cri.getPage());
		System.err.println("listCri..get");
		System.err.println(cri.toString());
		try {
			model.addAttribute("list", boardService.listCriteria(cri));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="board/listPage" , method = RequestMethod.GET)
	public void listPage (Criteria cri, Model model)  {
		System.err.println("listPage...get");
		System.err.println(cri.toString());
		try {
			model.addAttribute("list", boardService.listCriteria(cri));
			PageMaker pageMaker = new PageMaker();
			pageMaker.setCri(cri);
			pageMaker.setTotalCount(18);
			model.addAttribute("pageMaker", pageMaker);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
