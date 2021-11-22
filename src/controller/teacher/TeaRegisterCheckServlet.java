package controller.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserLogin;
import service.impl.UserServiceImpl;

@WebServlet("/TeaRegisterCheckServlet")
public class TeaRegisterCheckServlet extends HttpServlet {
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
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		userLogin = new UserLogin();
		userLogin.setUserId(teacherId);
		// ��֤�Ƿ���ڸ���ʦ
		UserLogin rs = userServiceImpl.login(userLogin);
		if(rs.getRole() == 1) {
			out.print("��ȷ");
		} else {
			out.print("�ù����Ѵ���");
		}
	}

}
