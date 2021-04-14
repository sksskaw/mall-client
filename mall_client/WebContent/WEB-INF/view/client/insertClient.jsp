<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insertClient</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="<%=request.getContextPath()%>/InsertClientController" method="post">
		<div> clientMail : 
			<input type="email" name="clientMail" required="required">
		</div>
		
		<div> clientPw : 
			<input type="password" name="clientPw" required="required">
		</div>
		<button type="submit">입력</button>
		<a href="<%=request.getContextPath()%>/IndexController"><button type="button">취소</button></a>
	</form>
</body>
</html>