package com.sujin.spring.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sujin.spring.service.BoardService;
import com.sujin.spring.vo.Answer;
import com.sujin.spring.vo.Board;

@Controller
public class BoardController {
	
	@Inject
	private BoardService boardService;
	
	//공지사항 게시판
	@RequestMapping(value="/board_notice", method=RequestMethod.GET)
	public String board_notice() {
		return "board_notice";
	}
	
	//qna 게시판
	@RequestMapping(value="/board_qna", method=RequestMethod.GET)
	public String board_qna(Model model) {
		
		List<Board> list = boardService.selectQnaBoard();
		model.addAttribute("qnalist", list);
		return "board_qna";
	}
	
	//글쓰기 
	@RequestMapping(value="/boardQnaWrite", method=RequestMethod.GET)
	public String boardQnaWrite() {
		return "board_write";
	}
	
	//qna 글쓰기 
	@RequestMapping(value="/boardQnaWrite", method=RequestMethod.POST)
	public String boardQnaWrite(Board board) {
		
		boardService.boardQnaWrite(board);
		return "redirect:board_qna";
	}
	
	//qna 글 상세 페이지
	@RequestMapping(value="/qnaDetail", method=RequestMethod.GET)
	public String boardQnaDetail(@RequestParam("b_no")int b_no, Model model) {
		Board board =boardService.qnaDetail(b_no);
		model.addAttribute("board", board);
		return "qnaDetail";
	}
	
	// QNA 글상세 답변
	@ResponseBody
	@RequestMapping(value="/answerDetail", method=RequestMethod.POST)
	public Board answerDetail(@RequestParam("id") int b_no) {
		
		return boardService.qnaDetail(b_no);
	}
	
	//qna답변 보기
	@ResponseBody
	@RequestMapping(value="/checkAnswer", method=RequestMethod.POST)
	public Answer checkAnswer(@RequestParam("id") int answer_no) {
		System.out.println("답변번호: " + answer_no);
		return boardService.checkAnswer(answer_no);
	}
	
	//게시판 update
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(Board board) {
		boardService.updateBoard(board);
		return "redirect:/qnaDetail?b_no="+board.getB_no();
	}
	
	//게시판 delete
	@RequestMapping(value="/deleteBoard", method=RequestMethod.GET)
	public String deleteBoard(int b_no) {
		boardService.deleteBoard(b_no);
		return "redirect:/board_qna";
	}
	
	//qna 답변달기
	@RequestMapping(value="/addAnswer", method=RequestMethod.POST)
	public String answer(Answer answer, Model model) {
		System.out.println("여긴오니: "+ answer.getAnswer_no());
		boardService.answer(answer);
		boardService.updateAnswer(answer.getAnswer_no());
		
		return "redirect:/board_qna";
	}
	
	
	
	
	
}
