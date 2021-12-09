package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Graduate;
import service.Impl.GraduateServiceImpl;

public class GraduateFindOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GraduateServiceImpl graduateServiceImpl = new GraduateServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("granum"));
		List<Graduate> list = graduateServiceImpl.findOne(userId);
		request.setAttribute("list", list);
		request.getRequestDispatcher("admin/editGraduate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
