package com.sujin.spring.service;

import java.util.List;

import com.sujin.spring.vo.Answer;
import com.sujin.spring.vo.Board;

public interface BoardService {
	
	//공지사항 글쓰기
	public int boardNoticeWrite(Board board);
	
	//qna 글쓰기
	public int boardQnaWrite(Board board);
	
	//공지사항 전체 가져오기
	public List<Board> selectNoticeBoard();
	
	//qna 전체 가져오기
	public List<Board> selectQnaBoard();
	
	//qna detail 
	public Board qnaDetail(int b_no);
	
	//게시판 update
	public int updateBoard(Board board);
	
	//게시판 delete
	public int deleteBoard(int b_no);
	
	//qna 답변달기
	public int answer(Answer answer);
		
	//qna 답변 있음 update
	public int updateAnswer(int answer_no);
	
	//답변 가져오기
	public Answer checkAnswer(int answer_no);
}
