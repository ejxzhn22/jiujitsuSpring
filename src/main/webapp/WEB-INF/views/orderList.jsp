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
                        <a href="single-blog.html">orderList</a>
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
					<h3 class="mb-30 title_color">주문내역</h3>
				</div>
				<div class="progress-table-wrap">
					<div class="progress-table">
						<div class="table-head">
							<div class="serial">주문번호</div>
							<div class="country">주문날짜</div>
							<div class="visit"></div>
							<div class="percentage"></div>
						</div>
						 <c:forEach var="order" items="${list}" >
          					<div class="table-row">
           						<div class="serial">${order.order_id}</div>
            					<div class="country">${order.order_date}</a></div>
            					<div class="visit">
           							<a href="/confirmation?order_id=${order.order_id }"   class="genric-btn danger-border circle" >
           								상세보기
           							</a>
            					</div>
            					<div class="percentage">
            					</div>
            				</div>
            			</c:forEach>
					</div>
				</div>
			</div>
			</div>
		</section>
		
		<!-- 수정 modal -->
		<div class="modal fade bs-example-modal-lg" id="updateItem" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg">
		    <div class="modal-content">
			   <form action="/updateItem" method="post" enctype="multipart/form-data">
			      <div class="modal-header">
			        <h4 class="modal-title" id="gridSystemModalLabel">상품수정</h4>
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
		

    <!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->

</body>
<script type="text/javascript">
	
	// 수정하기
	function modal_click(modal_id){

		
		var id = modal_id;
		console.log('id: '+id);
	    var data = {"id": id};
		var url = "/modalDetail";
		
		$.ajax({
			type: 'POST',
	        url: url,
	        data : data,
	        dataType: 'json',
			success: function(item){
				console.log("오나");
				console.log('item: '+ item.item_id);
				var htmls = "";
				htmls+='<div class="modal-body" style="">';
				htmls+='<div><label></label><input type="hidden" name="item_id" value="'+item.item_id+'"/></div>';
				htmls+='<div><label style="margin:10px;">상품이름</label><input type="text" name="item_name" value="'+item.item_name+'"/></div>';
				htmls+='<div><label style="margin:10px;">상품 가격</label><input type="text" name="item_price" value="'+item.item_price+'"/></div>';
				htmls+='<div><label style="margin:10px;">상품 사이즈</label><input type="text" name="item_size" value="'+item.item_size+'"/></div>'
				htmls+='<div><label style="margin:10px;">상품 수량</label><input type="text" name="item_stockQuantity" value="'+item.item_stockQuantity+'"/></div>'
				htmls+='<div><input type="file" name="ufile"/></div>';
				htmls+='<div><label style="margin:10px;">상품 설명</label><input type="text" name="item_content" class="modal-text" style="width:400px;height:100px;" value="'+item.item_content+'" /></div></div>';
				$(".modal-body").replaceWith(htmls);
			},
			error: function(error){
				console.log("eeeeeeeee에러 : " + error);
			}
		});
	}

</script>
</html>