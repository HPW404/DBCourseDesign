package servlet.student;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;
import service.Impl.UserServiceImpl;
import model.Student;
import model.UserLogin;

public class ServletRegistersStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogin userLogin;
	private Student student;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String studentId = (request.getParameter("studentId"));
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
		int roleId = Integer.parseInt(request.getParameter("role"));
		
		userLogin = new UserLogin(studentName, password, roleId);
		student = new Student(studentId, studentName, sex, birthYear, grade, collegeId);
		
		int rsUser = userServiceImpl.addUser(userLogin);
		int rsStu = studentServiceImpl.addStudent(student, birth, g);
		if(rsUser > 0 && rsStu > 0) {
			request.setAttribute("message", "×¢²á³É¹¦£¡");
			request.getRequestDispatcher("login/login.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "×¢²áÊ§°Ü£¡");
			request.getRequestDispatcher("register/register.jsp");
		}
	}

}
