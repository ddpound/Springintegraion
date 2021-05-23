<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="${pageContext.request.contextPath }/resources/css/header.css"
	rel="stylesheet" type="text/css">
</head>

<body>

	<div class="headerCss1">
		<div class="headerCss2">
		<label class="Ylabel"><a href="${pageContext.request.contextPath }/"> Y</a> </label>
		</div>
		<div class="headerCss3">
		<ul>
		<c:choose>
		<c:when test="${sessionId == null }">
		<li><label><a href="${pageContext.request.contextPath }/loginView"> 로그인</a> </label></li>
		<li><label><a href="${pageContext.request.contextPath }/joinView"> 회원가입</a> </label></li>
		
		</c:when>
		<c:otherwise>
		<li><label><a href="${pageContext.request.contextPath }/writeBoard"> 글쓰기</a> </label></li>
		<li><label><a href="${pageContext.request.contextPath }/logout"> 로그아웃</a> </label></li>
		<li><label>  로그인중 : ${sessionId }</label></li>
		</c:otherwise>
		</c:choose>
		</ul>
		</div>
	</div>
	


</body>
</html>