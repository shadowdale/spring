<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8"/>
	<title>/views/shop/depositform.jsp</title>
</head>
<body>
	<h3>입금 폼입니다.</h3>
	<form action="deposit.do" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id"/><br/>
		<label for="cash">금액</label>
		<input type="text" name="cash" id="cash"/><br/>
		<button type="submit">입금</button>
	</form>
</body>
</html>