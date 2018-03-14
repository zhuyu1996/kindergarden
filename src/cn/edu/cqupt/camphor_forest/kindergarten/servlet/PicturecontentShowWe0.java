package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureContentserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

/**
 * Servlet implementation class PicturecontentShow
 */
@WebServlet("/PicturecontentShowWe0")
public class PicturecontentShowWe0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureContentserviceImpl picturecontent=new PictureContentserviceImpl();
		String pageNum=request.getParameter("pageNum");
		int pageNumi=Integer.parseInt(pageNum);
		try {
			List<PictureContent> picturecontentlist=picturecontent.showppiccontentWe(pageNumi);
			response.getWriter().print(JsonUtil.EntityToJson(picturecontentlist));
			
		} catch (Exception e) {
			response.getWriter().print("显示失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
