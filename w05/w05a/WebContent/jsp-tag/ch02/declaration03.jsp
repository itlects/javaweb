<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
	<%!String makeItLower(String data) { //- 입력파라미터변수....data
		return data.toLowerCase(); //- 소문자변경해서 리턴.....함수
	}%>
	<%--
	hello 출력합니다.
	 --%>
	<%
		out.println(makeItLower("Hello World1")); //- 소문자 변환해서 출력
		out.println(makeItLower("Hello World2")); //- 소문자 변환해서 출력
		out.println(makeItLower("Hello World3")); //- 소문자 변환해서 출력
		out.println(makeItLower("Hello World4")); //- 소문자 변환해서 출력
	%>
	
<!-- 	<h1>hello1!!</h1> -->
	<h1>hello2!!</h1>
	<h1>hello3!!</h1>
	<h1>hello4!!</h1>
</body>
</html>