package servlet.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserLogin;
import service.Impl.UserServiceImpl;

public class TeaRegisterCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogin userLogin;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		userLogin = new UserLogin();
		userLogin.setUserId(teacherId);
		// 验证是否存在该老师
		UserLogin rs = userServiceImpl.login(userLogin);
		if(rs.getRole() == 1) {
			out.print("正确");
		} else {
			out.print("该工号已存在");
		}
	}

}
