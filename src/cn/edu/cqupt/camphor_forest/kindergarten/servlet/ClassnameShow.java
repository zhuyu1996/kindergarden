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

/**
 * Servlet implementation class ClassnameShow
 */
@WebServlet("/ClassnameShow")
public class ClassnameShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		try {
			List<String> liststring=classserviceimpl.showClassName();
			response.getWriter().println(JsonUtil.EntityToJson(liststring));
		} catch (Exception e) {
			response.getWriter().println("显示班级名失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
