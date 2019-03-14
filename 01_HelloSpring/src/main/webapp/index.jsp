<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="Hello Spring" name="title"/>
</jsp:include>

<section id="content">
	<img src="${pageContext.request.contextPath }/resources/images/logo-spring.png" id="center-image" alt="스프링로고"/>
</section>

<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>