package com.dbproj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbproj.dao.LoginDao;
import com.dbproj.model.UserLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		LoginDao loginDao = new LoginDao();
		UserLogin user = loginDao.login(userId, password);
		
		if(user != null) {
			response.sendRedirect("LoginScuess.jsp");
		} else {
			response.sendRedirect("LoginFail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
