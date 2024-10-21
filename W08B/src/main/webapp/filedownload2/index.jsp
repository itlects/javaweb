<%-- first.jsp --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 다운로드 요청하기</title>
</head>
<body>
<h2>image download link를 클릭하세요</h2>
	<form method="post" action="filelink.jsp">
    	<%-- 다운로드할 파일 이름을 매개변수로 전달함 --%>
		<input type="hidden" name="param1" value="kpop2.jpg" /><br>
		<input type="hidden" name="param2" value="kpop3.jpg" /><br>
		<input type="submit" value="이미지 다운로드 링크">
	</form>
</body>
</html>