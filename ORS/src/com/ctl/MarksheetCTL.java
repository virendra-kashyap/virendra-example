package com.ctl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.MarksheetDTO;
import com.dto.UserDTO;
import com.service.MarksheetService;
import com.service.UserService;
import com.utility.BaseUtility;

@WebServlet("/marksheet.do")
public class MarksheetCTL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		MarksheetService service = new MarksheetService();

		if ("get".equalsIgnoreCase(operation)) {
			MarksheetDTO marksheetDTO = service.getById(BaseUtility.toInteger(request.getParameter("id")));
			request.setAttribute("marksheetDTO", marksheetDTO);
			RequestDispatcher rd = request.getRequestDispatcher("marksheet.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("marksheet.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String operation = request.getParameter("operation");
		MarksheetDTO dto = new MarksheetDTO();
		MarksheetService service = new MarksheetService();
		if ("add".equalsIgnoreCase(operation)) {
			MarksheetDTO marksheetDTO = service.getByRollNumber(request.getParameter("rollNumber"));
			if (marksheetDTO != null) {
				request.setAttribute("marksheetError", "Roll Number Already exist");
				RequestDispatcher rd = request.getRequestDispatcher("marksheet.jsp");
				rd.forward(request, response);
			} else {
				dto.setRollNumber(request.getParameter("rollNumber"));
				dto.setName(request.getParameter("name"));
				dto.setHindi(BaseUtility.toInteger(request.getParameter("hindi")));
				dto.setEnglish(BaseUtility.toInteger(request.getParameter("english")));
				dto.setPhysics(BaseUtility.toInteger(request.getParameter("physics")));
				dto.setChemistry(BaseUtility.toInteger(request.getParameter("chemistry")));
				dto.setMaths(BaseUtility.toInteger(request.getParameter("maths")));
				service.add(dto);
				response.sendRedirect("marksheetList.do");
			}
		} else if ("update".equalsIgnoreCase(operation)) {
			dto.setRollNumber(request.getParameter("rollNumber"));
			dto.setName(request.getParameter("name"));
			dto.setHindi(BaseUtility.toInteger(request.getParameter("hindi")));
			dto.setEnglish(BaseUtility.toInteger(request.getParameter("english")));
			dto.setPhysics(BaseUtility.toInteger(request.getParameter("physics")));
			dto.setChemistry(BaseUtility.toInteger(request.getParameter("chemistry")));
			dto.setMaths(BaseUtility.toInteger(request.getParameter("maths")));
			dto.setId(BaseUtility.toInteger(request.getParameter("id")));
			service.update(dto);
			response.sendRedirect("marksheetList.do");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("marksheet.jsp");
			rd.forward(request, response);

		}

	}

}
