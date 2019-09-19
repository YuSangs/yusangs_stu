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
		<form id="writeForm" action="/write.do" method="post" enctype="multipart/form-data">
			<table style="border: 1px;">
				<tr>
					<td>제목</td>
					<td><input type="text" name="title"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" name="content"/></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td><input type="file" name="file1"/></td>
				</tr>
			</table>
			<input type="submit" value="글쓰기"/>	
		</form>
	</body>
	<script type="text/javascript">
// 		function write(){
// 			$("#writeForm").submit();
// 		}
		
// 		$("#sangse").click(function(){
// 			location.href="/write.do";
// 		});
	</script>
</html>