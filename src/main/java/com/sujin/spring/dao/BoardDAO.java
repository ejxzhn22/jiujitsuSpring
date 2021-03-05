package com.sujin.spring.dao;

import java.util.List;

import com.sujin.spring.vo.Answer;
import com.sujin.spring.vo.Board;

public interface BoardDAO {
	
	//공지사항 글쓰기
	public int boardNoticeWrite(Board board);
	
	//공지사항 글 가져오기
	public List<Board> selectNoticeBoard();
	
	//Q&A 글쓰기
	public int boardQnaWrite(Board board);
	
	//Q&A 글 가져오기
	public List<Board> selectQnaBoard();
	
	//qna b_no로 글정보 가져오기
	public Board qnaDetail(int b_no);
	
	//게시판 update
	public int updateBoard(Board board);
	
	//게시판 delete
	public int deleteBoard(int b_no);
	
	//qna 답변달기
	public int answer(Answer answer);
	
	//qna 답변 있음 update
	public int updateAnswer(int answer_no);
	
	//qna 답변 가져오기
	public Answer checkAnswer(int answer_no);
}
