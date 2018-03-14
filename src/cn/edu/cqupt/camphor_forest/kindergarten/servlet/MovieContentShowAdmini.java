package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieContentservieImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;

/**
 * Servlet implementation class MovieContentShowAdmini
 */
@WebServlet("/MCShowAdmini")
public class MovieContentShowAdmini extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieContentservieImpl moviecontentservieimpl=new MovieContentservieImpl();
		String pageNum=request.getParameter("pageNum");
		int pageNumi=Integer.parseInt(pageNum);
		try {
			Paging paging=moviecontentservieimpl.showMCByAdmi(pageNumi);
			response.getWriter().println(jsonUtil.EntityToJson(paging));
		} catch (Exception e) {
			response.getWriter().println("显示失败");
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
