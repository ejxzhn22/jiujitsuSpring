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
	private int orderItem_id;
	
	
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
	public int getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	
	
	@Override
	public String toString() {
		return "Orders [order_id=" + order_id + ", member_id=" + member_id + ", order_date=" + order_date
				+ ", orderItem_id=" + orderItem_id + "]";
	}
	
	
	
}
