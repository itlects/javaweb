<%@ page contentType="text/html; charset=utf-8"%>
<html>
<head>
<title>Validation</title>
</head>
<script type ="text/javascript">
    function checkForm() { 
        var str = document.frm.name.value; 
        var regExp = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
        if (!regExp.test(str)) {
            alert("이름은 숫자로 시작할 수 없습니다!");
            return;
        } 
    }
</script>
<body>
    <form name = "frm">
        <p> 이름 : <input type = "text" name ="name">
        <input type ="submit" value = "전송" onclick ="checkForm()">
    </form>
</body>
</html>