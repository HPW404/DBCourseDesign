package com.dbproj.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbproj.model.UserLogin;
import com.dbproj.dao.RegisterDao;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		
		int userId = Integer.valueOf(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		int role = Integer.valueOf(request.getParameter("role"));
		RegisterDao regDao = new RegisterDao();
		UserLogin user = regDao.register(userId, userName, password, role);
		if(user != null) {
			
		} else {
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
	}

}
