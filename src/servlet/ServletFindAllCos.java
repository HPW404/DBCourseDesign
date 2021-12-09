package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.CourseServiceImpl;
import model.PageBean;

public class ServletFindAllCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int pageNo = 1;
		int pageCount = 10;
		String pageNoStr = request.getParameter("pageNo");
		String pageCountStr = request.getParameter("pageCount");
		
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageCountStr != null) {
			pageCount = Integer.parseInt(pageCountStr);
		}
		
		PageBean list = courseServiceImpl.coursePageList(pageNo, pageCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/courseAllInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
