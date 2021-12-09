package servlet.teacher;
/*!-- 查询教师所带课程的学生成绩 -->*/
import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.SelectedCourseServiceImpl;

import model.PageBean;
import model.SC;
//import model.SelectedCourse;

public class ServletTeaSearchScore extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SC sc;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo=1;
		int pageCount=10;
		String teaName=(String) request.getSession().getAttribute("userName");
		String pageNoStr=request.getParameter("pageNo");
		String pageCountStr=request.getParameter("pageCount");
	
		
		if(pageNoStr!=null){
			pageNo=Integer.parseInt(pageNoStr);
		}
		if(pageCountStr!=null){
			pageCount=Integer.parseInt(pageCountStr);
		}
		
		
		String courseName = request.getParameter("courseName");
		int studentID = Integer.parseInt((request.getParameter("studentID")));
		String studentName = request.getParameter("studentName");
		
		sc = new SC(studentID, courseName, studentName);
		PageBean rs = selectedCourseServiceImpl.selectStuScore(pageNo, pageCount, teaName);
		request.setAttribute("list", rs);
		request.setAttribute("score", sc);
		request.getRequestDispatcher("teacher/stuTeaScore.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
