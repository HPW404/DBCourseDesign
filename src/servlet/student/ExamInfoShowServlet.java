package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SelectedCourse;
import service.Impl.SelectedCourseServiceImpl;

public class ExamInfoShowServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String studentName = (String) request.getSession().getAttribute("userName");
		System.out.println(studentName);
		List<SelectedCourse> rs = selectedCourseServiceImpl.findOne(studentName);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/stuExamQuery.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
}

