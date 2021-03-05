package com.sujin.spring.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sujin.spring.dao.AdminDAO;
import com.sujin.spring.dao.BoardDAO;
import com.sujin.spring.vo.Member;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private AdminDAO adminDAO;

	
	//회원정보 가져오기
	@Override
	public List<Member> findMember() {
		return adminDAO.findMember();
	}

	//회원탈퇴
	@Override
	public int deleteMember(int mb_no) {
		return adminDAO.deleteMember(mb_no);
	}
	
	
}
