<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
int pageCount = 0; 
void addCount(){
	pageCount++;
}
%>
<%
addCount();
%>
<h1>이 사이트방문은 <%=pageCount %>번째입니다.</h1>
</body>
</html>