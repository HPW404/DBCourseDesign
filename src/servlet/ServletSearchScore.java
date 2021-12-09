package servlet;
/*<!-- 模糊查询学生成绩 -->*/
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import model.SelectedCourse;

import org.omg.CORBA.Request;

import service.Impl.SelectedCourseServiceImpl;

public class ServletSearchScore extends HttpServlet{
	/*
	private SelectedCourse score;
	private SelectedCourseServiceImpl scoreServiceImpl=new SelectedCourseServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		
		doPost(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo=1;
		int pageCount=1;
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		int courseID = Integer.valueOf(request.getParameter("courseID"));
		int studentID = Integer.valueOf(request.getParameter("studentID"));
		int mark = Integer.valueOf(request.getParameter("mark"));
		Date examtime=null;
		try {
			examtime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("examtime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/*if(stuNum==""){
			stuNum=null;
		}
		if(courseName==""){
			courseName=null;
		}
		if(stuName==""){
			stuName=null;
		}
		if(stuClass==""){
			stuClass=null;
		}
		if(major==""){
			major=null;
		}*/
		double scoreGrade=0;
		/*
		score=new SelectedCourse(courseID,studentID,mark,examtime);
		PageBean rs=scoreServiceImpl.selectStuScore(pageNo, pageCount, );
		request.setAttribute("list", rs);
		request.setAttribute("score", score);
		request.getRequestDispatcher("admin/selectblurScore.jsp").forward(request, response);
	}
*/
}
