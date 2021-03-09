<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html lang="en">



<body>
	<!--================Header Menu Area =================-->
	<%@ include file="../include/headerMenu.jsp" %>
	<!--================Header Menu Area =================-->

    <!--================Home Banner Area =================-->
    <section class="banner_area">
        <div class="banner_inner d-flex align-items-center">
            <div class="container">
                <div class="banner_content text-center">
                    <h2>Admin</h2>
                </div>
            </div>
        </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================admin Area =================-->
    <section class="blog_area single-post-area p_120">
   		<div class="container">
        	<a href="/admin/memberList" class="genric-btn primary-border radius" >회원관리</a>
        	<a href="/itemList" class="genric-btn success-border radius">상품관리</a>
        	<a href="/board_notice" class="genric-btn info-border radius">공지사항 관리</a>
        	<a href="/board_qna" class="genric-btn danger-border radius">Q&A 답변</a>
			
		</div>
	</section>

    <!--================ start footer Area  =================-->
	<%@ include file="../include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>

</html>