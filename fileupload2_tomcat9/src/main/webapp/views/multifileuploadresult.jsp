<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
 <title>Insert title here</title>
 <link rel="stylesheet" href="css/style.css">
 <style type="text/css">
	.item{
		margine-bottom: 5px;
	}
</style>
</head>
<body>
	<h1>다중파일업로드 결과</h1>
	
	<c:forEach var="i" begin="0" end="${fileList.size()-1}">
		<div>다운로드: <a href="/file/download.do?filename=${fileList[i] }&orgfilename=${orgList[i]}</a></div>"></a></div>
	</c:forEach>	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>

	</script>
</body>
</html>