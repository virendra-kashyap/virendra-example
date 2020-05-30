package com.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.AccountDTO;
import com.service.AccountService;

@WebServlet("/login")
public class AccountLoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession(true);
		if ("Logout".equalsIgnoreCase(operation)) {
			session.invalidate();
			response.sendRedirect("login");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession(true);
		AccountService service = new AccountService();
		String emailid = request.getParameter("emailid");
		String password = request.getParameter("password");
		if ("login".equalsIgnoreCase(operation)) {
			AccountDTO dto = service.authenticate(emailid, password);
			if (dto != null) {
				session.setAttribute("myaccount", dto);
				response.sendRedirect("accountList");
			} else {
				request.setAttribute("error", "User Not Found");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}

		} else if ("Logout".equalsIgnoreCase(operation)) {
			session.invalidate();
			response.sendRedirect("login");

		} else if ("reset password".equalsIgnoreCase(operation)) {
			AccountDTO dto = service.getByEmailId(request.getParameter("emailid"));
			if (dto != null) {
				dto.setPassword(request.getParameter("confirm"));
				service.update(dto);
				response.sendRedirect("login");
			} else {
				request.setAttribute("error", "EmailId is not found");
				RequestDispatcher rd = request.getRequestDispatcher("forgotted.jsp");
				rd.forward(request, response);
			}

		} else if ("change".equalsIgnoreCase(operation)) {
			AccountDTO dto = service.getByEmailId(request.getParameter("emailid"));
			if (dto != null) {
				dto.setPassword(request.getParameter("confirm"));
				service.update(dto);
				session.invalidate();
			}
			response.sendRedirect("login");

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
