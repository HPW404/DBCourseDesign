package servlet.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Student;
import service.Impl.StudentServiceImpl;

public class ServletStudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String studentId = (String) request.getSession().getAttribute("userName");
		System.out.println(Integer.valueOf(studentId));
		List<Student> rs = studentServiceImpl.findOne((studentId));
		//System.out.println(rs.get(0).getStuId());
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/studentInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
