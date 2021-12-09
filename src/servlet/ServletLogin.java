package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;
import dao.Impl.UserDaoImpl;
import model.UserLogin;

public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserLogin userLogin;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String num=request.getParameter("ID");
		String pwd=request.getParameter("pwd");
		int roleID=Integer.parseInt(request.getParameter("role")); 
		
		userLogin = new UserLogin(num,pwd,roleID);
		UserLogin rs = userServiceImpl.login(userLogin);
		System.out.println(userLogin.getUserName());
		System.out.println(userLogin.getPassword());
		if(rs==null) {
			request.setAttribute("message", "用户不存在！");
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		}
		if(rs.getUserName() != null) {
			System.out.println("diyic");
			System.out.println(rs.getUserName());
			System.out.println(userLogin.getUserName());
			if(rs.getUserName().equals(userLogin.getUserName())) {
				
				System.out.println("dierc");
				if(rs.getPassword().equals(userLogin.getPassword())) {
					System.out.println("disanc");
					if(rs.getRole() == userLogin.getRole()) {
						System.out.println("disic");
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
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
