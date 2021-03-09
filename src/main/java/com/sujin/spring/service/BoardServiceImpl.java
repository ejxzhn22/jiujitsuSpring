package com.sujin.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sujin.spring.dao.BoardDAO;
import com.sujin.spring.vo.Answer;
import com.sujin.spring.vo.Board;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO boardDAO;
	
	//공지사항 글쓰기
	@Override
	public int boardNoticeWrite(Board board) {
		return boardDAO.boardNoticeWrite(board);
	}

	//qna 글쓰기
	@Override
	public int boardQnaWrite(Board board) {
		
		return boardDAO.boardQnaWrite(board);
	}

	//공지사항 전체 가져오기
	@Override
	public List<Board> selectNoticeBoard() {
		return boardDAO.selectNoticeBoard();
	}

	//qna 전체 가져오기 
	@Override
	public List<Board> selectQnaBoard() {
		
		return boardDAO.selectQnaBoard();
	}

	//qna detail
	@Override
	public Board qnaDetail(int b_no) {
		
		return boardDAO.qnaDetail(b_no);
	}

	//게시판 update
	@Override
	public int updateBoard(Board board) {
		return boardDAO.updateBoard(board);
	}

	
	//게시판 delete
	@Override
	public int deleteBoard(int answer_no) {
		return boardDAO.deleteBoard(answer_no);
	}

	//qna 답변달기
	@Override
	public int answer(Answer answer) {
		return boardDAO.answer(answer);
	}

	//qna 답변 update
	@Override
	public int updateAnswer(int b_no) {
		return boardDAO.updateAnswer(b_no);
	}

	//답변 가져오기
	@Override
	public Answer checkAnswer(int answer_no) {
		return boardDAO.checkAnswer(answer_no);
	}
	
}
