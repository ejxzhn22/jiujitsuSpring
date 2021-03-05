package com.sujin.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sujin.spring.vo.Answer;
import com.sujin.spring.vo.Board;

@Repository
public class BoardDAOImpl implements BoardDAO{
	@Inject
	private SqlSession sqlSession;
	private static  final String namespace="com.sujin.spring.boardMapper";
	

	//공지사항 글쓰기
	@Override
	public int boardNoticeWrite(Board board) {
		return sqlSession.insert(namespace+".boardNoticeWrite", board);
	}

	//공지사항 글 가져오기
	@Override
	public List<Board> selectNoticeBoard() {
		return sqlSession.selectList(namespace+".selectNoticeBoard");
	}

	//qna글쓰기
	@Override
	public int boardQnaWrite(Board board) {
		// TODO Auto-generated method stub
		return sqlSession.insert(namespace+".boardQnaWrite", board);
	}

	
	//qna 글 가져오기
	@Override
	public List<Board> selectQnaBoard() {
		return sqlSession.selectList(namespace+".selectQnaBoard");
	}

	//qna b_no으로 글 정보가져오기 
	@Override
	public Board qnaDetail(int b_no) {
		return sqlSession.selectOne(namespace+".qnaDetail", b_no);
	}

	//게시판 update
	@Override
	public int updateBoard(Board board) {
		return sqlSession.update(namespace+".updateBoard", board);
	}

	//게시판 delete
	@Override
	public int deleteBoard(int b_no) {
		return sqlSession.delete(namespace+".deleteBoard", b_no);
	}

	//qna 답변달기
	@Override
	public int answer(Answer answer) {
		return sqlSession.insert(namespace+".answer", answer);
	}

	//qna 답변있음 update
	@Override
	public int updateAnswer(int answer_no) {
		return sqlSession.update(namespace+".updateAnswer", answer_no);
	}

	
	//답변 가져오기
	@Override
	public Answer checkAnswer(int answer_no) {
		return sqlSession.selectOne(namespace+".checkAnswer", answer_no);
	}

}
