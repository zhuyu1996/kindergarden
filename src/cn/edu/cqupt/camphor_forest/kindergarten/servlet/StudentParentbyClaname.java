package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.StudentDao;
import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.StudentDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Studentserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

/**
 * Servlet implementation class StudentParentbyClaname
 */
@WebServlet(name = "StudentParent", urlPatterns = { "/StudentParent" })
public class StudentParentbyClaname extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studentserviceimpl studentdao=new Studentserviceimpl();
		String classname=request.getParameter("classname");
		try {
			List<Student> student=studentdao.selectByClassNa(classname);
			response.getWriter().print(JsonUtil.EntityToJson(student));

			System.out.println("ok");
			} catch (Exception e) {
				response.getWriter().println("false2");
				System.out.println("false");
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
