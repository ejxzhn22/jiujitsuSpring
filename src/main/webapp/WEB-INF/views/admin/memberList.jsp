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
                    <h2>memberList</h2>
                </div>
            </div>
        </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Blog Area =================-->
    <section class="blog_area single-post-area p_120">
   	 <div class="container">
        <div class="section-top-border">
				<h3 class="mb-30 title_color">MemberList</h3>
				<div class="progress-table-wrap">
					<div class="progress-table">
						<div class="table-head">
							<div class="serial">회원번호</div>
							<div class="country">회원아이디</div>
							<div class="visit">회원이름</div>
							<div class="percentage"></div>
						</div>
						 <c:forEach var="member" items="${list}">
          					<div class="table-row">
           						<div class="serial">${member.mb_no}</div>
            					<div class="country">${member.mb_id}</div>
            					<div class="visit">${member.mb_name }</div>
            					<div class="percentage"><a href="/admin/deleteMember?mb_no=${member.mb_no}" class="genric-btn danger-border circle">탈퇴</a></div>
            				</div>
            			</c:forEach>
					</div>
				</div>
			</div>
			</div>
		</section>

    <!--================ start footer Area  =================-->
	<%@ include file="../include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>

</html>