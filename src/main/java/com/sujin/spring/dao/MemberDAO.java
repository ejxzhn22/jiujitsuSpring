package com.sujin.spring.dao;

import com.sujin.spring.vo.Member;

public interface MemberDAO {

	//회원가입
	public int join(Member member);
}
