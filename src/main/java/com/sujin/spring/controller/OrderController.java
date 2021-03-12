package com.sujin.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sujin.spring.service.MemberService;
import com.sujin.spring.service.OrderService;
import com.sujin.spring.vo.Cartitem;
import com.sujin.spring.vo.Item;
import com.sujin.spring.vo.Member;
import com.sujin.spring.vo.OrderItem;
import com.sujin.spring.vo.OrderItemList;
import com.sujin.spring.vo.Orders;

@Controller
public class OrderController {

	@Inject
	private OrderService orderService;
	@Inject
	private MemberService memberService;
	
	//상품등록 페이지로
	@RequestMapping(value="/addItem", method=RequestMethod.GET)
	public String addItem() {
		
		
		
		return "addItem";
	}
	
	//상품등록
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	public String addItem(MultipartFile file, MultipartHttpServletRequest multi, Item item ) {
		
		System.out.println("파일업로드");
		System.out.println("item : " + item);
		String fileTag = "ufile";
		
		String filePath = multi.getSession().getServletContext().getRealPath("resources/images/");
		System.out.println("절대경로 테스트============="+multi.getSession().getServletContext().getRealPath("resources/images/"));
		file = multi.getFile(fileTag);
		System.out.println(file);
		String fileName = file.getOriginalFilename();
		
		try {
			System.out.println("업로드 성공");
			file.transferTo(new File(filePath + fileName));
		}catch(Exception e) {
			System.out.println("업로드 오류");
		}
		
		item.setItem_image(fileName);
		System.out.println("item: " + item);
		
		orderService.addItem(item);
		
		
		return "redirect:/itemList";
	}
	
	//상품 수정 모달
	@ResponseBody
	@RequestMapping(value="modalDetail", method=RequestMethod.POST)
	public Item modalDetail(@RequestParam ("id") int item_id) {
		
		return orderService.findItemById(item_id);
	}
	
	//상품 수정하기
	@RequestMapping(value="/updateItem", method=RequestMethod.POST)
	public String updateItem(MultipartFile file, MultipartHttpServletRequest multi,Item item) {
		
		System.out.println("파일업로드");
		System.out.println("item : " + item);
		String fileTag = "ufile";
		
		String filePath = multi.getSession().getServletContext().getRealPath("resources/images/");
		System.out.println("절대경로 테스트============="+multi.getSession().getServletContext().getRealPath("resources/images/"));
		file = multi.getFile(fileTag);
		System.out.println(file);
		String fileName = file.getOriginalFilename();
		
		try {
			System.out.println("업로드 성공");
			file.transferTo(new File(filePath + fileName));
		}catch(Exception e) {
			System.out.println("업로드 오류");
		}
		
		
		item.setItem_image(fileName);
		
		orderService.updateItem(item);
		
		return "redirect:/itemList";
	}
	
	//상품 상세 페이지
	@RequestMapping(value="/itemDetail",method=RequestMethod.GET)
	public String itemDetail(@RequestParam("item_id") int item_id, Model model) {
		
		Item item = orderService.findItemById(item_id);
		model.addAttribute("item", item);
		
		return "itemDetail";
		
	}
	
	//상품 삭제하기
	@RequestMapping(value="/deleteItem",method=RequestMethod.GET)
	public String deleteItem(@RequestParam("item_id") int item_id) {
		orderService.deleteItem(item_id);
		
		return "redirect:/itemList";
	}
	
	//장바구니로 이동
	@RequestMapping(value="/cart", method=RequestMethod.GET)
	public String cart(Model model,  HttpServletRequest request) {
		 
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		List<Map> list = orderService.selectCart(member.getMb_no());
		
		
		model.addAttribute("list",list);
		return "cart"; 
	}
	
	//장바구니담기
	@RequestMapping(value="/addCart", method=RequestMethod.POST)
	public String addCart(Cartitem cartitem, HttpServletRequest request) {
		 
		HttpSession session = request.getSession();
		Member member1 = (Member) session.getAttribute("member");
		System.out.println("member1: " + member1);
		
		cartitem.setCartitem_member_id(member1.getMb_no());
		
		//동일상품 있는지
		
			System.out.println("무슨일이징: "+ cartitem);
			Cartitem cartitem1 =  orderService.selectItem(cartitem);
			
			System.out.println("cartitem1: "+ cartitem1);
			if(cartitem1 ==null) {
				System.out.println("cartitem: "+cartitem);
				orderService.addCartitem(cartitem);
			}else {
				
				//수량 업데이트
				orderService.updateCount(cartitem);
			}
		
		return "redirect:/cart";
	}
	
	//shop이동
	@RequestMapping(value="/shop", method=RequestMethod.GET)
	public String shop(Model model) {
		
		List<Item> list = orderService.findItem();
		model.addAttribute("list", list);
		return "shop";
	}
	
	//주문하기 이동
	@RequestMapping(value="/orderGo", method=RequestMethod.POST)
	public String orderGo(OrderItemList list, Model model, HttpServletRequest request) {

		List<Cartitem> itemList = new ArrayList<Cartitem>();
		List<String> nameList = new ArrayList<String>();
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		Cartitem cartitem = new Cartitem();
		
		
		for(int i=0; i<list.getList().size(); i++) {
			
			cartitem.setCartitem_member_id(member.getMb_no());
			cartitem.setCartitem_item_id(list.getList().get(i).getItem_id());
			cartitem.setCartitem_price(list.getList().get(i).getOrder_price());
			cartitem.setCartitem_count(list.getList().get(i).getOrder_count());

			Cartitem cartitem_tmp = orderService.selectItem(cartitem);
			
			nameList.add(list.getList().get(i).getItem_name());
			itemList.add(cartitem_tmp);
		}
		
		
		System.out.println("리스트: " + list.getList());
		
		
		model.addAttribute("nameList", nameList);
		model.addAttribute("list", itemList);
		return"order";
	}
	
	//주문하기
	@RequestMapping(value="/order", method=RequestMethod.POST)
	public String order(OrderItemList list, 
			@RequestParam("addr1") String addr1, @RequestParam("addr2") String addr2, @RequestParam("addr3") String addr3,
			HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");
		
		Orders orders = new Orders();
		
		orders.setOrder_addr1(addr1);
		orders.setOrder_addr2(addr2);
		orders.setOrder_addr3(addr3);
		
		orders.setMember_id(member.getMb_id());
		
		orderService.orders(orders);
		
		
		
		List<Orders> ordersList = orderService.findOrders();
		
		int order_id = ordersList.get(0).getOrder_id();
		
		//orderItemList로?
		for(int i=0; i<list.getList().size(); i++) {
			
			OrderItem orderItem = list.getList().get(i);
			orderItem.setOrder_id(order_id);
			orderService.orderItem(orderItem);
			
			//장바구니 삭제
			orderService.deleteCartitem(list.getList().get(i).getItem_id());
			
		}

		
		return "confirmation";
	}
	
	
	//주문 내역 페이지
	@RequestMapping(value="/confirmation", method=RequestMethod.GET)
	public String confirmation() {
		return "confirmation";
	}
}
