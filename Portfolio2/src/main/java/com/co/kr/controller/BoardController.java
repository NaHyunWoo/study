package com.co.kr.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.co.kr.common.FileUtil;
import com.co.kr.common.FileVO;
import com.co.kr.common.PageVO;
import com.co.kr.common.SearchVO;
import com.co.kr.service.BoardService;
import com.co.kr.vo.BoardVO;

@Controller
public class BoardController {
	
	private Log log = LogFactory.getLog(this.getClass());

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value={"/boardList","/"})
	public String boardList(Model model, SearchVO searchVO) {
		
		searchVO.pageCalculate(boardService.selectBoardCount(searchVO));
		
		List<?> listview = boardService.selectBoardList(searchVO);
		model.addAttribute("listview", listview);
		model.addAttribute("pageVO", searchVO);
		return "board/boardList";
	}
	
//	@RequestMapping(value="/boardForm")
//	public String boardForm() {
//		return "board/boardForm";
//	}
	
//	@RequestMapping(value="/boardSave")
//	public String boardSave(@ModelAttribute BoardVO boardVO) {
//		boardService.insertBoard(boardVO);
//		return "redirect:/boardList";
//	}
	
	@RequestMapping(value="/boardRead")
	public String boardRead(HttpServletRequest request, Model model) {
		String brdno = request.getParameter("brdno");
		
		boardService.updateBoardRead(brdno);
		BoardVO boardInfo = boardService.selectBoardOne(brdno);
		model.addAttribute("boardInfo", boardInfo);
		return "board/boardRead";
	}
	@RequestMapping(value="/boardForm")
	public String boardForm(HttpServletRequest request, Model model) {
		String brdno = request.getParameter("brdno");
		if(brdno != null) {
		BoardVO boardInfo = boardService.selectBoardOne(brdno);
		model.addAttribute("boardInfo", boardInfo);
		}
		return "board/boardForm";
	}
	
	@RequestMapping(value="/boardSave")
	public String boardSave(@ModelAttribute("boardInfo") BoardVO boardInfo) {
		log.info("로그");
		FileUtil fs = new FileUtil();
		List<FileVO> filelist = fs.saveAllFiles(boardInfo.getUploadfile());
		if(boardInfo.getBrdno() == null || "".equals(boardInfo.getBrdno())) { log.info("여기라면 넌 insertBoard야");boardService.insertBoard(boardInfo,filelist); }
		else  log.info(boardInfo.getBrdno() + "여기라면 넌 update야"); boardService.updateBoard(boardInfo,filelist);
		return "redirect:/boardList";
	}
	@RequestMapping(value="/boardDelete")
	public String boardDelete(HttpServletRequest request) {
		String brdno = request.getParameter("brdno");
		boardService.deleteBoardOne(brdno);
		return "redirect:/boardList";
	}
}
