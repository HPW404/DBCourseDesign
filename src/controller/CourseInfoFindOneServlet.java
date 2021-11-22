package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseInfo;
import service.impl.CourseInfoServiceImpl;

@WebServlet("/CourseInfoFindOneServlet")
public class CourseInfoFindOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseInfoServiceImpl courseInfoServiceImpl = new CourseInfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		List<CourseInfo> rs = courseInfoServiceImpl.findOne(courseId);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editCourseInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
