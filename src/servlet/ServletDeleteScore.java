package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.SelectedCourseServiceImpl;

import dao.Impl.SelectedCourseDaoImpl;
import model.SelectedCourse;



public class ServletDeleteScore extends HttpServlet{

	private SelectedCourse score;
	private ServletFindAllScore servletFindAllScore=new ServletFindAllScore();
	private SelectedCourseDaoImpl scoreServiceImpl=new SelectedCourseDaoImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int studentID = Integer.parseInt(request.getParameter("studnetID"));
		int courseID= Integer.parseInt(request.getParameter("courseID"));
	
		int rs=scoreServiceImpl.deleteSelectedCourse(studentID,courseID);
		if(rs>0){
			request.setAttribute("msg", "删除成功！！");
			servletFindAllScore.doGet(request, response);
		}else{
			request.setAttribute("msg", "删除成功！！");
			servletFindAllScore.doGet(request, response);
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	

}
