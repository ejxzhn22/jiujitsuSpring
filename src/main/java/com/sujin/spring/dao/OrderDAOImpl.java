package com.sujin.spring.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;
import com.sujin.spring.vo.Cartitem;
import com.sujin.spring.vo.Item;
import com.sujin.spring.vo.OrderItem;
import com.sujin.spring.vo.Orders;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Inject
	private SqlSession sqlSession;
	private static  final String namespace="com.sujin.spring.orderMapper";
	
	//상품등록
	@Override
	public int addItem(Item item) {
		return sqlSession.insert(namespace+".addItem", item);
	}

	//상품 가져오기
	@Override
	public List<Item> findItem() {
		return sqlSession.selectList(namespace+".findItem");
	}

	//상품 아이디로 가져오기
	@Override
	public Item findItemById(int item_id) {
		return sqlSession.selectOne(namespace+".findItemById", item_id);
	}

	//상품 수정하기
	@Override
	public int updateItem(Item item) {
		return sqlSession.update(namespace+".updateItem", item);
	}

	// 상품 삭제하기
	@Override
	public int deleteItem(int item_id) {
		return sqlSession.delete(namespace+".deleteItem", item_id);
	}

	
	//장바구니 담기
	@Override
	public int addCart(Cartitem cartitem) {
		return sqlSession.insert(namespace+".addCart", cartitem);
	}

	//장바구니 가져오기
	@Override
	public List<Map> selectCart(int cartitem_member_id) {
		return sqlSession.selectList(namespace+".selectCart", cartitem_member_id);
	}

	
	//아이템아이디로 장바구니 아이템찾기
	@Override
	public Cartitem selectItem(Cartitem cartitem) {
		return sqlSession.selectOne(namespace+".selectItem",cartitem);
	}

	//장바구니 아이템 수량 업데이트
	@Override
	public int updateCount(Cartitem cartitem) {
		return sqlSession.update(namespace+".updateCount", cartitem);
	}
	
	//orderItem 생성
	@Override
	public int orderItem(OrderItem orderItem) {
		return sqlSession.insert(namespace+".orderItem", orderItem);
	}

	//orders 생성
	@Override
	public int orders(Orders orders) {
		return sqlSession.insert(namespace+".orders", orders);
	}

	//orders가져오기
	@Override
	public List<Orders> findOrders() {
		return sqlSession.selectList(namespace+".findOrders");
	}

	
	//장바구니 삭제
	@Override
	public int deleteCartitem(int item_id) {
		return sqlSession.delete(namespace+".deleteCartitem", item_id);
	}

	//주문리스트 가져오기
	@Override
	public List<Map> findAllOrder() {
		return sqlSession.selectList(namespace+".findAllOrder");
	}

	//주문상세 가져오기
	@Override
	public List<Map> findOrderDetail(int order_id) {
		return sqlSession.selectList(namespace+".findOrderDetail", order_id);
	}
	
	
}
