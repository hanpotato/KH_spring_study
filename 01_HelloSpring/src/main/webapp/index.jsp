<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Hello Spring" name="title"/>
</jsp:include>

<section id="content">
	<img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" id="center-image" alt="스프링로고"/>
</section>
<button onclick="ajaxText()">testAjax</button>
<input type="text" id="userId"/>
<button onclick="ajaxText2()">vo객체 받기</button>
<div id="result"></div>
<script>
	function ajaxText() {
		$.ajax({
			url:"${pageContext.request.contextPath}/ajaxTest.do",
			dataType:"json",
			success:function(data) {
				
				var table = $("<table>");
				table.append("<tr><th>boardNo</th><th>TITLE</th><th>WRITER</th><th>CONTENT</th><th>DATE</th><th>READCOUNT</th></tr>");
				for(var i=0;i<data.length;i++) {
					var tr=$("<tr>");
					for(var key in data[i]) {
						var td=$("<td>");
						td.append(data[i][key]);
						tr.append(td);
					}
					table.append(tr);
				}
				$("#result").html(table);
			}
		})
	}
	
	function ajaxText2() {
		var userId = $("#userId").val().trim();
		if(userId.length<=0) {
			alert("id를 입력하세요!")
			return;
		}
		$.ajax({
			url:"${pageContext.request.contextPath}/ajaxTest2.do",
			dataType:"json",
			data:{"userId":userId},
			success:function(data) {
				console.log(data);
			}
		})
		
	}
</script>


<jsp:include page="/WEB-INF/views/common/footer.jsp"/>