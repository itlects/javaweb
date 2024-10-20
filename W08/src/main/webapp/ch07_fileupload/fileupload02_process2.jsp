<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%
	MultipartRequest multi = new MultipartRequest(request, 
			"C:\\upload", 5 * 1024 * 1024, "utf-8",
			new DefaultFileRenamePolicy());

	Enumeration params = multi.getParameterNames();

	while (params.hasMoreElements()) {
		String name = (String) params.nextElement();
		String value = multi.getParameter(name);
		out.println(name + " = " + value + "<br>");
	}
	out.println("-----------------------------------<br>");


	String name1 = multi.getParameter("name1");
	String subject1 = multi.getParameter("subject1");

	String name2 = multi.getParameter("name2");
	String subject2 = multi.getParameter("subject2");

	String name3 = multi.getParameter("name3");
	String subject3 = multi.getParameter("subject3");

	Enumeration files = multi.getFileNames();

	String file1 = (String) files.nextElement();
	String filename1 = multi.getFilesystemName(file1);
	out.println("작성자1 : " + name1 + ", ");
	out.println("제목1 : " + subject1 + ", ");
	out.println("업로드 된 파일명1 : " + filename1 + "<br>");

	String file2 = (String) files.nextElement();
	String filename2 = multi.getFilesystemName(file2);
	out.println("작성자2 : " + name2 + ", ");
	out.println("제목2 : " + subject2 + ", ");
	out.println("업로드 된 파일명2 : " + filename2 + "<br>");

	String file3 = (String) files.nextElement();
	String filename3 = multi.getFilesystemName(file2);
	out.println("작성자3 : " + name3 + ", ");
	out.println("제목3 : " + subject3 + ", ");
	out.println("업로드 된 파일명3 : " + filename3 + "<br>");
%>

	<table border="1">
		<tr>
			<th width="100">이름</th>
			<th width="100">제목</th>
			<th width="100">파일</th>
		</tr>
		<%
			out.print("<tr><td>" + name1 + " </td>");
			out.print("<td>" + subject1 + " </td>");
			out.println("<td> " + filename1 + "</td></tr>\n");

			out.print("<tr><td>" + name2 + " </td>");
			out.print("<td>" + subject2 + " </td>");
			out.println("<td> " + filename2 + "</td></tr>\n");

			out.print("<tr><td>" + name3 + " </td>");
			out.print("<td>" + subject3 + " </td>");
			out.println("<td> " + filename3 + "</td></tr>\n");				
		%>
	</table>