<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardView</title>
<script src="${pageContext.request.contextPath }/resources/js/board.js"></script>
<link href="${pageContext.request.contextPath }/resources/css/board.css"
	rel="stylesheet" type="text/css">

</head>
<%@ include file="../default/header.jsp"%>
<body>
	<div class="borderLineBox">
		<div class="selectBoard">
			<label>제목 : ${selectboard.title } </label>&ensp;&ensp;| 게시판 ID : <label
				id="boardId">${selectboard.boardId }</label> <br> <label
				style="margin-top: 12px;">작성자 : ${selectboard.writeuser } </label>&ensp;&ensp;&ensp;
			<c:if test="${sessionId == selectboard.writeuser}">
				<button class="deleteButton" onclick="deleteBoard()">삭제</button>
			</c:if>
			<br>
			<label style="margin-top: 12px; font-weight: bold;">조회수 :  ${selectboard.hit }</label><br><br>
			<div class="boardContents">
			${selectboard.contents }
			</div>
			
			
			<br>

		</div>



	</div>

</body>
<%@ include file="../default/footer.jsp"%>
</html>