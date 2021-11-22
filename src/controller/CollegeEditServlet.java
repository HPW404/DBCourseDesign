package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.College;
import service.impl.CollegeServiceImpl;

@WebServlet("/CollegeEditServlet")
public class CollegeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private College college;
	private CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl();
	private CollegeFindAllServlet collegeFindAllServlet = new CollegeFindAllServlet();
	private CollegeFindOneServlet collegeFindOneServlet = new CollegeFindOneServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String collegeName = request.getParameter("collegeName");
		
		college = new College(collegeId, collegeName);
		int rs = collegeServiceImpl.editCollege(college);
		
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			collegeFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			collegeFindOneServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
