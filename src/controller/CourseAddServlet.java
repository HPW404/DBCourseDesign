package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.impl.CourseServiceImpl;

@WebServlet("/CourseAddServlet")
public class CourseAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Course course;
    private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
    private CourseFindAllServlet courseFindAllServlet = new CourseFindAllServlet();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseID"));
		String courseName = request.getParameter("courseName");
		int teacherId = Integer.parseInt(request.getParameter("teacherID"));
		String courseTime = request.getParameter("courseTime");
		String classroom = request.getParameter("classroom");
		int status = Integer.parseInt(request.getParameter("status"));
		
		course = new Course(courseId, courseName, teacherId, courseTime, classroom, status);
		// 查看该课程是否存在
		Course cos = courseServiceImpl.selectCourse(course);
		if(cos == null) {
			int rs = courseServiceImpl.addCourse(course);
			if(rs > 0) {
				request.setAttribute("message", "添加成功！");
				courseFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "添加失败！");
				request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "该课程已存在，请重新添加！");
			request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
