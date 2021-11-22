package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.TeacherServiceImpl;

@WebServlet("/TeacherDeleteServlet")
public class TeacherDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
	private TeacherFindAllServlet teacherFindAllServlet = new TeacherFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		int rs = teacherServiceImpl.deleteTeacher(teacherId);
		if(rs > 0) {
			request.setAttribute("message", "É¾³ý³É¹¦£¡");
			teacherFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
			teacherFindAllServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
