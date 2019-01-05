package com.realboard;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.realboard.domain.BoardVO;
import com.realboard.mapper.BoardMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealboardApplicationTests {
	@Autowired
    private SqlSessionFactory sqlSession; //작성
	
	@Autowired
    private BoardMapper mapper;
	
	@Test
    public void testSqlSession() throws Exception{//작성
        
        System.out.println("sqlSession : "+sqlSession);
        
    }
	
	@Test
	public void testSelect() throws Exception{
		BoardVO vo = new BoardVO();
		ArrayList<Integer> bnoArray = new ArrayList<Integer>();
		bnoArray.add(1);
		vo.setBnoArray(bnoArray);
		mapper.boardSelect(vo);
	}
	
	@Test
	public void testInsert() throws Exception{
		BoardVO resultVO = new BoardVO();
		ArrayList<BoardVO> boardVoArray = new ArrayList<BoardVO>();
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("test 제목입니다");
		boardVO.setContent("test 내용입니다.");
		boardVO.setWriter("test작성자입니다.");
		boardVO.setRegdate("2019-01-05");
		boardVO.setViewcnt(1);
		
		
		BoardVO boardVO1 = new BoardVO();
		boardVO1.setTitle("test 제목입니다1");
		boardVO1.setContent("test 내용입니다.1");
		boardVO1.setWriter("test작성자입니다.1");
		boardVO1.setRegdate("2019-01-06");
		boardVO1.setViewcnt(1);
		
		boardVoArray.add(boardVO);
		boardVoArray.add(boardVO1);
		resultVO.setBoardVoArray(boardVoArray);
		mapper.boardInsert(resultVO);
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO resultVO = new BoardVO();
		resultVO.setTitle("가");
		resultVO.setContent("나");
		resultVO.setWriter("다");
		
		resultVO.setRegdate("2018-12-12");
		ArrayList<Integer> bnoArray = new ArrayList<Integer>();
		bnoArray.add(1);
		bnoArray.add(2);
		resultVO.setBnoArray(bnoArray);
		mapper.boardUpdate(resultVO);
	}
	

	@Test
	public void contextLoads() {
	}

}

