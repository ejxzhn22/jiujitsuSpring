package com.sujin.spring.vo;

public class Member {
	
	private String mb_id;
	private String mb_pw;
	private String mb_name;
//	private String mb_phone;
//	private String mb_address;
	
	
	
	
	public Member(String mb_id, String mb_pw, String mb_name) {
		super();
		this.mb_id = mb_id;
		this.mb_pw = mb_pw;
		this.mb_name = mb_name;
//		this.mb_phone = mb_phone;
//		this.mb_address = mb_address;
	}
	public String getMb_id() {
		return mb_id;
	}
	public void setMb_id(String mb_id) {
		this.mb_id = mb_id;
	}
	public String getMb_pw() {
		return mb_pw;
	}
	public void setMb_pw(String mb_pw) {
		this.mb_pw = mb_pw;
	}
	public String getMb_name() {
		return mb_name;
	}
	public void setMb_name(String mb_name) {
		this.mb_name = mb_name;
	}
//	public String getMb_phone() {
//		return mb_phone;
//	}
//	public void setMb_phone(String mb_phone) {
//		this.mb_phone = mb_phone;
//	}
//	public String getMb_address() {
//		return mb_address;
//	}
//	public void setMb_address(String mb_address) {
//		this.mb_address = mb_address;
//	}
	@Override
	public String toString() {
		return "Member [mb_id=" + mb_id + ", mb_pw=" + mb_pw + ", mb_name=" + mb_name + "]";
	}
	
	
	
	
	
}
