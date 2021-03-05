package com.sujin.spring.service;

import java.util.List;

import com.sujin.spring.vo.Member;

public interface AdminService {
	
	//회원정보가져오기
	public List<Member> findMember();
	
	//회원탈퇴
	public int deleteMember(int mb_no);
}
