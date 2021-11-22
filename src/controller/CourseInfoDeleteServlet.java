package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CourseInfoServiceImpl;

@WebServlet("/CourseInfoDeleteServlet")
public class CourseInfoDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseInfoServiceImpl courseInfoServiceImpl = new CourseInfoServiceImpl();
	private CourseInfoFindAllServlet courseInfoFindAllServlet = new CourseInfoFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int rs = courseInfoServiceImpl.deleteCourseInfo(courseId);
		
		if(rs > 0) {
			request.setAttribute("message", "É¾³ý³É¹¦£¡");
			courseInfoFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
			courseInfoFindAllServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
