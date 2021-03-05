package com.sujin.spring.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
	
	//로그인
	
	public Boolean login(Member member) {
		Member searchMember = memberDAO.searchById(member.getMb_id());
		
		if(member.getMb_pw().equals(searchMember.getMb_pw())) {
			return true;
		}else {
			return false;
		}
	}


	// 아이디 중복 확인하기
	@Override
	public Boolean duplicateById(String mb_id) {
		Member member = memberDAO.searchById(mb_id);
		
		/*
		if(id.equals(null)) {
			System.out.println("없음");
			return true;
		}else {
			System.out.println("있음");
			return false;
		}
		*/
		
		try {
			String id = member.getMb_id();
			id.equals(null);
		}catch(NullPointerException e) {
			return true;
		}
		
		return false;
		
		
			
	}
}
