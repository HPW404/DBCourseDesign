package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Course;
import model.CourseInfo;
import service.Impl.CourseInfoServiceImpl;
import service.Impl.CourseServiceImpl;


public class ServletaddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Course course;
    private CourseInfo courseinfo;
    private CourseServiceImpl courseServiceImpl = new CourseServiceImpl();
    private CourseInfoServiceImpl courseInfoServiceImpl= new CourseInfoServiceImpl();
    private ServletFindAllCos courseFindAllServlet = new ServletFindAllCos();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int courseId = Integer.parseInt(request.getParameter("courseID"));
		String courseName = request.getParameter("courseName");
		int teacherId = Integer.parseInt(request.getParameter("teacherID"));
		int courseweek= Integer.valueOf(request.getParameter("courseWeek"));
		String courseType=request.getParameter("courseType");
		int collegeid=Integer.valueOf(request.getParameter("collegeID"));
		String courseTime = request.getParameter("courseTime");
		String classroom = request.getParameter("classroom");
		int fen = Integer.valueOf(request.getParameter("score"));
		int status = 1;
		
		course = new Course(courseId, courseName, teacherId, courseTime, classroom, status);
		courseinfo=new CourseInfo(courseId,courseName,courseweek,courseType,collegeid,fen);
		// 查看该课程是否存在
		Course cos = courseServiceImpl.selectCourse(course);
		if(cos == null) {
			int cs= courseInfoServiceImpl.addCourseInfo(courseinfo);
			int rs = courseServiceImpl.addCourse(course);
			if(rs > 0) {
				request.setAttribute("message", "添加成功！");
				courseFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "添加失败！");
				request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "该课程已存在，请重新添加！");
			request.getRequestDispatcher("admin/addCourse.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
