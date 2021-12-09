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

import model.SelectedCourse;
import dao.Impl.SelectedCourseDaoImpl;

public class ServletEditScore extends HttpServlet{

	private SelectedCourse score;
	private ServletFindAllScore servletFindAllScore=new ServletFindAllScore();
	private SelectedCourseServiceImpl scoreServiceImpl=new SelectedCourseServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int courseID = Integer.valueOf(request.getParameter("courseID"));
		int studentID = Integer.valueOf(request.getParameter("studentID"));
		int mark = Integer.valueOf(request.getParameter("mark"));
		Date examtime=null;
		try {
			examtime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("examtime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		score=new SelectedCourse(courseID,studentID,mark,examtime);
		int rs=scoreServiceImpl.editSelectedCourse(score,examtime.toString());
		if(rs>0){
			request.setAttribute("msg", "修改成功！！");
			servletFindAllScore.doGet(request, response);
			//	request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}else{
			request.setAttribute("msg", "修改失败！！");
			request.getRequestDispatcher("admin/editScore.jsp").forward(request, response);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
