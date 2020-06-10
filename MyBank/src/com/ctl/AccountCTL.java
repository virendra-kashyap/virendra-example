package com.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AccountDTO;
import com.service.AccountService;
import com.utility.BaseUtility;

@WebServlet("/signup")
public class AccountCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountService service = new AccountService();
		if ("get".equalsIgnoreCase(operation)) {
			AccountDTO accountDTO = service.getById(BaseUtility.toInteger(request.getParameter("id")));
			request.setAttribute("accountDTO", accountDTO);
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountDTO dto = new AccountDTO();
		AccountService service = new AccountService();
		if ("submit".equalsIgnoreCase(operation)) {
			dto.setAccountNo(request.getParameter("accountno"));
			dto.setFirstName(request.getParameter("firstname"));
			dto.setLastName(request.getParameter("lastname"));
			dto.setEmailId(request.getParameter("emailid"));
			dto.setPassword(request.getParameter("password"));
			dto.setContactNo(request.getParameter("contactno"));
			dto.setAddress(request.getParameter("address"));
			dto.setBalance(BaseUtility.toInteger(request.getParameter("balance")));
			service.add(dto);
			response.sendRedirect("login");
		} else if ("update".equalsIgnoreCase(operation)) {
			dto.setAccountNo(request.getParameter("accountno"));
			dto.setFirstName(request.getParameter("firstname"));
			dto.setLastName(request.getParameter("lastname"));
			dto.setEmailId(request.getParameter("emailid"));
			dto.setPassword(request.getParameter("password"));
			dto.setContactNo(request.getParameter("contactno"));
			dto.setAddress(request.getParameter("address"));
			dto.setBalance(BaseUtility.toInteger(request.getParameter("balance")));
			dto.setId(BaseUtility.toInteger(request.getParameter("id")));
			service.update(dto);
			response.sendRedirect("accountList");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
		}
	}

}
