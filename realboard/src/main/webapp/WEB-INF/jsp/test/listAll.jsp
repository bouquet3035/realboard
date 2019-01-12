<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-2.2.4.js" integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert("123");
	var result = "${msg}";
	console.log("result= ==> " + result);
	if(result == "success") {
		alert("12");
	}
</script>
</head>
<body>
<h3>listAllpage</h3>
<table>
	<tr>
		<th style = "width : 10px">BNO</th>
		<th>Title</th>
		<th>Writter</th>
		<th>regdate</th>
		<th>ViewCnt</th>
	</tr>
	<tr>
	<c:forEach items="${list}" var="boardVO">
		<th>${boardVO.bno}</th>
		<th><a href="/board/read?bno=${boardVO.bno}">${boardVO.title}</th>
		<th>${boardVO.writer}</th>
		<th>${boardVO.regdate}</th>
		<th>${boardVO.viewcnt}</th>
	</tr>
	</c:forEach>
</table>
</body>
</html>