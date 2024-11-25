<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>JSTL</title>
</head>
<body>
	<h2>회원정보 수정하기</h2>
	<form method="post" action="sql03_process.jsp">
		<p>아이디 : <input type="text" name="id">
		<p>비밀번호 : <input type="password" name="passwd">
		<p>이름 : <input type="text" name="name">
		<p><input type="submit" value="변경하기">
	</form>
</body>
</html>