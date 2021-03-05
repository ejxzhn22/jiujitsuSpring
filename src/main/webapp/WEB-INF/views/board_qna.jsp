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
                        <a href="single-blog.html">Board Q&A</a>
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
					<h3 class="mb-30 title_color">Q&A</h3>
					<a href="/boardQnaWrite" class="genric-btn info circle" style="height:40px;">글쓰기</a>
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
						 <c:forEach var="board_qna_list" items="${qnalist}" >
          					<div class="table-row">
           						<div class="serial">${board_qna_list.b_no}</div>
            					<div class="country"><a href="/qnaDetail?b_no=${board_qna_list.b_no}">${board_qna_list.b_title}</a></div>
            					<div class="visit">${board_qna_list.b_writer}</div>
            					<div class="percentage">${board_qna_list.b_date}</div>
            					<c:if test="${board_qna_list.b_answer eq 1 }">
            						<div class="percentage">
            							<button type="button" onclick="answer_click(this.id)" id="${board_qna_list.b_no }" class="modalBtn genric-btn danger circle" data-toggle="modal" data-target="#checkanswer">
            							답변보기</button>
            						</div>
            					</c:if>
            					<c:if test="${board_qna_list.b_answer eq 0 and sessionId ne 'root' }">
            						<div class="percentage">
            							<input type="text" readonly="readonly" class="modalBtn genric-btn danger circle" value="답변중" />
            							
            						</div>
            					</c:if>
            					<c:if test="${board_qna_list.b_answer eq 0 and sessionId eq 'root' }">
            						<div class="percentage">
            							<button type="button" onclick="modal_click(this.id)" id="${board_qna_list.b_no }" class="modalBtn genric-btn danger circle" data-toggle="modal" data-target="#answer">
            							답변하기</button>
            						</div>
            					</c:if>
            				</div>
            			</c:forEach>
					</div>
				</div>
			</div>
			</div>
		</section>
		
		
		<!-- 답변하기 modal -->
		<div class="modal fade bs-example-modal-lg" id="answer" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
			   <form action="/addAnswer" method="post">
			      <div class="modal-header">
			        <h4 class="modal-title" id="gridSystemModalLabel">답변하기</h4>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			      </div>
			      <div class="modal-body">
			     	
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="submit" class="btn btn-primary">Save changes</button>
			      </div>
		      </form>
		    </div>
		  </div>
		</div>
		
		<!-- 답변보기 modal -->
		<div class="modal fade" id="checkanswer" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
			      <div class="modal-header">
			        <h4 class="modal-title" id="gridSystemModalLabel">답변보기</h4>
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			      </div>
			      <div class="modal-body checkAnswer">
			     	
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
		    </div>
		  </div>
		</div>


    <!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->


<script type="text/javascript">
	
	// qna 답변하기 모달로 불러오기
	function modal_click(modal_id){

		
		var id = modal_id;
		console.log('id: '+id);
	    var data = {"id": id};
		var url = "/answerDetail";
		
		$.ajax({
			type: 'POST',
	        url: url,
	        data : data,
	        dataType: 'json',
			success: function(board){
				console.log("오나");
				console.log('board: '+ board.b_content);
				console.log(board.b_no)
				var htmls = "";
				htmls+='<div class="modal-body" style="display:flex;">';
				htmls+='<input type="hidden" name="answer_no" value="'+board.b_no+'"/>';
				htmls+='<div style="width:400px;height:200px;">'+board.b_content+'</div>';
				htmls+='<div><input type="text" name="answer_content" class="modal-text" style="width:400px;height:200px;"/></div>';
				htmls+='</div>';
				$(".modal-body").replaceWith(htmls);
			},
			error: function(error){
				console.log("eeeeeeeee에러 : " + error);
			}
		});
	}
	
	
	// qna 답변보기 모달로 불러오기
	function answer_click(modal_id){

		
		var id = modal_id;
		console.log('id: '+id);
	    var data = {"id": id};
		var url = "/checkAnswer";
		
		$.ajax({
			type: 'POST',
	        url: url,
	        data : data,
	        dataType: 'json',
			success: function(answer){
				console.log("answer: "+ answer.answer_content);
				console.log("answer_no: "+ answer.answer_no);
				var htmls = "";
				htmls+='<div class="modal-body checkAnswer" >';
				htmls+='<input type="hidden" name="answer_no" value="'+answer.answer_no+'"/>';
				htmls+='<div style="width:400px;height:200px;">'+answer.answer_content+'</div>';
				htmls+='</div>';
				$(".checkAnswer").replaceWith(htmls);
			},
			error: function(error){
				console.log("eeeeeeeee에러 : " + error);
			}
		});
	}

	
</script>
</body>


</html>