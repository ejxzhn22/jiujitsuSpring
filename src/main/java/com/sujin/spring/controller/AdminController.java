package com.sujin.spring.controller;

import java.util.List;
import java.util.ArrayList;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sujin.spring.service.AdminService;
import com.sujin.spring.service.BoardService;
import com.sujin.spring.vo.Member;

@Controller
public class AdminController {
	
	@Inject
	private AdminService adminService;
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String admin() {
		
		return "admin/admin";
	}
	
	@RequestMapping(value="/admin/memberList", method=RequestMethod.GET)
	public String memberList(Model model) {

		List<Member> memberList = adminService.findMember();
		model.addAttribute("list", memberList);
		
		System.out.println("리스트 : "+memberList.toString());
		return "admin/memberList";
	}
	
	@RequestMapping(value="/admin/deleteMember", method=RequestMethod.GET)
	public String deleteMember(@RequestParam("mb_no") int mb_no) {
		adminService.deleteMember(mb_no);
		
		return "redirect:/admin/memberList";
	}
}
