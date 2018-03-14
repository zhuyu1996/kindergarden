package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;

/**
 * Servlet implementation class ClassShow
 */
@WebServlet("/ClassShow")
public class ClassShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("显示班级");
		   ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		  try {
			List<Classs> classs=classserviceimpl.classshow();
			response.getWriter().print(JsonUtil.EntityToJson(classs));	
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			response.getWriter().println("false2");

		} 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
