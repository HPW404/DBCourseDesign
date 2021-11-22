package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CourseServiceImpl;

@WebServlet("/CourseDeleteServlet")
public class CourseDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
	private CourseFindAllServlet courseFindAllServlet = new CourseFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int rs = courseServiceImpl.deleteCourse(courseId);
		
		if(rs > 0) {
			request.setAttribute("message", "É¾³ý³É¹¦£¡");
			courseFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
			courseFindAllServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
