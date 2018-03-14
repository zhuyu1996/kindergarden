package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;


/**
 * Servlet implementation class MovieShow
 */
@WebServlet("/MovieShowApp")
public class MovieShowApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieserviceImpl movieserviceImpl=new MovieserviceImpl();
		String pageNum=request.getParameter("pageNum");
		String classid=request.getParameter("MCid");
		int pageNumi=Integer.parseInt(pageNum);
		System.out.println(classid);
		try {
				List<Movie> ovielist=movieserviceImpl.appearMovieAp(pageNumi,classid);
				response.getWriter().print(JsonUtil.EntityToJson(ovielist));
				
				System.out.println("显示成功");
		} catch (Exception e) {
			response.getWriter().print("显示失败");
			System.out.println("显示失败");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
