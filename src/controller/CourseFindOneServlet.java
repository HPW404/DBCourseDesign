package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import service.impl.CourseServiceImpl;

@WebServlet("/CourseFindOneServlet")
public class CourseFindOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		List<Course> rs = courseServiceImpl.findOne(courseId);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
