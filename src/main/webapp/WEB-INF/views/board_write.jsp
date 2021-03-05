<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--================Header Menu Area =================-->
		<%@ include file="include/headerMenu.jsp" %>
	<!--================Header Menu Area =================-->
	
	<!--================Home Banner Area =================-->
	<section class="banner_area">
		<div class="banner_inner d-flex align-items-center">
			<div class="container">
				<div class="banner_content text-center">
					<h2>Elements</h2>
					<div class="page_link">
						<a href="index.html">Home</a>
						<a href="elements.html">board_write</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!--================End Home Banner Area =================-->
	<!--================Form=================== -->
	<section class="blog_area single-post-area p_120">
   		<div class="container">
       		<div class="section-top-border">
       			<div class="row" >
					<div class="col-lg-8 col-md-8" style="text-align: center; margin:0 auto;">
       					<h3 style="margin-bottom:20px;">글작성</h3>
						<form method = "post" action="/boardQnaWrite">
							<div class="mt-10">
								<input type="text" name="b_title" placeholder="title" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Title'"
						 		required class="single-input">
							</div>
							<div class="mt-10">
								<textarea class="single-textarea" name="b_content" placeholder="Message" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Message'"
						 		required></textarea>
							</div>
							<div>
								<input type="text" class="single-input" name="b_writer" value="${sessionId }" readonly="readonly"/>
							</div>
							<input type="submit" value="작성완료" class="genric-btn info circle" style="margin-top:20px;"/>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- ============================================================================= -->						
	<!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->
</body>
</html>