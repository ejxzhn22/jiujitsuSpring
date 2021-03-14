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
					<h2>Order Confirmation</h2>
					<div class="page_link">
						<a href="index.html">Home</a>
						<a href="confirmation.html">Confirmation</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================Order Details Area =================-->
	<section class="order_details p_120">
		<div class="container">
			<h3 class="title_confirmation">Thank you. Your order has been received.</h3>
			<div class="row order_d_inner">
				<div class="col-lg-6">
					<div class="details_item">
						<h4>Order Info</h4>
						<ul class="list">
							<li>
								<a href="#">
		
									<span>Order number</span> : ${list[0].order_id} </a>
							</li>
							<li>
								<a href="#">
									<span>Date</span> : ${list[0].order_date }</a>
							</li>
							
							
						</ul>
					</div>
				</div>
				<div class="col-lg-6">
					<div class="details_item">
						<h4>Address</h4>
						<ul class="list">
							<li>
								<a href="#">
									<span>우편번호</span> : ${list[0].order_addr1 }</a>
							</li>
							<li>
								<a href="#">
									<span>주소</span> : ${list[0].order_addr2 }</a>
							</li>
							
							<li>
								<a href="#">
									<span>상세주소 </span> : ${list[0].order_addr3 }</a>
							</li>
						</ul>
					</div>
				</div>
				
			</div>
			<div class="order_details_table">
				<h2>Order Details</h2>
				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th scope="col">Product</th>
								<th scope="col">Quantity</th>
								<th scope="col">Total</th>
							</tr>
						</thead>
						<tbody>
						<c:set var="sum" value="0"/>
						<c:forEach var="item" items="${list}">
							<tr>
								<td>
									<p>${item.item_name }</p>
								</td>
								<td>
									<h5>${item.order_count }</h5>
								</td>
								<td>
									<p> &#8361; ${item.order_price * item.order_count }</p>
								</td>
							</tr>
					
								<c:set var= "sum" value="${sum + item.order_price * item.order_count}"/>
							
							</c:forEach>
							<tr>
							
								<td>
								</td>
								<td>
								</td>
								<td>
									<p> &#8361; <c:out value="${sum }"/></p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
	<!--================End Order Details Area =================-->

	
	<!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>

</html>