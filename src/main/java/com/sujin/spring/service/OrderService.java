package com.sujin.spring.service;

import java.util.List;
import java.util.Map;

import com.sujin.spring.vo.Cartitem;
import com.sujin.spring.vo.Item;
import com.sujin.spring.vo.OrderItem;
import com.sujin.spring.vo.Orders;

public interface OrderService {
	
	//상품등록
	public int addItem(Item item);
	
	//상품가져오기
	public List<Item> findItem();
	
	//아이디로 상품가져오기
	public Item findItemById(int item_id);
	
	//상품수정하기
	public int updateItem(Item item);
	
	//상품 삭제하기
	public int deleteItem(int item_id);
	
	//장바구니 담기
	public int addCartitem(Cartitem cartitem);
	
	//장바구니 가져오기
	public List<Map> selectCart(int cartitem_member_id);
	
	//아이템아이디로 장바구니 아이템찾기
	public Cartitem selectItem(Cartitem cartitem);
	
	//장바구니 아이템 수량 업데이트
	public int updateCount(Cartitem cartitem);
	
	//orderItem 생성
	public int orderItem(OrderItem orderItem);
	
	//orders 생성
	public int orders(Orders orders);
	
	//orders가져오기
	public List<Orders> findOrders();

	//장바구니 삭제
	public int deleteCartitem(int item_id);
	
	//주문리스트 가져오기
	public List<Map> findAllOrder();
	
	//주문상세 가져오기
	public List<Map> findOrderDetail(int order_id);
}
