package ch18.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginController() {
		super();		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("id");
		String password = request.getParameter("passwd");
		PrintWriter out = response.getWriter();

		String htmlResponse = "<html>";
		htmlResponse += "<h3> ���̵� : " + username + "<br/>";
		htmlResponse += "��й�ȣ : " + password + "</h3>";
		htmlResponse += "</html>";

		out.println(htmlResponse);

	}
}
