<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
	src="${pageContext.request.contextPath }/resources/js/daumpost.js"></script>
<script type="text/javascript">
	function reg() {
		var addr1 = $("#addr1").val()
		var addr2 = $("#addr2").val()
		var addr3 = $("#addr3").val()
		var addr = addr1 + "/" + addr2 + "/" + addr3
		$("#addr1").val(addr)
		fo.submit()
	}
</script>
</head>
<%@ include file="../default/header.jsp"%>
<body>
	<div style="height:  700px;">
		<form id="fo" action="join" method="POST">
			<input type="text" name="id" placeholder="아이디입력"><br> <input
				type="password" name="pw" placeholder="비밀번호 입력"><br> <input
				type="text" id="addr1" name="addr" placeholder="우편번호"><br>
			<input type="button" onclick="daumPost()" value="우편주소찾기"> <input
				type="text" id="addr2" placeholder="주소"><br> <input
				type="text" id="addr3" placeholder="상세주소"><br> <input
				type="button" onclick="reg()" value="회원가입"><br>

		</form>
	</div>
</body>
<%@ include file="../default/footer.jsp"%>
</html>