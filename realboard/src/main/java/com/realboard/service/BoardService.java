package com.realboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realboard.domain.BoardVO;
import com.realboard.mapper.BoardMapper;

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
}
