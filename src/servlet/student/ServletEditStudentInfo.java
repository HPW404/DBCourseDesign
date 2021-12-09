package servlet.student;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.Impl.StudentServiceImpl;
import servlet.ServletFindAllStu;
import dao.Impl.StudentDaoImpl;

public class ServletEditStudentInfo extends HttpServlet{
	
	private Student student;
	private StudentServiceImpl studentServiceImpl=new StudentServiceImpl();
	private ServletSelectStudentInfo findStu=new ServletSelectStudentInfo();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		String stuNum=(request.getParameter("stuID"));
		String stuName = request.getParameter("stuName");
		String stuSex = request.getParameter("sex");
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
		int major = Integer.valueOf(request.getParameter("major"));
		student = new Student(stuNum, stuName, stuSex, stuAge, grade, major);
		int rs=studentServiceImpl.editStudent(student);
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			findStu.doGet(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			request.getRequestDispatcher("student/editStudentInfo.jsp").forward(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
		doGet(request,response);
	}
}
