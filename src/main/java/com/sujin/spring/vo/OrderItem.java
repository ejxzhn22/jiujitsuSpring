package com.sujin.spring.vo;


/*
 * orderItem_id int AI PK 
item_id int 
order_id int 
order_price int 
order_count int
*/
public class OrderItem {
	
	private int orderItem_id;
	private int item_id;
	private int order_id;
	private int order_price;
	private int order_count;
	
	
	
	
	public int getOrderItem_id() {
		return orderItem_id;
	}
	public void setOrderItem_id(int orderItem_id) {
		this.orderItem_id = orderItem_id;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getOrder_count() {
		return order_count;
	}
	public void setOrder_count(int order_count) {
		this.order_count = order_count;
	}
	
	
	@Override
	public String toString() {
		return "OrderItem [orderItem_id=" + orderItem_id + ", item_id=" + item_id + ", order_id=" + order_id
				+ ", order_price=" + order_price + ", order_count=" + order_count + "]";
	}


	
	
}
