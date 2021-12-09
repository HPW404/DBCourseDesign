package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserLogin;
import service.Impl.UserServiceImpl;


public class ServletSelectUser extends HttpServlet{
	
	private UserLogin user;
	private UserServiceImpl userServiceImpl=new UserServiceImpl();
	private ServletFindAllUser servletFindAllUser=new ServletFindAllUser();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String userNum=(String) (request.getParameter("qk"));
		System.out.println((request.getParameter("qk")));
		System.out.println(userNum);
		String password="123";
		user=new UserLogin();
		user.setUserName(userNum);
		user.setPassword(password);
		int rs=userServiceImpl.editPassword(user);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			request.setAttribute("password", user.getPassword());
			servletFindAllUser.doGet(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			request.setAttribute("password", user.getPassword());
			servletFindAllUser.doGet(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}

}
