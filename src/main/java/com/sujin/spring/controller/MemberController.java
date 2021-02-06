package com.sujin.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sujin.spring.service.MemberServiceImpl;
import com.sujin.spring.vo.Member;

@Controller
public class MemberController {
	@Inject
	private MemberServiceImpl memberService;

//	//로그인창
//	@RequestMapping(value="/login", method=RequestMethod.GET)
//	public String login() {
//		return "login";
//	}
	
	//회원가입창
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "registration";
	}
	
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member) {
		memberService.join(member);
		
		return "redirect:/";
	}
}
