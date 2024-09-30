<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp 스크립트</title>
</head>
<%!
  int count =3;
  
  String makeItLower(String data){
	  return data.toLowerCase();
  }
%>
<body>
<%
for (int i=1;i<=count; i++){
	out.println("JSP태그: " + i + "<br>");
}
%>
 
  <p>카운트 숫자 = <%=count %> </p>
  <% makeItLower("Hello!!!"); %>
  

</body>
</html>