<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form role="from" method="post">
	<input type="text" name="title" placeholder="Enter Title">
	<br>
	<textarea rows="3" name="content"></textarea>
	<br>
	<input type="text" name="writer">
	<br>
	<input type="text" name="regdate">
	
	<button type="submit">submit</button>
</form>

</form>
</body>
</html>