package com.sujin.spring.dao;

import java.util.List;
import java.util.Map;

import com.sujin.spring.vo.Member;

public interface MemberDAO {

	//회원가입
	public int join(Member member);
	
	//아이디 찾기
	public Member searchById(String mb_id);
}
