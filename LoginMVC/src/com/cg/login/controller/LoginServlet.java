package com.cg.login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.login.bean.LoginBean;
import com.cg.login.exception.LoginException;
import com.cg.login.service.ILoginService;
import com.cg.login.service.LoginServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname").trim();
		String password = request.getParameter("pwd").trim();
		ILoginService service = new LoginServiceImpl();
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		if (service.validate(loginBean)) {
			try {
				if (service.verifyLogin(loginBean)) {
					HttpSession httpSession=request.getSession();
					httpSession.setAttribute("username", username);
					request.getRequestDispatcher("inbox.jsp")
					.include(request, response);
				} else {
					request.setAttribute("errmsg",
							"Invalid Username and Password! Try Again!!");
					request.getRequestDispatcher("error.jsp")
							.include(request, response);
				}
			} catch (LoginException e) {
				request.setAttribute("errmsg", e.getMessage());
				request.getRequestDispatcher("error.jsp").include(request,
						response);
			}
		} else {
			request.setAttribute("errmsg",
					"Invalid Username and Password! Try Again!!");
			request.getRequestDispatcher("error.jsp")
					.include(request, response);

		}
	}
}