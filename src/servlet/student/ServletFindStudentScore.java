package servlet.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.SelectedCourseServiceImpl;
import model.PageBean;

public class ServletFindStudentScore extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int pageNo = 1;
		int pageCount = 10;
		String studentId = (String)request.getSession().getAttribute("userName");
		
		String pageNoStr = request.getParameter("pageNo");
		String pageCountStr = request.getParameter("pageCount");
		
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageCountStr != null) {
			pageCount = Integer.parseInt(pageCountStr);
		}
		
		PageBean rs = selectedCourseServiceImpl.scPageList(pageNo, pageCount, Integer.valueOf(studentId));
		request.setAttribute("list", rs);
		request.getRequestDispatcher("student/selectScore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
