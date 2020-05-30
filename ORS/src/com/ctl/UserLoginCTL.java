package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import com.dto.MarksheetDTO;
import com.dto.UserDTO;
import com.service.UserService;

@WebServlet("/login")
public class UserLoginCTL extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession(true);
		if ("LogOut".equalsIgnoreCase(operation)) {
			session.invalidate();
			response.sendRedirect("login");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		UserService service = new UserService();
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(60 * 5);
		if ("Log In".equalsIgnoreCase(operation)) {
			String emailId = request.getParameter("emailId");
			String password = request.getParameter("password");
			UserDTO dto = service.authenticate(emailId, password);
			if (dto != null) {
				session.setAttribute("userDTO", dto);
				response.sendRedirect("marksheet.do");
			} else {
				request.setAttribute("error", "User Not found");
				RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
				rd.forward(request, response);
			}
		} else if ("LogOut".equalsIgnoreCase(operation)) {
			session.invalidate();
			response.sendRedirect("login");

		} else if ("Reset".equalsIgnoreCase(operation)) {
			UserDTO dto = service.getByEmailId(request.getParameter("emailId"));
			if (dto != null) {
				dto.setPassword(request.getParameter("newPassword"));
				service.update(dto);
				response.sendRedirect("userLogin.jsp");
			} else {
				request.setAttribute("forgotError", "Emailid is not found");
				RequestDispatcher rd = request.getRequestDispatcher("forgotPassword.jsp");
				rd.forward(request, response);
			}
		}

		else {
			RequestDispatcher rd = request.getRequestDispatcher("userLogin.jsp");
			rd.forward(request, response);
		}

	}

}
