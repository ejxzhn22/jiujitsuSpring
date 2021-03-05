package com.sujin.spring.dao;

import java.util.List;
import java.util.Map;

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

	
	//아이디 찾기
	@Override
	public Member searchById(String mb_id) {
		return sqlSession.selectOne(namespace+".searchById", mb_id);
	}
}
