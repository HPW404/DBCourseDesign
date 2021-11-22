package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.TeacherServiceImpl;
import model.Teacher;

@WebServlet("/TeacherFindOneServlet")
public class TeacherFindOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		List<Teacher> rs = teacherServiceImpl.findOne(teacherId);
		
		request.setAttribute("list", rs);
		request.getRequestDispatcher("admin/editTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
