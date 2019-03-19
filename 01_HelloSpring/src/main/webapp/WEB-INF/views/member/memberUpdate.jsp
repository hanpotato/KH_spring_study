<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.spring.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<style>
	div#enroll-container {
		width: 400px;
		margin: 0 auto;
		text-align: center;
	}

	div#enroll-container input,
	div#enroll-container select {
		margin-bottom: 10px;
	}
</style>

<jsp:include page="/WEB-INF/views/common/header.jsp">
      <jsp:param value="" name="pageTitle"/>
</jsp:include>
<section>
	<div id="enroll-container">
		<form name="memberEnrollFrm" action="${pageContext.request.contextPath}/member/memberUpdateEnd.do" method="post"
			onsubmit="return validate();">
			<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_" value="${member.userId }" readonly>
			<input type="password" class="form-control" placeholder="비밀번호" name="password" id="password_" required>
			<input type="password" class="form-control" placeholder="비밀번호확인" id="password2" required>
			<input type="text" class="form-control" placeholder="이름" name="userName" id="userName" value="${member.userName }" required>
			<input type="number" class="form-control" placeholder="나이" name="age" id="age" value="${member.age }">
			<input type="email" class="form-control" placeholder="이메일" name="email" id="email" value="${member.email }" required>
			<input type="tel" class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" value="${member.phone }" required>
			<input type="text" class="form-control" placeholder="주소" name="address" id="address" value="${member.address }">
			<select class="form-control" name="gender" required>
				<option value="" disabled>성별</option>
				<%-- 
				<option value="M"
					<c:if test="${member.gender == 'M' }">selected</c:if>
				>남</option>
				<option value="F"
					<c:if test="${member.gender == 'F' }">selected</c:if>
				>여</option>
				 --%>
				<option value="M" ${member.gender eq 'M' ? "selectecd" : "" }>남</option>
				<option value="F" ${member.gender eq 'F' ? "selectecd" : "" }>여</option>
			</select>
			<%-- 
			<div class="form-check-inline form-check">
				취미 :
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"
					<c:forEach items="${member.hobby }" var="hobby"><c:if test="${hobby == '운동' }">checked</c:if></c:forEach>
				>
				<label for="hobby0" class="form-check-label">운동</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"
					<c:forEach items="${member.hobby }" var="hobby"><c:if test="${hobby == '등산' }">checked</c:if></c:forEach>
				>
				<label for="hobby1" class="form-check-label">등산</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"
					<c:forEach items="${member.hobby }" var="hobby"><c:if test="${hobby == '독서' }">checked</c:if></c:forEach>
				>
				<label for="hobby2" class="form-check-label">독서</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"
					<c:forEach items="${member.hobby }" var="hobby"><c:if test="${hobby == '게임' }">checked</c:if></c:forEach>
				>
				<label for="hobby3" class="form-check-label">게임</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"
					<c:forEach items="${member.hobby }" var="hobby"><c:if test="${hobby == '여행' }">checked</c:if></c:forEach>
				>
				<label for="hobby4" class="form-check-label">여행</label>
				&nbsp;
			</div>
			--%>
			
			<%
				Member m = (Member)request.getAttribute("member");
				String[] hobbys = m.getHobby();
				List<String> hobbyList = new ArrayList();
				if(hobbys!=null) {
					hobbyList = Arrays.asList(hobbys);
				}
			%>
			
			<div class="form-check-inline form-check">
				취미 :
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"
					<%=hobbyList != null && hobbyList.contains("운동")?"checked":"" %>
				>
				<label for="hobby0" class="form-check-label">운동</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby1" value="등산"
					<%=hobbyList != null && hobbyList.contains("등산")?"checked":"" %>
				>
				<label for="hobby1" class="form-check-label">등산</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby2" value="독서"
					<%=hobbyList != null && hobbyList.contains("독서")?"checked":"" %>
				>
				<label for="hobby2" class="form-check-label">독서</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"
					<%=hobbyList != null && hobbyList.contains("게임")?"checked":"" %>
				>
				<label for="hobby3" class="form-check-label">게임</label>
				&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby4" value="여행"
					<%=hobbyList != null && hobbyList.contains("여행")?"checked":"" %>
				>
				<label for="hobby4" class="form-check-label">여행</label>
				&nbsp;
			</div>
			
			<br/>
			<!-- <input type="submit" class="btn btn-outline-success" value="수정"> -->
			<input type="button" onclick="fn_update();" class="btn btn-outline-success" value="수정">
			&nbsp;
			<input type="button" onclick="fn_delete();" class="btn btn-outline-success" value="탈퇴" onclick="fn_del();">
		</form>
	</div>
</section>
<script>
	function fn_update() {
		$("[name=memberEnrollFrm]").attr("action","${path}/member/memberUpdateEnd.do");//j쿼리 형식으로 쓰임
		var updateFlag = confirm("정보를 수정하시겠습니까?");
		if(updateFlag) {
			memberEnrollFrm.submit();
		}
	}
	$(function () {
		$("#password2").blur(function () {
			var pw = $("#password_").val();
			var pwck = $("#password2").val();
			if (pw != pwck) {
				alert("패스워드가 일치하지 않습니다.");
				$("#password2").val("");
				$("#password_").focus();
			}
		})
	})
/* 	
	function validate() {
		var updateFlag = confirm("정보를 수정하시겠습니까?");
		if(!updateFlag) {
			return false;
		} else {
			return true;
		}
	}
*/
	function fn_del() {
		var updateFlag = confirm("정보를 삭제하시겠습니까?");
		if(updateFlag) {
			location.href="${path }/member/memberDel.do";
		}
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>