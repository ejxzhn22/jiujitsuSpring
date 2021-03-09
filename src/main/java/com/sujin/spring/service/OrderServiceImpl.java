package com.sujin.spring.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sujin.spring.dao.OrderDAO;
import com.sujin.spring.vo.Cartitem;
import com.sujin.spring.vo.Item;

@Service
public class OrderServiceImpl implements OrderService{

	@Inject
	private OrderDAO orderDAO;

	//상품등록
	@Override
	public int addItem(Item item) {
		return orderDAO.addItem(item);
	}

	//상품가져오기
	@Override
	public List<Item> findItem() {
		return orderDAO.findItem();
	}

	//아이디로 상품 가져오기
	@Override
	public Item findItemById(int item_id) {
		return orderDAO.findItemById(item_id);
	}

	//상품 수정하기
	@Override
	public int updateItem(Item item) {
		return orderDAO.updateItem(item);
	}

	//상품 삭제하기
	@Override
	public int deleteItem(int item_id) {
		return orderDAO.deleteItem(item_id);
	}

	//장바구니 담기
	@Override
	public int addCartitem(Cartitem cartitem) {
		return orderDAO.addCart(cartitem);
	}

	//장바구니 가져오기
	@Override
	public List<Map> selectCart(int cartitem_member_id) {
		return orderDAO.selectCart(cartitem_member_id);
	}
}
