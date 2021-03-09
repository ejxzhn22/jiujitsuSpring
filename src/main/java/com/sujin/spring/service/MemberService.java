package com.sujin.spring.service;

import com.sujin.spring.vo.Member;

public interface MemberService {

	//회원가입
	public int join(Member member);
	
	//아이디 중복 확인
	public Boolean duplicateById(String mb_id);
	
	//로그인
	public Boolean login(Member member);
	
	//아이디로 회원정보가져오기
	public Member searchMember(String mb_id);
}
