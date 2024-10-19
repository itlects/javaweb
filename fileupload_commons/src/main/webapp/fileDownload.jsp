<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<img src="${ pageContext.request.contextPath }/fileDownload.do?fileName=google2.png" width="500" height="500" />
	<br>
	<a href="${ pageContext.request.contextPath }/fileDownload.do?fileName=google2.png"> file download</a>
</body>
</html>