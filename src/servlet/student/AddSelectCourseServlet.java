package servlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SelectedCourse;
import service.Impl.SelectedCourseServiceImpl;

public class AddSelectCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SelectedCourse selectedCourse;
	private SelectedCourseServiceImpl selectedCourseServiceImpl = new SelectedCourseServiceImpl();
	private CourseSelectedShowServlet selectedCourseShowServlet = new CourseSelectedShowServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int courseId = Integer.parseInt(request.getParameter("courseId"));
		int studentId = Integer.parseInt((String)request.getSession().getAttribute("userName"));
		selectedCourse = new SelectedCourse(courseId, studentId);
		// �ж��Ƿ���ѡ�ÿγ�
		SelectedCourse sCourse = selectedCourseServiceImpl.selectSelectedCourse(selectedCourse);
		if(sCourse == null) {
			int rs = selectedCourseServiceImpl.addSelectedCourse(selectedCourse);
			if(rs > 0) {
				request.setAttribute("message", "��ӳɹ���");
				selectedCourseShowServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "���ʧ�ܣ�");
				request.getRequestDispatcher("student/stuCourSelect.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "�ÿγ���ѡ��");
			request.getRequestDispatcher("student/stuCourSelect.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}

