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
				<td>제목</td>
				<td>내용</td>
				<td>작성일자</td>
			</tr>
			<c:forEach items="${list }" var="list">	
				<tr>
					<td>${list.IDX }</td>
					<td><a href="#" onclick="sangse(${list.IDX });">${list.TITLE }</a></td>
					<td>${list.CONTENT }</td>
					<td>${list.REGDATE }</td>
				</tr>
			</c:forEach>
		</table>	
		<input type="button" onclick="writeForm();" value="글쓰기 페이지"/>
	</body>
	<script type="text/javascript">
		function writeForm(){
			location.href="/writeForm.do";
		}

		function sangse(idx){
			location.href="/sangse.do?idx="+idx;
		}

		var msg = "${msg}";
		console.log("메시지 확인 ::: "+msg);
		if(msg != ""){
			alert(msg);
		}
		
	</script>
</html>