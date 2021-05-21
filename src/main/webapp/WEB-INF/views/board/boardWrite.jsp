<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardWrite</title>
<script src="${pageContext.request.contextPath }/resources/js/board.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<%@ include file="../default/header.jsp"%>
<body>
	글쓰기.jsp
	<br>
	<form class="writeboardform">
		<div class="writeboard">
			<label>제목: </label> <input type="text" id="title" name="title"><br><br>
			<label>작성자  : <input type="text" id="writeuser" name="writeuser" readonly="readonly" value="${sessionId }"> </label><br><br> 
			<label>내용</label><br>
			<textarea id="contents" name="contents" rows="5" cols="30"></textarea><br>
			<button onclick="writeBoard()">글쓰기</button>
		</div>
	</form>

</body>
<%@ include file="../default/footer.jsp"%>
</html>