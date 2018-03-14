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
 * Servlet implementation class PictureContentShowAll
 */
@WebServlet("/PCShowApp")
public class PictureContentShowApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureContentserviceImpl picturecontent=new PictureContentserviceImpl();
		String teachercid=request.getParameter("cid");
		String pageNum=request.getParameter("pageNum");
		int pageNumi=Integer.parseInt(pageNum);
		System.out.println(teachercid+"/."+pageNum);
		try {
			List<PictureContent> picturecontentlist=picturecontent.showppiccontentAp(pageNumi,teachercid);
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
