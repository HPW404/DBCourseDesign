package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.UserServiceImpl;
import model.UserLogin;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserLogin userLogin;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userID"));
		String password = request.getParameter("password");
		int roleId = Integer.parseInt(request.getParameter("role"));
		
		userLogin = new UserLogin(userId, password, roleId);
		UserLogin rs = userServiceImpl.login(userLogin);
		
		if(rs.getUserName() != null) {
			if(rs.getUserId() == userLogin.getUserId()) {
				if(rs.getPassword().equals(userLogin.getPassword())) {
					if(rs.getRole() == userLogin.getRole()) {
						if(rs.getRole() == 0) {
							request.getSession().setAttribute("userName", rs.getUserName());
							request.getSession().setAttribute("userId", rs.getUserId());
							request.getRequestDispatcher("admin/admin.jsp").forward(request, response);
						} else if(rs.getRole() == 1) {
							request.getSession().setAttribute("userName", rs.getUserName());
							request.getSession().setAttribute("userId", rs.getUserId());
							request.getRequestDispatcher("teacher/teacher.jsp").forward(request, response);
						} else if(rs.getRole() == 2) {
							request.getSession().setAttribute("userName", rs.getUserName());
							request.getSession().setAttribute("userId", rs.getUserId());
							request.getRequestDispatcher("student/student.jsp").forward(request, response);
						}
					} else {
						request.setAttribute("message", "角色不正确！");
						request.getRequestDispatcher("login/login.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("message", "密码不正确！");
					request.getRequestDispatcher("login/login.jsp").forward(request, response);
				}
			} else {
				request.setAttribute("message", "用户不存在！");
				request.getRequestDispatcher("login/login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "用户不存在！");
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
