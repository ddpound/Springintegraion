<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../default/header.jsp"%>
<body>
<div >
<label >제목 : ${selectboard.title } </label><br>
<label>작성자 : ${selectboard.writeuser }</label><br>
<textarea rows="5" cols="30" >${selectboard.contents }</textarea><br>


</div>

</body>
<%@ include file="../default/footer.jsp"%>
</html>