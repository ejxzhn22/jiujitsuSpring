package com.sujin.spring.vo;


/*cartitem_id int PK 
cartitem_member_id int 
cartitem_item_id int 
cartitem_price int 
cartitem_count int
*/
public class Cartitem {
	
	private int cartitem_id;
	private int cartitem_member_id;
	private int cartitem_item_id;
	private int cartitem_price;
	private int cartitem_count;
	public int getCartitem_id() {
		return cartitem_id;
	}
	public void setCartitem_id(int cartitem_id) {
		this.cartitem_id = cartitem_id;
	}
	public int getCartitem_member_id() {
		return cartitem_member_id;
	}
	public void setCartitem_member_id(int cartitem_member_id) {
		this.cartitem_member_id = cartitem_member_id;
	}
	public int getCartitem_item_id() {
		return cartitem_item_id;
	}
	public void setCartitem_item_id(int cartitem_item_id) {
		this.cartitem_item_id = cartitem_item_id;
	}
	public int getCartitem_price() {
		return cartitem_price;
	}
	public void setCartitem_price(int cartitem_price) {
		this.cartitem_price = cartitem_price;
	}
	public int getCartitem_count() {
		return cartitem_count;
	}
	public void setCartitem_count(int cartitem_count) {
		this.cartitem_count = cartitem_count;
	}
	
	
	@Override
	public String toString() {
		return "Cartitem [cartitem_id=" + cartitem_id + ", cartitem_member_id=" + cartitem_member_id
				+ ", cartitem_item_id=" + cartitem_item_id + ", cartitem_price=" + cartitem_price + ", cartitem_count="
				+ cartitem_count + "]";
	}
	
	
}
