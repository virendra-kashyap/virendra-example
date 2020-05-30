package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/setLogin")
public class SetCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String EmailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		if (EmailId.equals("a@gmail.com") && password.equals("pass1234")) {
			out.println("Welcome " + EmailId);
			Cookie ck = new Cookie("EmailId", EmailId);
			ck.setMaxAge(60);
			response.addCookie(ck);
		} else {
			out.println("EmailId and Password Not Matched");
		}
	}
}
