<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>

<body>
<%
	String uploadPath = "D:/works/git/javaweb/W08/src/main/webapp/files";
	int maxFileSize = 4*1024*1024; //4MB
	String encType = "utf-8";
	
	MultipartRequest multi = new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
	out.println("전송완료!");
%>
</body>
</html>