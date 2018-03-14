package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieContentservieImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;

/**
 * Servlet implementation class MovieContentAdd
 */
@WebServlet("/MovieContentAdd")
public class MovieContentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieContentservieImpl moviecontentservieimpl=new MovieContentservieImpl();
		String moviecontentJson=request.getParameter("MCJson");
		MovieContent moviecontent=JsonUtil.getEntity(moviecontentJson, MovieContent.class);
		System.out.println(moviecontent.toString());
		try {
			moviecontentservieimpl.addMovieContent(moviecontent);
			response.getWriter().print("添加成功");
			System.out.println("添加成功");
		} catch (Exception e) {
			response.getWriter().print("添加失败");
			System.out.println("添加失败");
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
