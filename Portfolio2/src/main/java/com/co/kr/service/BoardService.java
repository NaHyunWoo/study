package com.co.kr.service;

import java.util.List;

import com.co.kr.common.FileVO;
import com.co.kr.common.SearchVO;
import com.co.kr.vo.BoardVO;

public interface BoardService {

	public List<?> selectBoardList(SearchVO searchVO);

	public void insertBoard(BoardVO boardVO, List<FileVO> filelist);

	public BoardVO selectBoardOne(String brdno);

	public void updateBoard(BoardVO boardInfo, List<FileVO> filelist);

	public void deleteBoardOne(String brdno);

	public void updateBoardRead(String brdno);

	public Integer selectBoardCount(SearchVO searchVO);


}
