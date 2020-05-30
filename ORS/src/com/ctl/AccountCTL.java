package com.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AccountDTO;
import com.dto.UserDTO;
import com.service.AccountService;
import com.utility.BaseUtility;

@WebServlet("/account.do")
public class AccountCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountService service = new AccountService();
		if ("get".equalsIgnoreCase(operation)) {
			AccountDTO accountDTO = service.getById(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("accountDTO", accountDTO);
			RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
			rd.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountDTO dto = new AccountDTO();
		AccountService service = new AccountService();
		if ("add".equalsIgnoreCase(operation)) {
			AccountDTO accountDTO = service.getByAccountNo(request.getParameter("accountNo"));
			AccountDTO accountDTO2 = service.getByEmailId(request.getParameter("emailId"));
			if (accountDTO != null) {
				request.setAttribute("accountError", "Account Number Already exist");
				RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
				rd.forward(request, response);
			} else if (accountDTO2 != null) {
				request.setAttribute("accountError", "Email Id Already exist");
				RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
				rd.forward(request, response);
			} else {
				dto.setAccountNo(request.getParameter("accountNo"));
				dto.setUserName(request.getParameter("userName"));
				dto.setEmailId(request.getParameter("emailId"));
				dto.setPassword(request.getParameter("password"));
				dto.setBalance(BaseUtility.toInteger(request.getParameter("balance")));
				service.add(dto);
				response.sendRedirect("accountList.do");
			}
		} else if ("update".equalsIgnoreCase(operation)) {
			dto.setAccountNo(request.getParameter("accountNo"));
			dto.setUserName(request.getParameter("userName"));
			dto.setEmailId(request.getParameter("emailId"));
			dto.setPassword(request.getParameter("password"));
			dto.setBalance(BaseUtility.toInteger(request.getParameter("balance")));
			dto.setId(BaseUtility.toInteger(request.getParameter("id")));
			service.update(dto);
			response.sendRedirect("accountList.do");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("account.jsp");
			rd.forward(request, response);

		}
	}

}
