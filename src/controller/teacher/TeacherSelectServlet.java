package controller.teacher;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Teacher;
import service.impl.TeacherServiceImpl;

@WebServlet("/TeacherSelectServlet")
public class TeacherSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int teacherId = (Integer) request.getSession().getAttribute("teacherId");
		List<Teacher> rs = teacherServiceImpl.findOne(teacherId);
		request.setAttribute("list", rs);
		request.getRequestDispatcher("teacher/editTeacherInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
