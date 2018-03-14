package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.Teatherservice;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Teatherserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;

/**
 * Servlet implementation class TeacherByClass
 */
@WebServlet("/TeacherByClass")
public class TeacherByClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teatherservice teacherservice=new Teatherserviceimpl();
		String classid=request.getParameter("classid");
		System.out.println(classid);
		try {
			List<Teacher> Teacher=teacherservice.steacherByClass(classid);
			response.getWriter().print(JsonUtil.EntityToJson(Teacher));

			System.out.println("ok");
			} catch (Exception e) {
				response.getWriter().println("false2");
				System.out.println("false");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
