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
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;

/**
 * Servlet implementation class MovieShowWeb
 */
@WebServlet("/MovieShowWeb")
public class MovieShowWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieserviceImpl movieserviceImpl=new MovieserviceImpl();
		String pageNum=request.getParameter("pageNum");
		String mcid=request.getParameter("MCid");
		int pageNumi=Integer.parseInt(pageNum);
		System.out.println("Mcid="+mcid);
		System.out.println(pageNumi);
		try {
				Paging movielist=movieserviceImpl.appearMovieW(pageNumi,mcid);
				response.getWriter().print(JsonUtil.EntityToJson(movielist));
				
				System.out.println("显示成功");
		} catch (Exception e) {
			response.getWriter().print("显示失败");
			System.out.println("显示失败");
			
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
