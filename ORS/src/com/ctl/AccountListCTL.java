package com.ctl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.AccountService;
import com.service.UserService;
import com.utility.BaseUtility;

/**
 * Servlet implementation class AccountListCTL
 */
@WebServlet("/accountList.do")
public class AccountListCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountService service = new AccountService();
		ArrayList list = null;
		int pageIndex = BaseUtility.toInteger(request.getParameter("pageIndex"));
		int pageSize = 4;
		if ("search".equalsIgnoreCase(operation)) {
			list = service.searchByName(request.getParameter("searchByName"));
			request.setAttribute("accountList", list);
			RequestDispatcher rd = request.getRequestDispatcher("accountList.jsp");
			rd.forward(request, response);

		} else if ("next".equalsIgnoreCase(operation)) {
			pageIndex = pageIndex + 1;
			list = service.listByPage(pageIndex * pageSize, pageSize);
			request.setAttribute("accountList", list);
			pageIndex = list.size() == 0 ? pageIndex - 1 : pageIndex;
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("accountList.jsp");
			rd.forward(request, response);

		} else if ("previous".equalsIgnoreCase(operation)) {
			pageIndex = pageIndex != 0 ? pageIndex - 1 : pageIndex;
			list = service.listByPage(pageIndex * pageSize, pageSize);
			request.setAttribute("accountList", list);
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("accountList.jsp");
			rd.forward(request, response);

		} else {
			list = service.listByPage(0, pageSize);
			request.setAttribute("accountList", list);
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("accountList.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		AccountService service = new AccountService();
		if ("delete".equalsIgnoreCase(operation)) {
			String[] ids = request.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				service.delete(Integer.valueOf(ids[i]));

			}
			response.sendRedirect("accountList.do");
		}
	}
}
