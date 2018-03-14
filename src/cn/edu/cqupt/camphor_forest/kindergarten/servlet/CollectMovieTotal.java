package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ColleMovTalserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;

/**
 * Servlet implementation class CollectMovTotal
 */
@WebServlet("/CollectMovTotal")
public class CollectMovieTotal extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ColleMovTalserviceImpl movietotalserviceImpl=new ColleMovTalserviceImpl();
		MovieserviceImpl movieserviceImpl=new MovieserviceImpl();
		String pageNum=request.getParameter("pageNum");
		String mcid=request.getParameter("mcid");
		int pageNumi=Integer.parseInt(pageNum);
		System.out.println(mcid);
		try {
				List<String> ovielist=movietotalserviceImpl.showcollectMovtal(mcid);

				List<Movie> movielist=movieserviceImpl.ashowcollecrMovieAp(ovielist, pageNumi);
				response.getWriter().print(JsonUtil.EntityToJson(movielist));
				
				System.out.println("显示成功");
		} catch (Exception e) {
			response.getWriter().print("[]");
			System.out.println("显示失败");
			
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
