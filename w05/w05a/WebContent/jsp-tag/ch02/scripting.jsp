<html>
<head>
<title>Scripting Tag</title>
</head>
<%-- 선언문 태그 [메소드] --%>
<%! 
     int count = 0; 
%>

<body>
    Page Count is 
    <%-- 스크립틀릿 태그 --%>
    
<%
        out.println(++count); 
%>
</body>
</html>