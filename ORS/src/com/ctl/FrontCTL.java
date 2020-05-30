package com.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FrontCTL implements Filter {
	private FilterConfig conf = null;

	private void distroy() {
		System.out.println("Distroyed" + conf.getFilterName());

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpSession session = httpServletRequest.getSession();

		if (session.getAttribute("userDTO") != null) {
			chain.doFilter(request, response);
		} else {
			request.setAttribute("sessionExpired", "OOPs Your Session Has Been Expired");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}

	}

	@Override
	public void init(FilterConfig conf) throws ServletException {
		this.conf = conf;
		System.out.println("Instantiated " + conf.getFilterName());
	}

}
