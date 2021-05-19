<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<li><label><a href="boardWrite"> 글쓰기</a> </label></li>
		</ul>
	</div>
	
	<div class="boardCss">
		<div class="mini_board">
		
		
		
			<a href="">게싯글 제목</a>
			<div class="minibar">
			</div>
		</div>
		
	</div>


</body>
<%@ include file="default/footer.jsp"%>
</html>