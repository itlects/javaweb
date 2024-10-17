<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	table{
		border: 2px solid;
		border-collapse: collapse;
	}
	th, td{
		border: 1px solid;
		padding: 10px 5px;
	}
</style>
</head>
<body>
<form method="post" action="filesender_proc.jsp" enctype="multipart/form-data">  //위의 주의사항의 내용들을 반드시 포함하여 만든다. 
		<table>
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>제목</td>
				<td><input type="text" name="subject" id="subject"
					placeholder="제목 입력"></td>
			</tr>
			<tr>
				<td style="width: 80px; height: 30px;" align="center"><font
					color='red'>*</font>내용</td>
				<td style=""word_wrap:break-word;  word-break:break-all;><textarea
						name="content" id="content" rows="12" cols="52"
						placeholder="내용을 입력"></textarea></td>
			</tr>
			<tr>
			<td colspan="2"><input type="file" name="upload1" size="50"></td>
			</tr>
			<tr>
			<td colspan="2" align="center" ><input type="submit" value="파일업로드"></td>
			</tr>
		</table>
	</form>
</body>
</html>