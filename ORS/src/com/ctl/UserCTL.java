package com.ctl;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.service.UserService;

@WebServlet(urlPatterns = { "/user.do", "/newUser" })
public class UserCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		UserService service = new UserService();

		if ("get".equalsIgnoreCase(operation)) {
			UserDTO userDTO = service.getById(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("userDTO", userDTO);
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			rd.forward(request, response);

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			rd.forward(request, response);

		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		UserDTO dto = new UserDTO();
		UserService service = new UserService();
		if ("add".equalsIgnoreCase(operation)) {
			UserDTO userDTO = service.getByEmailId(request.getParameter("emailId"));
			if (userDTO != null) {
				request.setAttribute("userError", "Email Id Already Exist");
				RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
				rd.forward(request, response);
			} else {
				dto.setFirstName(request.getParameter("firstName"));
				dto.setLastName(request.getParameter("lastName"));
				dto.setEmailId(request.getParameter("emailId"));
				dto.setPassword(request.getParameter("password"));
				dto.setAddress(request.getParameter("address"));
				dto.setMobileNumber(request.getParameter("mobileNumber"));
				service.add(dto);
				response.sendRedirect("login");

			}

		} else if ("update".equalsIgnoreCase(operation)) {
			dto.setFirstName(request.getParameter("firstName"));
			dto.setLastName(request.getParameter("lastName"));
			dto.setEmailId(request.getParameter("emailId"));
			dto.setPassword(request.getParameter("password"));
			dto.setAddress(request.getParameter("address"));
			dto.setMobileNumber(request.getParameter("mobileNumber"));
			dto.setId(Integer.valueOf(request.getParameter("id")));
			service.update(dto);
			response.sendRedirect("userList.do");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("user.jsp");
			rd.forward(request, response);

		}

	}
}
