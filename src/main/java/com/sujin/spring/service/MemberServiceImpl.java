package com.sujin.spring.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sujin.spring.dao.MemberDAOImpl;
import com.sujin.spring.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Inject
	private MemberDAOImpl memberDAO;
	
	
	//회원가입
	public int join(Member member) {
		
		return memberDAO.join(member);
	}
}
