package controller.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserLogin;
import service.impl.UserServiceImpl;

@WebServlet("/StuRegisterCheckServlet")
public class StuRegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogin userLogin;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		userLogin = new UserLogin();
		userLogin.setUserId(studentId);
		// 验证是否存在该学生
		UserLogin rs = userServiceImpl.login(userLogin);
		if(rs.getRole() == 2) {
			out.print("正确");
		} else {
			out.print("该编号已存在");
		}
	}

}
