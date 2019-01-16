package com.realboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.realboard.domain.BoardVO;
import com.realboard.paging.Criteria;
@Mapper
public interface BoardMapper {
	public List<BoardVO> boardSelect (BoardVO boardVO) throws Exception;
	
	public void boardInsert(BoardVO boardVO) throws Exception;
	
	public void boardUpdate(BoardVO boardVO) throws Exception;
	
	public void boardDelete(BoardVO boardVO) throws Exception;
	
	public List<BoardVO> listPage (int page) throws Exception;
	
	public List<BoardVO> listCriteria (Criteria cri) throws Exception;
}
 