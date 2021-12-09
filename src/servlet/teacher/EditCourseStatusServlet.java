package servlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.CourseServiceImpl;

public class EditCourseStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
	private ServletTeaAllCos servletTeaAllCos = new ServletTeaAllCos();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseID"));
		int status = Integer.parseInt(request.getParameter("status"));
		System.out.println(status);
		int newStatus = 1 ^ status;
		System.out.println(newStatus);
		int rs = courseServiceImpl.banCourse(courseId, newStatus);
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			servletTeaAllCos.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			request.getRequestDispatcher("teacher/courseAll.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
