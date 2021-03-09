package com.sujin.spring.dao;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sujin.spring.vo.Cartitem;
import com.sujin.spring.vo.Item;

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
}
