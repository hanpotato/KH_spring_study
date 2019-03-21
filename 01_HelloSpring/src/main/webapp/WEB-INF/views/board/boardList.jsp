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
	input#btn-add {
		float: right;
		margin:0 0 15px;
	}
</style>
<section>
    <section id="board-container" class="container">
    	<input type="button" value="글쓰기" id="btn-add" class="btn btn-outline-success" onclick="fn_boardForm();"/>
    	<script>
    		function fn_boardForm() {
    			location.href="${path}/board/boardForm";
    		}
    	</script>
        <p>총 ${totalList }건의 게시물이 있습니다.</p>
        
        <table id="tbl-board" class="table table-striped table-hover">
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
                <th>첨부파일</th>
                <th>조회수</th>
            </tr>
 		<c:forEach items="${list }" var="b">
            <tr>
                <td>${b.boardNo }</td>
                <td>${b.boardTitle }</td>
                <td>${b.boardWriter }</td>
                <td>${list.boardDate }</td>
                <td b="center">
                    <c:if test="${b.fileCount>0}">
                        <img alt="첨부파일" src="*데이터 file.png*"
                         width=16px>
                    </c:if>
                </td>
                <td>${b.readCount }</td>
            </tr>
        </c:forEach>
        </table> 
        <div class="pagecontainer">
        	${pageBar }
        </div>
    </section>
</section>   
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>