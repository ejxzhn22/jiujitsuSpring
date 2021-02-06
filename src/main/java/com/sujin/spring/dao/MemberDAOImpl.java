package com.sujin.spring.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sujin.spring.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	private static  final String namespace="com.sujin.spring.memberMapper";
	
	//회원가입
	public int join(Member member) {
		return sqlSession.insert(namespace+".join", member);
	}
}
