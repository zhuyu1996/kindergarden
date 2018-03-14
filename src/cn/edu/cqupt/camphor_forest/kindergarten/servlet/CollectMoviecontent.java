package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectMovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;

/**
 * Servlet implementation class CollectMoviecontent
 */
@WebServlet("/CollectMoviecontent")
public class CollectMoviecontent extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollectMovieserviceImpl collectMovieserviceImpl=new CollectMovieserviceImpl();
		String userid=request.getParameter("userid");
		System.out.println(userid);
		try {
			CollectMovie collectMovie=collectMovieserviceImpl.showcollectMcontentAp(userid);
			response.getWriter().print(JsonUtil.EntityToJson(collectMovie));
		
		} catch (Exception e) {
			response.getWriter().print("显示失败");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
