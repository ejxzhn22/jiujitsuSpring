package com.sujin.spring.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sujin.spring.vo.Member;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Inject
	private SqlSession sqlSession;
	private static  final String namespace="com.sujin.spring.adminMapper";
	
	//회원정보 가져오기
	@Override
	public List<Member> findMember() {
		return sqlSession.selectList(namespace+".findMember");
	}

	//회원탈퇴
	@Override
	public int deleteMember(int mb_no) {
		return sqlSession.update(namespace+".deleteMember", mb_no);
	}

	
}
