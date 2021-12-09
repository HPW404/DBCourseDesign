package servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import model.UserLogin;
import service.Impl.StudentServiceImpl;
import service.Impl.UserServiceImpl;
import servlet.ServletFindAllStu;
import dao.Impl.StudentDaoImpl;
import dao.Impl.UserDaoImpl;

public class ServletRegisterStu extends HttpServlet{
	
	private UserLogin user;
//	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
//	private StudentServiceImpl studentServiceImpl =new StudentServiceImpl();
	//private ServletFindAllStu findStu=new ServletFindAllStu();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		String stuNum = request.getParameter("userID");
		user=new UserLogin();
		user.setUserId(stuNum);
		//验证是否存在该学生
		UserLogin rs=userServiceImpl.login(user);
		if(rs.getUserId()==0){
			out.print("正确");
			
		}else{
		
			out.print("该学号已存在");
			
		}
		
		
	}

}
