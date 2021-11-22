package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CourseInfoServiceImpl;
import model.CourseInfo;

@WebServlet("/CourseInfoAddServlet")
public class CourseInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CourseInfo courseInfo;
	private CourseInfoServiceImpl courseInfoServiceImpl = new CourseInfoServiceImpl();
	private CourseInfoFindAllServlet courseInfoFindAllServlet = new CourseInfoFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		int courseWeek = Integer.parseInt(request.getParameter("courseWeek"));
		String courseType = request.getParameter("courseType");
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		int score = Integer.parseInt(request.getParameter("score"));
		
		courseInfo = new CourseInfo(courseId, courseName, courseWeek, courseType, collegeId, score);
		// �鿴�ÿγ���Ϣ�Ƿ����
		CourseInfo cos = courseInfoServiceImpl.selectCourseInfo(courseInfo);
		if(cos == null) {
			int rs = courseInfoServiceImpl.addCourseInfo(courseInfo);
			if(rs > 0) {
				request.setAttribute("message", "��ӳɹ���");
				courseInfoFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "���ʧ�ܣ�");
				request.getRequestDispatcher("admin/addCourseInfo.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "�ÿγ���Ϣ�Ѵ��ڣ�������¼�룡");
			request.getRequestDispatcher("admin/addCourseInfo.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
