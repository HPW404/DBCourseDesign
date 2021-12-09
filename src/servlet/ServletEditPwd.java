package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.UserServiceImpl;

import model.UserLogin;
import dao.Impl.UserDaoImpl;

public class ServletEditPwd extends HttpServlet{
	
	private UserLogin user;
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userNum=(String) request.getSession().getAttribute("userName");
		String password=request.getParameter("pwd");
		user=new UserLogin();
		user.setUserName(userNum);
		user.setPassword(password);
		int rs=userServiceImpl.editPassword(user);
		if(rs>0){
			request.setAttribute("msg", "�޸ĳɹ�����");
			request.setAttribute("password", user.getPassword());
			request.getRequestDispatcher("admin/selectPwd.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "�޸�ʧ�ܣ���");
			request.setAttribute("password", user.getPassword());
			request.getRequestDispatcher("admin/selectPwd.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
