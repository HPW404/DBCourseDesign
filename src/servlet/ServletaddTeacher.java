package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Impl.TeacherServiceImpl;
import service.Impl.UserServiceImpl;

import model.Teacher;
import model.UserLogin;
import dao.Impl.TeacherDaoImpl;
import dao.Impl.UserDaoImpl;

public class ServletaddTeacher extends HttpServlet{


	private UserLogin user;
	private Teacher teacher;
	private UserServiceImpl userServiceImpl = new UserServiceImpl();
	private TeacherServiceImpl teacherServiceImpl =new TeacherServiceImpl();
	private ServletFindAllTea findTea=new ServletFindAllTea();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int teaID=Integer.valueOf(request.getParameter("teaId"));
		int teaNum = Integer.valueOf(request.getParameter("teaNum"));
		String teaName = request.getParameter("teaName");
		String pwd = request.getParameter("password");
		String teaSex = request.getParameter("teaSex");
		Date teaAge = null;
		try {
			teaAge = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthYear"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String degree = request.getParameter("degree");
		String title = request.getParameter("title");
		Date grade = null;
		try {
			grade = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("grade"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int collegeID = Integer.parseInt(request.getParameter("collegeID"));
		int roleID = 1;
		String Steanum=String.valueOf(teaNum);
		user = new UserLogin(teaID,Steanum, pwd, roleID);
		
		teacher = new Teacher(teaNum, teaName, teaSex, teaAge, degree, title,
				grade,collegeID);
		//验证是否存在该教师
		UserLogin rs =new UserLogin();
		rs=userServiceImpl.login(user);
		
		
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        String SteaAge=sf.format(teaAge);
        String Sgrade=sf.format(grade);
        System.out.println(SteaAge);
		
		if(rs==null){
			int rsUser=userServiceImpl.addUser(user);
			int rsTea=teacherServiceImpl.addTeacher(teacher,SteaAge,Sgrade);
			if(rsTea>0 && rsUser>0){
				request.setAttribute("msg", "添加成功！！");
				findTea.doGet(request, response);
			//	request.getRequestDispatcher("admin/teacherAllInfo.jsp").forward(request, response);
				/*List list=studentDaoImpl.findAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("admin/studentAllInfo.jsp").forward(request, response);*/
			}else{
				request.setAttribute("msg", "添加失败！！");
				request.getRequestDispatcher("admin/addTeacher.jsp").forward(request, response);
			}
		}else{
			request.setAttribute("msg", "该工号已存在，请重新录入！！");
			request.getRequestDispatcher("admin/addTeacher.jsp").forward(request, response);
		}
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}
