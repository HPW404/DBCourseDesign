package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.StudentServiceImpl;

@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
	private StudentFindAllServlet studentFindAllServlet = new StudentFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int rs = studentServiceImpl.deleteStudent(studentId);
		
		if(rs > 0) {
			request.setAttribute("message", "É¾³ý³É¹¦£¡");
			studentFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
			studentFindAllServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
