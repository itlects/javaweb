<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
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
	<h1>다중파일업로드</h1>
	<form method="POST" action="/multifileuploadresult.do" 
		enctype="multipart/form-data">
		<div>
		  <div>이름: </div>
		  <div><input type="text" name="uname"></div>
		</div>
		<div id="files">
			<div>파일: </div>
			<div class="item"><input type="file" name="attach"></div>
			<div id="list"></div>
			<div><input type="button" value="+" id="add"></div>
		</div>
		<div><input type="submit" value="업로드"></div>	
	</form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
		$('#add').click(()=>{
			$('#list').append(
				`
				<div class="item">
					<input type="file" name="attach">
					<input type="button" value="X" onclick="$(this).parent().remove()"><br>
				</div>
				`		
			)
		});
	</script>
</body>
</html>