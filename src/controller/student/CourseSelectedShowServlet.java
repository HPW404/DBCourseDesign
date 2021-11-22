package controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SelectedCourse;
import service.impl.SelectedCourseServiceImpl;

@WebServlet("/CourseSelectedShowServlet")
public class CourseSelectedShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int studentId = (Integer) request.getSession().getAttribute("userId");
		List<SelectedCourse> rs = selectedCourseServiceImpl.findOne(studentId);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/selectedCourseShow.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
