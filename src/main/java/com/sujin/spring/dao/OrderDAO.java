package com.sujin.spring.dao;

import java.util.List;
import java.util.Map;

import com.sujin.spring.vo.Cartitem;
import com.sujin.spring.vo.Item;

public interface OrderDAO {

	
	//상품등록
	public int addItem(Item item);
	
	//상품가져오기
	public List<Item> findItem();
	
	//id로 상품가져오기
	public Item findItemById(int item_id);
	
	//상품 수정하기
	public int updateItem(Item item);
	
	//상품 삭제하기
	public int deleteItem(int item_id);
	
	//장바구니 담기
	public int addCart(Cartitem cartitem);
	
	//장바구니 가져오기
	public List<Map> selectCart(int cartitem_member_id);
}
