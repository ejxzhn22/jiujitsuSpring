<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html lang="en">



<body>
	<!--================Header Menu Area =================-->
	<%@ include file="include/headerMenu.jsp" %>
	<!--================Header Menu Area =================-->

	<!--================Home Banner Area =================-->
	<section class="banner_area">
		<div class="banner_inner d-flex align-items-center">
			<div class="container">
				<div class="banner_content text-center">
					<h2>Shopping Cart</h2>
					<div class="page_link">
						<a href="index.html">Home</a>
						<a href="cart.html">Cart</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================Cart Area =================-->
	<section class="cart_area">
		<div class="container">
			<div class="cart_inner">
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Product</th>
								<th scope="col">Price</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
						<form action="/orderGo" method="post">
						<c:set var = "sum" value = "0" />
						<c:forEach var="item" items="${list}" varStatus="status">
							<tr>
								<td>
									<div class="media">
										<div class="d-flex">
											<img src="${path}/resources/images/${item.item_image}" style="width:80px; height:80px;"/>
										</div>
										<div class="media-body">
										<input type="hidden" name="list[${status.index}].item_id" value="${item.item_id }"/>
										<input type="hidden" name="list[${status.index}].item_name" value="${item.item_name }"/>
										<label><input type="checkbox"  onclick="click_checkbox(this.id)" id="${status.index}" name="${item.cartitem_price * item.cartitem_count}" value="${item.item_name }">${item.item_name }</label>
										</div>
									</div>
								</td>
							
								<td>
									<h5>&#8361;${item.cartitem_price }</h5>
									<input type="hidden" name="list[${status.index}].order_price" value="${item.cartitem_price }"/>
								</td>
								<td>
									<div class="product_count">
										<input type="text" name="list[${status.index}].order_count" id="sst"  maxlength="12" value="${item.cartitem_count }" title="Quantity:" class="input-text qty">
										
									</div>
								</td>
								<td>
								
									<h5>
										&#8361; 
										<c:set var="total" value=" ${item.cartitem_price * item.cartitem_count}"/>
										<c:out   value=" ${total}"/>
									</h5>
									<c:set var= "sum" value="${sum + item.cartitem_price * item.cartitem_count}"/>
								</td>
							</tr>
						</c:forEach>
							
							<tr>
								<td>

								</td>
								<td>

								</td>
								<td>
									<h5>Subtotal</h5>
								</td>
								<td>
									<h5>
										&#8361;	
										<input type="text" value="0" id="total_price" readonly="readonly">
									</h5>
								</td>
							</tr>
							
							<tr class="out_button_area">
								<td>

								</td>
								<td>

								</td>
								<td>

								</td>
								<td>
									<div class="checkout_btn_inner">
										<a class="gray_btn" href="/shop">Continue Shopping</a>
										<button type="submit" class="main_btn" >주문하기</button>
									</div>
								</td>
							</tr>
							</form>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--================End Cart Area =================-->


	<!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->

<script>

	
	
	
	function click_checkbox(id){
		 var value = document.getElementById('total_price').value;
		 var check = document.getElementById(id).checked
		 var price = document.getElementById(id).getAttribute('name');
		 
		 
		 console.log("price : " + price);
		 console.log("check : "+ check);
		 
		 if(check){
			 
		 	document.getElementById('total_price').value = value*1 + price*1;
		 	
		}else{
			
			document.getElementById('total_price').value = value*1 - price*1;
			
		}
		 
	}
	
</script>

</body>

</html>