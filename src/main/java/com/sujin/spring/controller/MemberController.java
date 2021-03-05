package com.sujin.spring.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sujin.spring.service.MemberServiceImpl;
import com.sujin.spring.vo.Member;

@Controller
public class MemberController {
	@Inject
	private MemberServiceImpl memberService;

	
	//회원가입창
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "registration";
	}
	
	//회원가입
	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String join(Member member) {
		
		memberService.join(member);
		
		return "redirect:/";
	}
	
	//중복확인
	@RequestMapping(value="/duplicateById", method=RequestMethod.POST)
	public String duplicateById(String mb_id,Model model) {
		
		System.out.println("아이디 : " + mb_id);
		Boolean bl = memberService.duplicateById(mb_id);
		
		if(bl == true) {
			model.addAttribute("msg", "아이디를 사용가능합니당");
			return "alert";
		}else {
			model.addAttribute("msg", "아이디가 사용중입니다.");
			return "alert";
		}
	}
}
