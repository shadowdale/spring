<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8"/>
	<title></title>
</head>
<body>
	<h3>로그인 페이지 입니다.</h3>
	<form action="signin.do?uri=${param.uri }" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id"/>
		<label for="pwd">비밀번호</label>
		<input type="text" name="pwd" id="pwd"/>
		<button type="submit">로그인</button>
	</form>
</body>
</html>