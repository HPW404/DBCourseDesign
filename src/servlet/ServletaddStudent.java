package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;
import service.Impl.UserServiceImpl;

import model.Student;
import model.UserLogin;

public class ServletaddStudent extends HttpServlet {

	private UserLogin user;
	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private StudentServiceImpl studentServiceImpl =new StudentServiceImpl();
	private ServletFindAllStu findStu=new ServletFindAllStu();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int stuID=Integer.valueOf(request.getParameter("stuId"));
		String stuNum = (request.getParameter("userID"));
		String stuName = request.getParameter("userName");
		String pwd = request.getParameter("password");
		String sex = request.getParameter("sex");
		Date stuAge = null;
		try {
			stuAge = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int college = Integer.valueOf(request.getParameter("collegeID"));
		int roleID = 2;
		user = new UserLogin(stuID,stuName, pwd, roleID);
		student = new Student(stuNum, stuName, sex, stuAge,
				grade,college);
		//验证是否存在该学生
		UserLogin rs=userServiceImpl.login(user);
		
		  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String SteaAge=sf.format(stuAge);
	        String Sgrade=sf.format(grade);
		if(rs==null){
			int rsUser=userServiceImpl.addUser(user);
			int rsStu=studentServiceImpl.addStudent(student,SteaAge, Sgrade);
			if(rsStu>0 && rsUser>0){
				request.setAttribute("msg", "添加成功！！");
				findStu.doGet(request, response);
				
				/*List list=studentDaoImpl.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addStudent.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该学号已存在，请重新录入！！");
			request.getRequestDispatcher("admin/addStudent.jsp").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
