package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.GraduateServiceImpl;

@WebServlet("/GraduateDeleteServlet")
public class GraduateDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GraduateServiceImpl graduateServiceImpl = new GraduateServiceImpl();
	private GraduateFindAllServlet graduateFindAllServlet = new GraduateFindAllServlet();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int rs = graduateServiceImpl.deleteGraduate(userId);
		
		if(rs > 0) {
			request.setAttribute("message", "ɾ���ɹ���");
			graduateFindAllServlet.doGet(request, response);
		} else {
			request.setAttribute("message", "ɾ��ʧ�ܣ�");
			graduateFindAllServlet.doGet(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
