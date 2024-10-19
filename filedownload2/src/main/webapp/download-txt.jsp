<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
  // Define filename and filepath
  String filename = "sample.txt"; 
  String filepath = "c:\\upload\\"; 

  // Set response to download file
  response.setContentType("APPLICATION/OCTET-STREAM"); 
  response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\""); 

  // Input stream for file reading
  java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath + filename);

  // Read file content and stream it to the response output stream
  
  int i; 
  while ((i=fileInputStream.read()) != -1) {
    out.write(i); 
  } 

  // Close the FileInputStream to release resources
  fileInputStream.close(); 
%> 