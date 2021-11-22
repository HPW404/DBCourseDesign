package controller.teacher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.TeacherServiceImpl;
import service.impl.UserServiceImpl;
import model.Teacher;
import model.UserLogin;

@WebServlet("/RegisterTeacherServlet")
public class RegisterTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogin userLogin;
	private Teacher teacher;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		String teacherName = request.getParameter("teacherName");
		String sex = request.getParameter("sex");
		String g = request.getParameter("grade");
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String birth = request.getParameter("birthYear");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String degree = request.getParameter("degree");
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		int roleId = Integer.parseInt(request.getParameter("role"));
		
		userLogin = new UserLogin(teacherId, password, roleId);
		teacher = new Teacher(teacherId, teacherName, sex, birthYear, degree, title, grade, collegeId);
		
		int rsUser = userServiceImpl.addUser(userLogin);
		int rsTea = teacherServiceImpl.addTeacher(teacher, birth, g);
		if(rsUser > 0 && rsTea > 0) {
			request.setAttribute("message", "×¢²á³É¹¦£¡");
			request.getRequestDispatcher("login/login").forward(request, response);
		} else {
			request.setAttribute("message", "×¢²áÊ§°Ü£¡");
			request.getRequestDispatcher("register/register.jsp").forward(request, response);
		}
	}

}
