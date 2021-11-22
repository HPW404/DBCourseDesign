package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.StudentServiceImpl;
import service.impl.UserServiceImpl;
import model.Student;
import model.UserLogin;

@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogin userLogin;
	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	private StudentFindAllServlet studentFindAllServlet = new StudentFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		String studentName = request.getParameter("studentName");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birthYear");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String g = request.getParameter("grade");
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));
		
		userLogin = new UserLogin(studentId, studentName, password, role);
		student = new Student(studentId, studentName, sex, birthYear, grade, collegeId);
		// 验证是否已存在该学生
		UserLogin rs = userServiceImpl.login(userLogin);
		if(rs.getRole() == 0) {
			int rsUser = userServiceImpl.addUser(userLogin);
			int rsStu = studentServiceImpl.addStudent(student, birth, g);
			if(rsStu > 0 && rsUser > 0) {
				request.setAttribute("message", "添加成功！");
				studentFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "添加失败！");
				request.getRequestDispatcher("admin/addStudent.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "该学号已经存在，请重新输入");
			request.getRequestDispatcher("admin/addStudent.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
