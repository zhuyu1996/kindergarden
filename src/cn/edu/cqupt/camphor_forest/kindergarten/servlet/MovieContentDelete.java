package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieContentservieImpl;

/**
 * Servlet implementation class MovieContentDelete
 */
@WebServlet("/MovieContentDelete")
public class MovieContentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieContentservieImpl moviecontentservieimpl=new MovieContentservieImpl();
		String mcid=request.getParameter("mcJson");
		System.out.println(mcid);
		String[] mcidd=mcid.split(",");
		System.out.println(mcidd);
		try {
			moviecontentservieimpl.delMovieContent(mcidd);
			response.getWriter().print("删除成功");
			System.out.println("删除成功");
		} catch (Exception e) {
			response.getWriter().print("删除失败");
			System.out.println("删除失败");
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
