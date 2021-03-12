package com.sujin.spring.vo;



/*
 * order_id int AI PK 
	member_id varchar(45) 
	order_date datetime 
	orderItem_id int
*/
public class Orders {
	
	private int order_id;
	private String member_id;
	private String order_date;
	private String order_addr1;
	private String order_addr2;
	private String order_addr3;
	
	
	
	public String getOrder_addr1() {
		return order_addr1;
	}
	public void setOrder_addr1(String order_addr1) {
		this.order_addr1 = order_addr1;
	}
	public String getOrder_addr2() {
		return order_addr2;
	}
	public void setOrder_addr2(String order_addr2) {
		this.order_addr2 = order_addr2;
	}
	public String getOrder_addr3() {
		return order_addr3;
	}
	public void setOrder_addr3(String order_addr3) {
		this.order_addr3 = order_addr3;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	
	
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", member_id=" + member_id + ", order_date=" + order_date + ", addr1="
				+ order_addr1 + ", addr2=" + order_addr2 + ", addr3=" + order_addr3 + "]";
	}

	
	
}
