<%@page contentType="text/html; charset=utf-8"%>
<%@page import="org.apache.commons.fileupload.*"%>
<%@page import="java.io.*"%>
<%@page import="java.util.*"%>
<html>
<head>
<title>File Upload</title>
</head>
<body>
<%
	String path = "C:\\upload";

	DiskFileUpload upload = new DiskFileUpload();
	//JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload();
		
	upload.setSizeMax(1000000);
	upload.setSizeThreshold(4096);
	upload.setRepositoryPath(path);

	List items = upload.parseRequest(request);
//https://oingdaddy.tistory.com/326	
// 	List<FileItem> items = new ArrayList<FileItem>(); 
// 	Iterator it = request.getFileNames();
// 	while(it.hasNext()) {    
// 		List<MultipartFile> list = request.getFiles(it.next().toString());    
// 		for(int i = 0 ; i < list.size() ; i++) {        
// 			CommonsMultipartFile cmpFile = (CommonsMultipartFile)list.get(i);        
// 			items.add(cmpFile.getFileItem());    
// 		}
// 	}

	
	Iterator params = items.iterator();

	while (params.hasNext()) {
		FileItem item = (FileItem) params.next();

		if (item.isFormField()) {
			String name = item.getFieldName();
			String value = item.getString("utf-8");
			out.println(name + "=" + value + "<br>");
		} else {
			String fileFieldName  = item.getFieldName();				
			String fileName = item.getName();
			String contentType = item.getContentType();

			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
			long fileSize = item.getSize();

			File file = new File(path + "/" + fileName);
			item.write(file);

			out.println("-----------------------------------<br>");
			out.println("요청 파라미터 이름 : " + fileFieldName  + "<br>");
			out.println("저장 파일 이름 : " + fileName + "<br>");
			out.println("파일 콘텐츠 유형 : " + contentType + "<br>");
			out.println("파일 크기 : " + fileSize);
		}
	}
%>
</body>
</html>