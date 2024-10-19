<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
  String filename = "sample.txt"; 
  String filepath = "c:\\upload\\"; 

  response.setContentType("APPLICATION/OCTET-STREAM"); 
  response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\""); 

  java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath + filename);

  int i; 
  while ((i=fileInputStream.read()) != -1) {
    out.write(i); 
  } 

  fileInputStream.close(); 
%> 