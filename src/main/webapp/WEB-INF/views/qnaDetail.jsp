<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html lang="en">
<link rel="stylesheet" href="${path}/resources/mycss/qnaDetail.css">


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
                        <a href="single-blog.html">Board Q&A</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--================End Home Banner Area =================-->

    <section class="sample-text-area">
		<div class="container">
			<div class="main">
				<div>
					<h3 class="text-heading title_color">${board.b_title}</h3>
				</div>
				<div class="textBox mainText">
					${board.b_content }
				</div>
				<div class="textBox">
					작성자 : ${board.b_writer} &nbsp;&nbsp;&nbsp; 작성일 : ${board.b_date}
				</div>
				
				<c:if test="${sessionId eq board.b_writer }">
					<div >
					<!-- Button trigger modal -->
						<button type="button" class="genric-btn primary-border circle" data-toggle="modal" data-target="#updateModal">수정</button>
						<button type="button" class="genric-btn danger-border circle" data-toggle="modal" data-target="#deleteModal">삭제</button>
					</div>
				</c:if>
			</div>
		</div>
	</section>
	

<!-- 수정 Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
	    <form method = "post" action="/updateBoard">
	      <div class="modal-header">
	        <input type="text" name="b_title" class="modal-title  modal-text" id="myModalLabel" value="${board.b_title}"style="width:400px;"/>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	     	<input type="hidden" name="b_no" value="${board.b_no }"/>
			<input type="text" name="b_content" class="modal-text" value="${board.b_content }" style="width:400px;height:200px;">
				
			<div >
				작성자 : ${board.b_writer} &nbsp;&nbsp;&nbsp; 작성일 : ${board.b_date}
			</div>
		
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary">Save changes</button>
	      </div>
      </form>
    </div>
  </div>
</div>


<!-- 삭제 Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	     	글을 삭제하시겠습니까?
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
	        <a href="/deleteBoard?b_no=${board.b_no}" class="btn btn-primary">Delete</a>
	      </div>
    </div>
  </div>
</div>

    <!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>

</html>