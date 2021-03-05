package com.sujin.spring.dao;

import java.util.List;

import com.sujin.spring.vo.Member;

public interface AdminDAO {
	
	//회원정보 가져오기
	public List<Member> findMember();
	
	//회원 탈퇴
	public int deleteMember(int mb_no);
}
