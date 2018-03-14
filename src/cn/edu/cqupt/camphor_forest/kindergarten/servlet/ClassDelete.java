package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Lessonserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;

/**
 * Servlet implementation class ClassDelete
 */
@WebServlet("/ClassDelete")
public class ClassDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		Lessonserviceimpl lessonviceimpl=new Lessonserviceimpl();
		String delete=request.getParameter("classDelete");
		System.out.println(delete);
		if(delete!=null){
			try {
			String cname=classserviceimpl.searchNameById(delete);
			lessonviceimpl.delLessonByclass(cname);
			classserviceimpl.deleteclass(delete);
			response.getWriter().print("ok");	
			System.out.println("ok");
			} catch (Exception e) {
				response.getWriter().println("false2");
				System.out.println("false");
			}

		}else{response.getWriter().println("false1");}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
