package servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import service.Impl.SelectedCourseServiceImpl;

public class CourseSelectedShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int pageNo = 1;
		int pageCount = 10;
		String studentName = (String) request.getSession().getAttribute("userName");
		System.out.println(studentName);
		String pageNoStr = request.getParameter("pageNo");
		String pageCountStr = request.getParameter("pageCount");
		
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageCountStr != null) {
			pageCount = Integer.parseInt(pageCountStr);
		}
		
		PageBean list = selectedCourseServiceImpl.selectedCourseShow(pageNo, pageCount, studentName);
		request.setAttribute("list", list);
		request.getRequestDispatcher("student/selectedCourseShow.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

