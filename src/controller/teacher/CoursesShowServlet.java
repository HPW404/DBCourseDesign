package controller.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.SelectedCourseServiceImpl;
import model.PageBean;
import model.TC;

@WebServlet("/CoursesShowServlet")
public class CoursesShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TC tc;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int pageNo = 1;
		int pageCount = 10;
		int teacherId = (Integer) request.getSession().getAttribute("userId");
		
		String pageNoStr = request.getParameter("pageNo");
		String pageCountStr = request.getParameter("pageCount");
		
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageCountStr != null) {
			pageCount = Integer.parseInt(pageCountStr);
		}
		String teacherName = "";
		tc.setTeacherName(teacherName);
		tc.setTeacherId(teacherId);
		
		PageBean list = selectedCourseServiceImpl.teacherCourse(pageNo, pageCount, teacherId, tc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("teacher/teachCourses.jsp").forward(request, response);
	}

}
