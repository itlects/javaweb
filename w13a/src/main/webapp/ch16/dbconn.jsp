<%@ page import="java.sql.*"%>
<%
	Connection conn = null;

	String url = "jdbc:mysql://localhost:3306/JSPBookDB";
	String user = "dev";
	String password = "pass";

	Class.forName("com.mysql.cj.jdbc.Driver");
	conn = DriverManager.getConnection(url, user, password);
%>