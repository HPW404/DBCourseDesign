package controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.TeacherServiceImpl;
import service.impl.UserServiceImpl;
import model.Teacher;
import model.UserLogin;

@WebServlet("/TeacherAddServlet")
public class TeacherAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserLogin userLogin;
	private Teacher teacher;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
	private TeacherFindAllServlet teacherFindAllServlet = new TeacherFindAllServlet();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
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
		String degree = request.getParameter("degree");
		String birth = request.getParameter("birthYear");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		String password = request.getParameter("password");
		int role = Integer.parseInt(request.getParameter("role"));
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		userLogin = new UserLogin(teacherId, password, role);
		teacher = new Teacher(teacherId, teacherName, sex, birthYear, degree, title, grade, collegeId);
		// 验证是否已经存在该教师
		UserLogin rs = userServiceImpl.login(userLogin);
		if(rs.getUserId() == 0) {
			int rsUser = userServiceImpl.addUser(userLogin);
			int rsTeacher = teacherServiceImpl.addTeacher(teacher, birth, g);
			if(rsTeacher > 0 && rsUser > 0) {
				request.setAttribute("message", "添加成功！");
				teacherFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "添加失败！");
				request.getRequestDispatcher("admin/addTeacher.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "该工号已经存在，请重新录入！");
			request.getRequestDispatcher("admin/addTeacher.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
