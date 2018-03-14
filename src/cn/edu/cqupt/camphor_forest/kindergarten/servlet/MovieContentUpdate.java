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
 * Servlet implementation class MovieContentUpdate
 */
@WebServlet("/MovieContentUpdate")
public class MovieContentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieContentservieImpl moviecontentservieimpl=new MovieContentservieImpl();
		String moviecontentJson=request.getParameter("mcJson");
		MovieContent moviecontent=JsonUtil.getEntity(moviecontentJson, MovieContent.class);
		try {
			moviecontentservieimpl.updMovieContent(moviecontent);
			
			response.getWriter().print("修改成功");
			System.out.println("修改成功");
		} catch (Exception e) {
			response.getWriter().print("修改失败");
			System.out.println("修改失败");
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
