package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Graduate;
import service.Impl.GraduateServiceImpl;

public class GraduateEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Graduate graduate;
	private GraduateServiceImpl graduateServiceImpl = new GraduateServiceImpl();
	private GraduateFindAllServlet graduateFindAllServlet = new GraduateFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		String userName = request.getParameter("userName");
		String sex = request.getParameter("sex");
		Date birthYear = null;
		try {
			birthYear = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int collegeId = Integer.parseInt(request.getParameter("collegeId"));
		Date graduateTime = null;
		try {
			graduateTime = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("graduateTime"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	        // 获得SimpleDateFormat类
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	        String SbirthYear=sf.format(birthYear);
	        String Sgrade=sf.format(grade);
	        String SgraduateTime=sf.format(graduateTime);

		
		graduate = new Graduate(userId, userName, sex, birthYear, grade, collegeId, graduateTime);
		int rs = graduateServiceImpl.editGraduate(graduate, SbirthYear, Sgrade, SgraduateTime);
		if(rs > 0) {
			request.setAttribute("message", "修改成功！");
			graduateFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "修改失败！");
			request.getRequestDispatcher("admin/editGraduate.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
