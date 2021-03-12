<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/js/addressapi.js"></script>
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
		<form action="/order" method="POST">
        <div class="section-top-border">
        		<div style="display:flex; justify-content: space-around;">
					<h3 class="mb-30 title_color">주문하기</h3>
				</div>
				<div class="progress-table-wrap">
					<div class="progress-table">
						<div class="table-head">
							<div class="percentage">상품이름</div>
							<div class="country">상품가격</div>
							<div class="visit">수량</div>
							<div class="percentage"></div>
						</div>
						<c:set var = "sum" value = "0" />
						 <c:forEach var="item" items="${list}" varStatus="status" >
          					<div class="table-row">
           						<input type="hidden" name="list[${status.index}].item_id" value="${item.cartitem_item_id }"/>
           						<input type="hidden" name="list[${status.index}].item_name" value="${nameList[status.index]}"/>
           						<div class="percentage">${nameList[status.index]}</div>
            					<div class="country">${item.cartitem_price}</a></div>
            					<input type="hidden" name="list[${status.index}].order_price" value="${item.cartitem_price }"/>
            					<div class="visit">${item.cartitem_count}</div>
            					<input type="hidden" name="list[${status.index}].order_count" value="${item.cartitem_count }"/>
            					<div class="percentage">
            						&#8361; 
            						<c:set var="total" value=" ${item.cartitem_price * item.cartitem_count}"/>
            						<c:out   value=" ${total}"/>
            					</div>
            				</div>
						<c:set var="sum" value="${sum + item.cartitem_price * item.cartitem_count }" ></c:set>
            			</c:forEach>
						<div class="table-row">
							<div class="visit"></div>
							<div class="country"></div>
							<div class="visit"></div>
							<div class="percentage" style="font-size:25px;">
								TOTAL:&nbsp;&nbsp;  &#8361; <c:out value="${sum }"></c:out>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="section-top-border">
				<div class="form-group">                   
					<input class="form-control" style="width: 40%; display: inline;" placeholder="우편번호" name="addr1" id="addr1" type="text" readonly="readonly" >
				    <button type="button" class="btn btn-default" onclick="execPostCode();"><i class="fa fa-search"></i> 우편번호 찾기</button>                               
				</div>
				<div class="form-group">
				    <input class="form-control" style="top: 5px;" placeholder="도로명 주소" name="addr2" id="addr2" type="text" readonly="readonly" />
				</div>
				<div class="form-group">
				    <input class="form-control" placeholder="상세주소" name="addr3" id="addr3" type="text" required="required" />
				</div>
			</div>
			<div class="section-top-border">
				<div style="display:flex; justify-content: space-around;">
					<button type="submit" class="genric-btn danger" >주문하기</button>
				</div>
			</div>
		</form>
			
		</div>
		</section>
	<!-- ============================================================================= -->						
	<!--================ start footer Area  =================-->
	<%@ include file="include/footer.jsp" %>
	<!--================ End footer Area  =================-->
<script type="text/javascript">
function execPostCode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=addr1]").val(data.zonecode);
           $("[name=addr2]").val(fullRoadAddr);
           
           /* document.getElementById('signUpUserPostNo').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('signUpUserCompanyAddress').value = fullRoadAddr;
           document.getElementById('signUpUserCompanyAddressDetail').value = data.jibunAddress; */
       
       }
    }).open();
}

</script>
</body>
</html>