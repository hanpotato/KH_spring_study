<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Domo" name="title" />
</jsp:include>

<section>
	<div id="demo-container">
		<!-- https://getbootstrap.com/docs/4.1/components/forms/#readonly-plain-text -->
		<form id="devFrm">
			<div class="form-group row">
				<label for="devName" class="col-sm-2 col-form-label">이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="devName" name="devName">
				</div>
			</div>
			<div class="form-group row">
				<label for="devAge" class="col-sm-2 col-form-label">나이</label>
				<div class="col-sm-10">
					<input type="number" class="form-control" id="devAge" name="devAge">
				</div>
			</div>
			<div class="form-group row">
				<label for="devEmail" class="col-sm-2 col-form-label">이메일</label>
				<div class="col-sm-10">
					<input type="email" class="form-control" id="devEmail" name="devEmail">
				</div>
			</div>
			<!-- https://getbootstrap.com/docs/4.1/components/forms/#inline -->
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">성별</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="devGender" id="devGender0" value="M"> <label
							class="form-check-label" for="devGender0">남</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="radio" name="devGender" id="devGender1" value="F">
						<label class="form-check-label" for="devGender1">여</label>
					</div>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 col-form-label">개발언어</label>
				<div class="col-sm-10">
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" id="devLang0" value="Java">
						<label class="form-check-label" for="devLang0">Java</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" id="devLang1" value="C"> <label
							class="form-check-label" for="devLang1">C</label>
					</div>
					<div class="form-check form-check-inline">
						<input class="form-check-input" type="checkbox" name="devLang" id="devLang2" value="Javascript">
						<label class="form-check-label" for="devLang2">Javascript</label>
					</div>
				</div>
			</div>
			<div class="list-group">
				<button type="button" onclick="domo1();" class="list-group-item list-group-item-action">
					파라미터 핸들링-HttpServletRequest
				</button>
				<button type="button" onclick="domo2();" class="list-group-item list-group-item-action">
					파라미터 핸들링-@RequestParam
				</button>
				<button type="button" onclick="domo3();" class="list-group-item list-group-item-action">
					파라미터 핸들링-@VO이용
				</button>
				<button type="button" onclick="domo4();" class="list-group-item list-group-item-action">
					파라미터 핸들링-insert 데이타!
				</button>
				<button type="button" onclick="domo5();" class="list-group-item list-group-item-action">
					devNo1 값
				</button>
			</div>
		</form>
	</div>
	<script>
		function domo1() {
			$("#devFrm").attr("action", "${pageContext.request.contextPath}/domo/domo1.do");
			$("#devFrm").attr("method", "post");
			$("#devFrm").submit();
		}
		function domo2() {
			$("#devFrm").attr("action", "${pageContext.request.contextPath}/domo/domo2.do");
			$("#devFrm").attr("method", "post");
			$("#devFrm").submit();
		}
		function domo3() {
			$("#devFrm").attr("action", "${pageContext.request.contextPath}/domo/domo3.do");
			$("#devFrm").attr("method", "post");
			$("#devFrm").submit();
		}
		function domo4() {
			$("#devFrm").attr("action", "${pageContext.request.contextPath}/domo/insert.do");
			$("#devFrm").attr("method", "post");
			$("#devFrm").submit();
		}
		function domo5() {
			console.log("function 진입");
			$("#devFrm").attr("action", "${pageContext.request.contextPath}/domo/domo5.do");
			$("#devFrm").attr("method", "post");
			$("#devFrm").submit();
		}
	</script>
</section>

<style>
	div#demo-container {
		width: 40%;
		padding: 15px;
		margin: 0 auto;
		border: 1px solid lightgray;
		border-radius: 10px;
	}
</style>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>