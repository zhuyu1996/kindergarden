package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieserviceImpl;


/**
 * Servlet implementation class MovieShowWeb
 */
@WebServlet("/MovieDelete")
public class MovieDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieserviceImpl movieserviceImpl=new MovieserviceImpl();
		String mvid=request.getParameter("mvid");
		String[] mvids=mvid.split(",");
		System.out.println(mvid);
		System.out.println(mvids[0]);
		try {
				movieserviceImpl.declineMovie(mvids);
				response.getWriter().print("删除成功");
				System.out.println("删除成功");
		} catch (Exception e) {
			response.getWriter().print("删除失败");
			System.out.println("删除失败");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
