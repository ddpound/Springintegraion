<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈</title>
<link href="${pageContext.request.contextPath }/resources/css/index.css"
	rel="stylesheet" type="text/css">
</head>
<%@ include file="default/header.jsp"%>
<body>
	<div class="leftIndex">
		<ul>
			<c:if test="${sessionId != null }">
				<li><label><a href="boardWrite"> 글쓰기</a> </label></li>
			</c:if>
		</ul>
	</div>
	<div class="boardCss">
		<c:forEach var="boarddto" items="${boardList }">
			<div class="mini_board">
				<a href="showboard?boardid=${boarddto.boardId }">${boarddto.title }</a><br>
				<label style="float: right; margin-right: 8px;">작성자 : ${boarddto.writeuser }</label>
				<div class="minibar"></div>
			</div>
		</c:forEach>
		<div class="listnum">
			<ul>
				<c:forEach var="boardlistnum" items="${allPagingCount }">
					<li><a href="boardPage?pageNum=${boardlistnum }"><label
							style="color: black;">${boardlistnum}</label></a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
<%@ include file="default/footer.jsp"%>
</html>