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
import model.Teacher;

@WebServlet("/TeacherInfoEditServlet")
public class TeacherInfoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Teacher teacher;
	private TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
	private TeacherInfoServlet teacherInfoServlet = new TeacherInfoServlet();

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
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String birth = request.getParameter("birthYear");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String title = request.getParameter("title");
		
		teacher = new Teacher(teacherId, teacherName, sex, birthYear, degree, title, grade, collegeId);
		int rs = teacherServiceImpl.editTeacher(teacher, birth, g);
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			teacherInfoServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			request.getRequestDispatcher("teacher/editTeacherInfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
