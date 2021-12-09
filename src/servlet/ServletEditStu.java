package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.StudentServiceImpl;
import model.Student;

public class ServletEditStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Student student;
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	private ServletFindAllStu studentFindAllServlet = new ServletFindAllStu();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String studentId = (request.getParameter("studentId"));
		String studentName = request.getParameter("studentName");
		String sex = request.getParameter("sex");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		student = new Student(studentId, studentName, sex, birthYear, grade, collegeId);
		int rs = studentServiceImpl.editStudent(student, collegeId,studentName);
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			studentFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			request.getRequestDispatcher("admin/editStudent.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
