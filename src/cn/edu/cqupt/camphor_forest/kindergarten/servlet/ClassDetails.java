package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

/**
 * Servlet implementation class ClassDetails
 */
@WebServlet("/ClassDetails")
public class ClassDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		String classid=request.getParameter("classid");
		try {
			List<Student> student=classserviceimpl.selectByClassId(classid);
			response.getWriter().print(JsonUtil.EntityToJson(student));

			System.out.println("ok");
			} catch (Exception e) {
				response.getWriter().println("false2");
				System.out.println("false");
			}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
