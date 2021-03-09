<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
    
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="icon" href="${path}/resources/img/favicon.png" type="image/png">
	<title>Fashiop</title>
	<script src="https://code.jquery.com/jquery-3.5.1.js"
			integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="crossorigin="anonymous">
		</script>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="${path}/resources/css/bootstrap.css">
	<link rel="stylesheet" href="${path}/resources/vendors/linericon/style.css">
	<link rel="stylesheet" href="${path}/resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="${path}/resources/vendors/owl-carousel/owl.carousel.min.css">
	<link rel="stylesheet" href="${path}/resources/vendors/lightbox/simpleLightbox.css">
	<link rel="stylesheet" href="${path}/resources/vendors/nice-select/css/nice-select.css">
	<link rel="stylesheet" href="${path}/resources/vendors/animate-css/animate.css">
	<link rel="stylesheet" href="${path}/resources/vendors/jquery-ui/jquery-ui.css">
	<!-- main css -->
	<link rel="stylesheet" href="${path}/resources/css/style.css">
	<link rel="stylesheet" href="${path}/resources/css/responsive.css">
</head>
    
<!--================Header Menu Area =================-->
	<header class="header_area">
		<div class="top_menu row m0">
			<div class="container-fluid">
				<div class="float-left">
					<p>Call Us: 012 44 5698 7456 896</p>
				</div>
				<div class="float-right">
					<ul class="right_side">
					<c:choose>
						<c:when test="${sessionId != null }">
							<li>${sessionId}님 환영!</li>
							<li>
								<a href="logout">
									LogOut
								</a>
							</li>
						</c:when>
						<c:otherwise>
							<li>
								<a href="login">
									Login/Register
								</a>
							</li>
						</c:otherwise>
						</c:choose>
						<li>
							<a href="#">
								My Account
							</a>
						</li>
						<li>
							<a href="contact.html">
								Contact Us
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="main_menu">
			<nav class="navbar navbar-expand-lg navbar-light">
				<div class="container-fluid">
					<!-- Brand and toggle get grouped for better mobile display -->
					<c:if test="${sessionId ne 'root' }">
						<a class="navbar-brand logo_h" href="/">
							<img src="${path}/resources/img/logo.png" alt="">
						</a>
					</c:if>
					<c:if test="${sessionId eq 'root' }">
						<a class="navbar-brand logo_h" href="/admin">
							<img src="${path}/resources/img/logo.png" alt="">
						</a>
					</c:if>
					<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
					 aria-expanded="false" aria-label="Toggle navigation">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse offset" id="navbarSupportedContent">
						<div class="row w-100">
							<div class="col-lg-7 pr-0">
								<ul class="nav navbar-nav center_nav pull-right">
									<li class="nav-item active">
										<a class="nav-link" href="/">Home</a>
									</li>
									<li class="nav-item submenu">
										<a href="/shop" class="nav-link "  role="button" aria-haspopup="true" aria-expanded="false">Shop</a>
										
									</li>
									<li class="nav-item submenu dropdown">
										<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Board</a>
										<ul class="dropdown-menu">
											<li class="nav-item">
												<a class="nav-link" href="/board_notice">공지사항</a>
											</li>
											<li class="nav-item">
												<a class="nav-link" href="/board_qna">Q&A</a>
											</li>
										</ul>
									</li>
									<li class="nav-item submenu dropdown">
										<a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
										<ul class="dropdown-menu">
											<li class="nav-item">
												<a class="nav-link" href="login.html">Login</a>
												<li class="nav-item">
													<a class="nav-link" href="tracking.html">Tracking</a>
													<li class="nav-item">
														<a class="nav-link" href="elements.html">Elements</a>
													</li>
										</ul>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="contact.html">Contact</a>
									</li>
								</ul>
							</div>

							<div class="col-lg-5">
								<ul class="nav navbar-nav navbar-right right_nav pull-right">
									<hr>
									<li class="nav-item">
										<a href="#" class="icons">
											<i class="fa fa-search" aria-hidden="true"></i>
										</a>
									</li>

									<hr>

									<li class="nav-item">
										<a href="#" class="icons">
											<i class="fa fa-user" aria-hidden="true"></i>
										</a>
									</li>

									<hr>

									<li class="nav-item">
										<a href="#" class="icons">
											<i class="fa fa-heart-o" aria-hidden="true"></i>
										</a>
									</li>

									<hr>

									<li class="nav-item">
										<a href="/cart" class="icons">
											<i class="lnr lnr lnr-cart"></i>
										</a>
									</li>

									<hr>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</nav>
		</div>
	</header>
	<!--================Header Menu Area =================-->