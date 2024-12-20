<%-- filelink.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%-- java1.8 tomcat9 에서 사용 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- 다운로드할 파일 이름을 가져옴 --%>
<c:set var="file1" value="${param.param1}" />
<c:set var="file2" value="${param.param2}" />
<title>이미지 파일 출력하기</title>
</head>
<body>
	매개변수 1 :
	<c:out value="${file1}" /><br>
	매개변수 2 :
	<c:out value="${file2}" /><br>
	
	<c:if test="${not empty file1 }">
	<%-- 파일 이름으로 contextpath경로에 있는(webapp/files/에 위치한 파일을 표시함 --%>
	<img src="${contextPath}/files/${file1}" width=300 height=300 /><br> 
	</c:if>
	<br>
	<c:if test="${not empty file2 }">
	<%-- 파일 이름으로 서블릿에서 이미지를 다운로드해 표시함 --%>
	<img src="${contextPath}/download.do?fileName=${file2}" width=300 height=300 /><br> 
	</c:if>
	파일 내려받기 :<br>
	<%-- 링크를 클릭하면 파일다운로드함 --%>
	<a href="${contextPath}/download.do?fileName=${file2}"> 
		파일 내려받기 </a><br>
</body>