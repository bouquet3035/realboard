package com.realboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realboard.domain.BoardVO;
import com.realboard.mapper.BoardMapper;
import com.realboard.paging.Criteria;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	public List<BoardVO> boardSelect (BoardVO boardVO) throws Exception{
		
		return boardMapper.boardSelect(boardVO);
	}
	
	public void boardInsert(BoardVO boardVO) throws Exception {
		boardMapper.boardInsert(boardVO);
	}
	
	public void boardUpdate(BoardVO boardVO) throws Exception {
		boardMapper.boardUpdate(boardVO);
	}
	
	public void boareDelete(BoardVO boardVO) throws Exception {
		boardMapper.boardDelete(boardVO);
	}
	
	public List<BoardVO> listPage (int page) throws Exception {
		if(page <= 0) {
			page = 1; 
		}
		page = (page -1) * 10;
		return boardMapper.listPage(page);
	}
	
	public List<BoardVO> listCriteria (Criteria cri) throws Exception {
		return boardMapper.listCriteria(cri);
	}
}
