package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PageBean;
import dao.impl.EmpBiz;

@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		EmpBiz empBiz = new EmpBiz();
		int pageNo = 1;
		int pageCount = 10;
		int totalPage = 0;
		String pageNoStr = request.getParameter("pageNo");
		String pageCountStr = request.getParameter("pageCount");
		String totalPageStr = request.getParameter("totalPage");
		
		if(totalPageStr != null) {
			totalPage = Integer.parseInt(totalPageStr);
		}
		
		if(pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
			if(pageNo == 0) {
				pageNo = 1;
			} else if(pageNo > totalPage || pageNo == totalPage) {
				pageNo = totalPage;
			}
		}
		
		if(pageCountStr != null) {
			pageCount = Integer.parseInt(pageCountStr);
		}
		
		PageBean pageBean = empBiz.listEmps(pageNo, pageCount);
		request.setAttribute("list", pageBean);
		request.getRequestDispatcher("admin/userAllInfo.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
