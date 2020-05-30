package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/GetCookie")
public class GetCookie extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cArray = request.getCookies();
		PrintWriter out = response.getWriter();
		out.println("<h1>Get Cookie</h1>");
		for (Cookie c : cArray) {
			String emailId = c.getName();
			String password = c.getValue();
			out.println(emailId + "=" + password);
			out.println("<br>");
		}
	}

}
