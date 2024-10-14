<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<title>Form Processing</title>
</head>
<body>
    <form action = "process.jsp" method = "POST">
        <p> 독서<input type = "checkbox" name = "reading">
            운동<input type ="checkbox" name ="exercise">
            영화<input type = "checkbox" name ="movie">
        <p> <input type = "submit" value = "전송">
    </form>
</body>
</html>