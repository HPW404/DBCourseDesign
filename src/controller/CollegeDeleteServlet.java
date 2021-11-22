package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CollegeServiceImpl;

@WebServlet("/CollegeDeleteServlet")
public class CollegeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl();
	private CollegeFindAllServlet collegeFindAllServlet = new CollegeFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		int rs = collegeServiceImpl.deleteCollege(collegeId);
		
		if(rs > 0) {
			request.setAttribute("message", "É¾³ý³É¹¦£¡");
			collegeFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "É¾³ýÊ§°Ü£¡");
			collegeFindAllServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
