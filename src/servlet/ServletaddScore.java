package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.SelectedCourseServiceImpl;
import model.SC;

public class ServletaddScore extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SC sc;
	private ServletFindAllScore servletFindAllScore = new ServletFindAllScore();
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseID = Integer.parseInt(request.getParameter("courseID"));
		String courseName = request.getParameter("courseName");
		int studentID = Integer.parseInt(request.getParameter("studentID"));
		String studentName = request.getParameter("studentName");
		int mark = Integer.parseInt(request.getParameter("mark"));
		
		sc = new SC(studentID, studentName, courseID, courseName, mark);
		SC scor = selectedCourseServiceImpl.selectStudentScore(sc);
		if(scor == null) {
			int rs = selectedCourseServiceImpl.addScore(sc);
			if(rs > 0) {
				request.setAttribute("message", "添加成功！！");
				servletFindAllScore.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
			} else {
				request.setAttribute("message", "添加失败！！");
				request.getRequestDispatcher("admin/addScore.jsp").forward(request, response);
			}
		} else{
			request.setAttribute("message", "该生的本门课成绩已录入，请重新录入！！");
			request.getRequestDispatcher("admin/addScore.jsp").forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
