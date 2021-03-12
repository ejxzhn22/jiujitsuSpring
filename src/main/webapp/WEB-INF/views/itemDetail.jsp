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
					<h2>Single Product Page</h2>
					<div class="page_link">
						<a href="index.html">Home</a>
						<a href="category.html">Category</a>
						<a href="single-product.html">Product Details</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->

	<!--================Single Product Area =================-->
	<div class="product_image_area">
		<div class="container">
			<div class="row s_product_inner">
				<div class="col-lg-6">
					<div class="s_product_img">
					<img src="${path}/resources/images/${item.item_image}" style="width:585px; height:600px;" />
						<!-- <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel"> -->
							<%-- <ol class="carousel-indicators">
								<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active">
									<img src="${path}/resources/images/${item.item_image}" />
								</li> --%>
								<!-- <li data-target="#carouselExampleIndicators" data-slide-to="1">
									<img src="img/product/single-product/s-product-s-3.jpg" alt="">
								</li>
								<li data-target="#carouselExampleIndicators" data-slide-to="2">
									<img src="img/product/single-product/s-product-s-4.jpg" alt="">
								</li> -->
							<!-- </ol> -->
							<!-- <div class="carousel-inner">
								<div class="carousel-item active">
									<img class="d-block w-100" src="img/product/single-product/s-product-1.jpg" alt="First slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="img/product/single-product/s-product-1.jpg" alt="Second slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" src="img/product/single-product/s-product-1.jpg" alt="Third slide">
								</div>
							</div> -->
						<!-- </div> -->
					</div>
				</div>
				<div class="col-lg-5 offset-lg-1">
					<div class="s_product_text">
					<form action="/addCart" method="post">
						<h3>${item.item_name}</h3>
						<input type="hidden" value="${item.item_id}" name="cartitem_item_id"/>
						<input type="hidden" value="${item.item_price}" name="cartitem_price" />
						<h2>&#8361;${item.item_price}</h2>
						<ul class="list">
							<!-- <li>
								<a class="active" href="#">
									<span>Category</span> : Household</a>
							</li>
							<li>
								<a href="#">
									<span>Availibility</span> : In Stock</a>
							</li> -->
						</ul>
						<p>${item.item_content }</p>
						<div class="product_count">
							<label for="qty">Quantity:</label>
							<input type="text" name="cartitem_count" id="sst" maxlength="${item.item_stockQuantity }" value="1" title="Quantity:" class="input-text qty">
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst < ${item.item_stockQuantity} ) result.value++;return false;"
							 class="increase items-count" type="button">
								<i class="lnr lnr-chevron-up"></i>
							</button>
							<button onclick="var result = document.getElementById('sst'); var sst = result.value; if( !isNaN( sst ) &amp;&amp; sst > 0 ) result.value--;return false;"
							 class="reduced items-count" type="button">
								<i class="lnr lnr-chevron-down"></i>
							</button>
						</div>
						<input type="hidden" name="cartitem_item_id" />
						<div class="card_area">
							<button type="submit" class="main_btn" value="Add to Cart">Add to Cart</button>
							
						</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--================End Single Product Area =================-->



	
	<!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>

</html>