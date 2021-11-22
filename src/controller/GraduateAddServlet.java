package controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.GraduateServiceImpl;
import model.Graduate;

@WebServlet("/GraduateAddServlet")
public class GraduateAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Graduate graduate;
	private GraduateServiceImpl graduateServiceImpl = new GraduateServiceImpl();
	private GraduateFindAllServlet graduateFindAllServlet = new GraduateFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birthYear");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String g = request.getParameter("grade");
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		String gTime = request.getParameter("graduateTime");
		Date graduateTime = null;
		try {
			graduateTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("graduateTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		graduate = new Graduate(userId, userName, sex, birthYear, grade, collegeId, graduateTime);
		// 查看该毕业生是否已经存在
		Graduate gra = graduateServiceImpl.selectGraduate(graduate);
		if(gra == null) {
			int rs = graduateServiceImpl.addGraduate(graduate, birth, g, gTime);
			if(rs > 0) {
				request.setAttribute("message", "添加成功！");
				graduateFindAllServlet.doGet(request, response);
			} else {
				request.setAttribute("message", "添加失败！");
				request.getRequestDispatcher("admin/addGraduate.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("message", "该毕业生已经存在，请重新录入！");
			request.getRequestDispatcher("admin/addGraduate.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
