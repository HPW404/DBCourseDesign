package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SC;
import service.Impl.SelectedCourseServiceImpl;

public class ServletOneStudentScore extends HttpServlet {
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
		String courseName = request.getParameter("cosName");
		String studentName = ((String) request.getSession().getAttribute("userName"));
		System.out.println(courseName);
		System.out.println(studentName);
		List<SC> rs = selectedCourseServiceImpl.findStuOne(studentName, courseName);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/scoreOne.jsp").forward(request, response);
	}

}
