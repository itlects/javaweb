<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form name="fileUploadForm" action="fileUpload.do" method="post" encType="multipart/form-data">
		<p>
			파일1: <input type="file" name="file1" />
		</p>
		<p>
			파일2: <input type="file" name="file2" />
		</p>
		
		<input type="submit" value="Data Send" />
	</form>
</body>
</html>