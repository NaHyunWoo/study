package com.co.kr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.kr.common.FileVO;
import com.co.kr.common.PageVO;
import com.co.kr.common.SearchVO;
import com.co.kr.dao.BoardDAO;
import com.co.kr.service.BoardService;
import com.co.kr.vo.BoardVO;
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public void insertBoard(BoardVO boardVO, List<FileVO> filelist) {
		boardDAO.insetBoard(boardVO, filelist);
	}

	@Override
	public BoardVO selectBoardOne(String brdno) {
		return boardDAO.selectBoardOne(brdno);
	}

	public void updateBoard(BoardVO boardVO, List<FileVO> filelist) {
		boardDAO.updateBoard(boardVO, filelist);
	}

	@Override
	public void deleteBoardOne(String brdno) {
		boardDAO.deleteBoardOne(brdno);
	}

	@Override
	public void updateBoardRead(String brdno) {
		boardDAO.updateBoardRead(brdno);
	}

	@Override
	public Integer selectBoardCount(SearchVO searchVO) {
		return boardDAO.selectBoardCount(searchVO);
	}

	@Override
	public List<?> selectBoardList(SearchVO searchVO) {
		return boardDAO.selectBoardList(searchVO);		
	}


	
	
}
