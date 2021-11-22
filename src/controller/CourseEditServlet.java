package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.impl.CourseServiceImpl;

@WebServlet("/CourseEditServlet")
public class CourseEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Course course;
	private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
	private CourseFindAllServlet courseFindAllServlet = new CourseFindAllServlet();
	private CourseFindOneServlet courseFindOneServlet = new CourseFindOneServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		String courseTime = request.getParameter("courseTime");
		String classroom = request.getParameter("classroom");
		int status = Integer.parseInt(request.getParameter("status"));
		
		course = new Course(courseId, courseName, teacherId, courseTime, classroom, status);
		int rs = courseServiceImpl.editCourse(course);
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			courseFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			courseFindOneServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
