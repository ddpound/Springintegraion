<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

</head>
<%@ include file="../default/header.jsp"%>
<script src="${pageContext.request.contextPath }/resources/js/user.js"></script>
<body>
	<div style="height: 700px;">
		<form id="loginForm">
			<input type="text" id="uId" name="uId" placeholder="아이디입력"> 
			<input type="password" id="uPw" name="uPw" placeholder="비밀번호 입력"> 
				<input type="button" onclick="login()" value="로그인">
		</form>
	</div>
</body>
<%@ include file="../default/footer.jsp"%>
</html>