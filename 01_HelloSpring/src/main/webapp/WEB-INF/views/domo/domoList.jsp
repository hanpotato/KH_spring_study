<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Dev 목록" name="pageTitle"/>
</jsp:include>
<table class="table">
	<tr>
		<th scope="col">번호</th>
		<th scope="col">이름</th>
		<th scope="col">나이</th>
		<th scope="col">이메일</th>
		<th scope="col">성별</th>
		<th scope="col">개발가능언어</th>
		<th scope="col">수정</th>
	</tr>
	<c:forEach items="${list }" var="d" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${d.devName }</td>
			<td>${d.devAge }</td>
			<td>${d.devEmail }</td>
			<td>${d.devGender=="M"?"남":"여" }</td>
			<td>
				<c:forEach items="${d.devLang }" var="lang" varStatus="vs">
					${vs.index!=0?",":"" }${lang }
				</c:forEach>
			</td>
			<td>
				<button type="button" class="btn btn-out-line-light" onclick="fn_domoUpdate(${d.devNo });">수정</button>
				<button type="button" class="btn btn-out-line-light" onclick="fn_domoDel(${d.devNo });">삭제</button>
			</td>
		</tr>
	</c:forEach>
</table>
<script>
	function fn_domoUpdate(index) {
		location.href="${path }/domo/domoUpdate.do?devNo="+index;
	}
	function fn_domoDel(index) {
		var delFlag = confirm("정말로 삭제 하시겠습니까?");
		if(delFlag) {
			location.href="${path }/domo/domoDel.do?devNo="+index;
		}
	}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>