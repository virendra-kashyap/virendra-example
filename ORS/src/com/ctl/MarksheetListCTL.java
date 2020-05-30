package com.ctl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.MarksheetService;
import com.service.UserService;
import com.utility.BaseUtility;

@WebServlet("/marksheetList.do")
public class MarksheetListCTL extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		MarksheetService service = new MarksheetService();
		ArrayList list = null;
		int pageIndex = BaseUtility.toInteger(request.getParameter("pageIndex"));
		int pageSize = 4;
		if ("search".equalsIgnoreCase(operation)) {
			list = service.searchByName(request.getParameter("searchByName"));
			request.setAttribute("marksheetList", list);
			RequestDispatcher rd = request.getRequestDispatcher("marksheetList.jsp");
			rd.forward(request, response);

		} else if ("next".equalsIgnoreCase(operation)) {
			pageIndex = pageIndex + 1;
			list = service.listByPage(pageIndex * pageSize, pageSize);
			request.setAttribute("marksheetList", list);
			pageIndex = list.size() == 0 ? pageIndex - 1 : pageIndex;
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("marksheetList.jsp");
			rd.forward(request, response);

		} else if ("previous".equalsIgnoreCase(operation)) {

			pageIndex = pageIndex != 0 ? pageIndex - 1 : pageIndex;
			list = service.listByPage(pageIndex * pageSize, pageSize);
			request.setAttribute("marksheetList", list);
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("marksheetList.jsp");
			rd.forward(request, response);

		} else {
			list = service.listByPage(0, pageSize);
			request.setAttribute("marksheetList", list);
			request.setAttribute("pageIndex", pageIndex);
			RequestDispatcher rd = request.getRequestDispatcher("marksheetList.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		MarksheetService service = new MarksheetService();
		if ("delete".equalsIgnoreCase(operation)) {
			String[] ids = request.getParameterValues("ids");
			for (int i = 0; i < ids.length; i++) {
				service.delete(Integer.valueOf(ids[i]));
			}
			response.sendRedirect("marksheetList.do");

		}
	}

}
