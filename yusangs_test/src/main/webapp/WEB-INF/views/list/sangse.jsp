<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	</head>
	<body>
		<table style="border: 1px;">
			<tr>
				<td>번호</td>
				<td>${sangse.IDX }</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>${sangse.TITLE }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${sangse.CONTENT }</td>
			</tr>
			<tr>
				<td>작성일자</td>
				<td>${sangse.REGDATE }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>${sangse.STO_FILE }</td>
			</tr>
		</table>
		<%@ include file="../list/comment.jsp" %>
	</body>
	<script type="text/javascript">
		
	</script>
</html>