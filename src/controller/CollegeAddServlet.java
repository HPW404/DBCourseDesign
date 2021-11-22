package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CollegeServiceImpl;
import model.College;

@WebServlet("/CollegeAddServlet")
public class CollegeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private College college;
	private CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl();
	private CollegeFindAllServlet collegeFindAllServlet = new CollegeFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String collegeName = request.getParameter("collegeName");
		
		college = new College(collegeId, collegeName);
		// �鿴��ѧԺ�Ƿ����
		College col = collegeServiceImpl.selectCollege(college);
		if(col == null) {
			int rs = collegeServiceImpl.addCollege(college);
			if(rs > 0) {
				request.setAttribute("message", "��ӳɹ���");
				collegeFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "���ʧ�ܣ�");
				request.getRequestDispatcher("admin/addCollege.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "��ѧԺ�Ѵ��ڣ���������ӣ�");
			request.getRequestDispatcher("admin/addCollege.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
