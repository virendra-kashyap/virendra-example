package com.ctl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.AccountDTO;
import com.dto.TransectionDTO;
import com.mysql.jdbc.UpdatableResultSet;
import com.service.AccountService;
import com.service.TransectionService;
import com.utility.BaseUtility;

@WebServlet("/accountList")
public class AccountListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountService service = new AccountService();
		ArrayList list = null;
		int pageIndex = BaseUtility.toInteger(request.getParameter("pageIndex"));
		int pageSize = 3;
		if ("next".equalsIgnoreCase(operation)) {
			pageIndex = pageIndex + 1;
			list = service.listByPage(pageIndex * pageSize, pageSize);
			request.setAttribute("list", list);
			pageIndex = list.size() == 0 ? pageIndex - 1 : pageIndex;
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);

		} else if ("previous".equalsIgnoreCase(operation)) {
			pageIndex = pageIndex != 0 ? pageIndex - 1 : pageIndex;
			list = service.listByPage(pageIndex * pageSize, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);

		} else if ("search".equalsIgnoreCase(operation)) {
			list = service.searchByName(request.getParameter("searchByName"));
			request.setAttribute("list", list);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);

		} else {
			list = service.listByPage(0, pageSize);
			request.setAttribute("list", list);
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountService service = new AccountService();
		int amount = BaseUtility.toInteger(request.getParameter("amount"));
		if ("delete".equalsIgnoreCase(operation)) {
			String[] ids = request.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				service.delete(BaseUtility.toInteger(ids[i]));
			}
			response.sendRedirect("accountList");
		} else if ("deposit".equalsIgnoreCase(operation)) {
			AccountDTO account = service.getByAccountNo(request.getParameter("accountno"));
			if (account != null) {
				int balance = account.getBalance();
				balance = balance + amount;
				account.setBalance(balance);
				service.update(account);
			}
			response.sendRedirect("accountList");
		} else if ("withdraw".equalsIgnoreCase(operation)) {
			AccountDTO dto = service.getByAccountNo(request.getParameter("accountno"));
			if (dto != null) {
				int balance = dto.getBalance();
				if (balance <= amount) {
					request.setAttribute("dto", "Less Balance..Transaction Failed..");
					RequestDispatcher rd = request.getRequestDispatcher("withdraw.jsp");
					rd.forward(request, response);
				} else {
					balance = balance - amount;
					dto.setBalance(balance);
					service.update(dto);
				}
			}
			response.sendRedirect("accountList");
		}

	}

}
