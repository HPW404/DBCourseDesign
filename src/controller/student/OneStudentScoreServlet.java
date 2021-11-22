package controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SC;
import service.impl.SelectedCourseServiceImpl;

@WebServlet("/OneStudentScoreServlet")
public class OneStudentScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		List<SC> rs = selectedCourseServiceImpl.findStuOne(studentId, courseId);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/scoreOne.jsp").forward(request, response);
	}

}
