<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

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
	<jsp:param value="회원등록" name="pageTitle" />
</jsp:include>

<section>
	<div id="enroll-container">
		<form name="memberEnrollFrm" action="${pageContext.request.contextPath}/member/memberEnrollEnd.do" method="post"
			onsubmit="return validate();">
			<input type="text" class="form-control" placeholder="아이디 (4글자이상)" name="userId" id="userId_" required>
			<input type="password" class="form-control" placeholder="비밀번호" name="password" id="password_" required>
			<input type="password" class="form-control" placeholder="비밀번호확인" id="password2" required>
			<input type="text" class="form-control" placeholder="이름" name="userName" id="userName" required> <input
				type="number" class="form-control" placeholder="나이" name="age" id="age"> <input type="email"
				class="form-control" placeholder="이메일" name="email" id="email" required> <input type="tel"
				class="form-control" placeholder="전화번호 (예:01012345678)" name="phone" id="phone" maxlength="11" required>
			<input type="text" class="form-control" placeholder="주소" name="address" id="address">
			<select class="form-control" name="gender" required>
				<option value="" disabled selected>성별</option>
				<option value="M">남</option>
				<option value="F">여</option>
			</select>
			<div class="form-check-inline form-check">
				취미 : &nbsp; <input type="checkbox" class="form-check-input" name="hobby" id="hobby0" value="운동"><label
					for="hobby0" class="form-check-label">운동</label>&nbsp; <input type="checkbox"
					class="form-check-input" name="hobby" id="hobby1" value="등산"><label for="hobby1"
					class="form-check-label">등산</label>&nbsp; <input type="checkbox" class="form-check-input"
					name="hobby" id="hobby2" value="독서"><label for="hobby2" class="form-check-label">독서</label>&nbsp;
				<input type="checkbox" class="form-check-input" name="hobby" id="hobby3" value="게임"><label for="hobby3"
					class="form-check-label">게임</label>&nbsp; <input type="checkbox" class="form-check-input"
					name="hobby" id="hobby4" value="여행"><label for="hobby4" class="form-check-label">여행</label>&nbsp;
			</div>
			<br /> <input type="submit" class="btn btn-outline-success" value="가입">&nbsp; <input type="reset"
				class="btn btn-outline-success" value="취소">
		</form>
	</div>
</section>

<script>
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

	function validate() {
		var id = $("#userId)").val().trim();
		if (id.length < 4) {
			alert("아이디를 4글자 이상 작성하세요.");
			return false;
		}
	}
</script>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>