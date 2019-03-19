<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<jsp:include page="/WEB-INF/views/common/header.jsp">
      <jsp:param value="" name="pageTitle"/>
</jsp:include>
<style>
	div#memo-container{width:60%; margin:0 auto;}
</style>
<section>	
	<div id="memo-container">
		<form action="${pageContext.request.contextPath}/memo/insertMemo.do" class="form-inline">
			<input type="text" class="form-control col-sm-6" name="memo" placeholder="메모" required/>&nbsp;
			<input type="password" class="form-control col-sm-2" name="password" maxlength="4" placeholder="비밀번호" required/>&nbsp;
			<button class="btn btn-outline-success" type="submit" >저장</button>
		</form>
		<br/>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>메모</th>
				<th>날짜</th>
				<th>삭제</th>
			</tr>
			<c:forEach items="${list }" var="memo">
				<tr>
					<td>${memo.MEMONO }</td>
					<td>${memo.MEMO }</td>
					<td>${memo.MEMODATE }</td>
					<td>
						<button class="btn btn-warning">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</section>   
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>