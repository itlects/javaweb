<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 스크립트</title>
</head>
<body>

<h2>JSP 스크립트 태그</h2>

<%!
int count = 3;

String makeItLower(String data){
	return data.toLowerCase();
}
%>

<% 
for(int i=0;i<count;i++){
	out.println("JSP " + i + " <br>");
}
%>

<%= makeItLower("------------Hello!! -----------") %>

</body>
</html>