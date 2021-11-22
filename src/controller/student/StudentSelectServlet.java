package controller.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.impl.StudentServiceImpl;

@WebServlet("/StudentSelectServlet")
public class StudentSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int studentId = (Integer) request.getSession().getAttribute("studentId");
		List<Student> rs = studentServiceImpl.findOne(studentId);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/editStudentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
