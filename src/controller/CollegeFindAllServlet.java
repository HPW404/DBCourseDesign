package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CollegeServiceImpl;
import model.PageBean;

@WebServlet("/CollegeFindAllServlet")
public class CollegeFindAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CollegeServiceImpl collegeServiceImpl = new CollegeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int pageNo = 1;
		int pageCount = 10;
		String pageNoStr = request.getParameter("pageNo");
		String pageCountStr = request.getParameter("pageCount");
		
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		if(pageCountStr != null) {
			pageCount = Integer.parseInt(pageCountStr);
		}
		
		PageBean list = collegeServiceImpl.collegePageList(pageNo, pageCount);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/collegeAllInfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
