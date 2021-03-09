package com.sujin.spring.vo;


/*
 * item_id int AI PK 
item_name varchar(45) 
item_price int 
itme_size varchar(45) 
item_stockQuantity int
*/
public class Item {

	
	private int item_id;
	private String item_name;
	private int item_price;
	private String item_size;
	private int item_stockQuantity;
	private String item_content;
	private String item_image;
	
	
	
	
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_size() {
		return item_size;
	}
	public void setItem_size(String item_size) {
		this.item_size = item_size;
	}
	public int getItem_stockQuantity() {
		return item_stockQuantity;
	}
	public void setItem_stockQuantity(int item_stockQuantity) {
		this.item_stockQuantity = item_stockQuantity;
	}
	
	
	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", item_price=" + item_price + ", item_size="
				+ item_size + ", item_stockQuantity=" + item_stockQuantity + ", item_content=" + item_content
				+ ", item_image=" + item_image + "]";
	}
	
	
}
