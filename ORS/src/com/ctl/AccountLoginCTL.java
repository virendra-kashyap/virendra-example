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
import com.dto.UserDTO;
import com.service.AccountService;
import com.service.UserService;

/**
 * Servlet implementation class AccountLoginCTL
 */
@WebServlet("/accountLogin")
public class AccountLoginCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		String emailId = request.getParameter("emailId");
		String password = request.getParameter("password");
		AccountService service = new AccountService();
		HttpSession session = request.getSession(true);

		if ("Log In".equalsIgnoreCase(operation)) {
			AccountDTO dto = service.authenticate(emailId, password);
			if (dto != null) {
				session.setAttribute("accountDTO", dto);
				response.sendRedirect("account");
			} else {
				request.setAttribute("error", "User Not found");
				RequestDispatcher rd = request.getRequestDispatcher("accountLogin.jsp");
				rd.forward(request, response);
			}
		}

	}

}
