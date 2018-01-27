package com.co.kr.dao;

import java.util.List;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.co.kr.common.FileVO;
import com.co.kr.common.SearchVO;
import com.co.kr.vo.BoardVO;
@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<?> selectBoardList(SearchVO searchVO) {
		return sqlSession.selectList("selectBoardList",searchVO );
	}

	public void insetBoard(BoardVO boardVO, List<FileVO> filelist) {
		sqlSession.insert("insertBoard", boardVO);
		for(FileVO f : filelist) {
			f.setParentPK(boardVO.getBrdno());
			sqlSession.insert("insertBoardFile", f);
		}
	}

	public BoardVO selectBoardOne(String brdno) {
		return sqlSession.selectOne("selectBoardOne", brdno);
	}

	public void updateBoard(BoardVO boardVO, List<FileVO> filelist) {
		sqlSession.update("updateBoard", boardVO);
		for(FileVO f : filelist) {
			f.setParentPK(boardVO.getBrdno());
			sqlSession.insert("insertBoardFile", f);
		}
	}

	public void deleteBoardOne(String brdno) {
		sqlSession.delete("deleteBoardOne", brdno);
	}

	public void updateBoardRead(String brdno) {
		sqlSession.update("updateBoardRead", brdno);
	}

	public Integer selectBoardCount(SearchVO searchVO) {
		return sqlSession.selectOne("selectBoardCount",searchVO);
	}

}
