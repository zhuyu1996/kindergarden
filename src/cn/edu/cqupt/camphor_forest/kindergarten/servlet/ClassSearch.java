package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;

/**
 * Servlet implementation class ClassSearch
 */
@WebServlet("/ClassSearch")
public class ClassSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		
		String search=request.getParameter("classSearch");
		System.out.println(search);
	
		if(search!=null){
			try {
			Classs classs=classserviceimpl.searchclass(search);
			response.getWriter().print(JsonUtil.EntityToJson(classs));	
			System.out.println(classs);
			} catch (Exception e) {
				e.printStackTrace();
				response.getWriter().println("false2");
				System.out.println("false");
			}

		}else{response.getWriter().println("false1");}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
