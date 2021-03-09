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
                    <h2>Board</h2>
                    <div class="page_link">
                        <a href="index.html">Home</a>
                        <a href="single-blog.html">Board notice</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Home Banner Area =================-->

    <!--================Blog Area =================-->
    <section class="blog_area single-post-area p_120">
   	 <div class="container">
        <div class="section-top-border">
				<div style="display:flex; justify-content: space-around;">
					<h3 class="mb-30 title_color">공지사항</h3>
					<c:if test="${sessionId eq 'root' }">
						<a href="/boardQnaWrite" class="genric-btn info circle" style="height:40px;">글쓰기</a>
					</c:if>
				</div>
				<div class="progress-table-wrap">
					<div class="progress-table">
						<div class="table-head">
							<div class="serial">번호</div>
							<div class="country">글제목</div>
							<div class="visit">작성자</div>
							<div class="percentage">작성일자</div>
							<div class="percentage"></div>
						</div>
						 <c:forEach var="list" items="${noticeList}" >
          					<div class="table-row">
           						<div class="serial">${list.b_no}</div>
            					<div class="country"><a href="/qnaDetail?b_no=${list.b_no}">${list.b_title}</a></div>
            					<div class="visit">${list.b_writer}</div>
            					<div class="percentage">${list.b_date}</div>
            					<c:if test="${sessionId eq 'root' }">
	            					<div class="percentage">
	            						<button type="button" onclick="modal_click(this.id)" id="${list.b_no }" class="modalBtn genric-btn danger circle" data-toggle="modal" data-target="#answer">
	            							삭제</button>
	            					</div>
            					</c:if>
            				</div>
            			</c:forEach>
					</div>
				</div>
			</div>
			</div>
		</section>

    <!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>

</html>