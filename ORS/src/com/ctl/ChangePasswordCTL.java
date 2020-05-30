package com.ctl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.UserDTO;
import com.service.UserService;

@WebServlet("/changePassword")
public class ChangePasswordCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserService service = new UserService();
		String operation = request.getParameter("operation");

		if ("change Password".equalsIgnoreCase(operation)) {
			UserDTO dto = service.getByEmailId(request.getParameter("emailId"));

			if (dto != null) {
				dto.setPassword(request.getParameter("confirmPassword"));
				service.update(dto);
				session.invalidate();
			}
			response.sendRedirect("login");
		}
	}

}
