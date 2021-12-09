package servlet;


import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.SelectedCourseServiceImpl;

//import dao.Impl.SelectedCourseDaoImpl;
//import model.SelectedCourse;
import model.PageBean;

public class ServletFindAllScore extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SelectedCourseServiceImpl scoreServiceImpl=new SelectedCourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo=1;
		int pageCount=10;
		String teacherName = (String) request.getSession().getAttribute("userName");
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
		
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
		PageBean list=scoreServiceImpl.scTeaPageList(pageNo, pageCount, teacherName);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/scoreAllInfo.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
}
