package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CourseInfo;
import service.impl.CourseInfoServiceImpl;

@WebServlet("/CourseInfoEditServlet")
public class CourseInfoEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseInfo courseInfo;
	private CourseInfoServiceImpl courseInfoServiceImpl = new CourseInfoServiceImpl();
	private CourseInfoFindAllServlet courseInfoFindAllServlet = new CourseInfoFindAllServlet();
	private CourseInfoFindOneServlet courseInfoFindOneServlet = new CourseInfoFindOneServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		int courseWeek = Integer.parseInt(request.getParameter("courseWeek"));
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String courseType = request.getParameter("courseType");
		int score = Integer.parseInt(request.getParameter("score"));
		
		courseInfo = new CourseInfo(courseId, courseName, courseWeek, courseType, collegeId, score);
		int rs = courseInfoServiceImpl.editCourseInfo(courseInfo);
		
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			courseInfoFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			courseInfoFindOneServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
