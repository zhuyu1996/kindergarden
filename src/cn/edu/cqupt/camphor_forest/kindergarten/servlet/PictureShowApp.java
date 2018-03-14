package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

/**
 * Servlet implementation class PictureShowApp
 */
@WebServlet("/PictureShowApp")
public class PictureShowApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureserviceImpl PictureserviceImpl=new PictureserviceImpl();
		String pid=request.getParameter("pid");
		String pageNum=request.getParameter("pageNum");
		int pageNumi=Integer.parseInt(pageNum);
		System.out.println(pid+"   /   "+pageNumi);
		try {
			List<SiChanping<Picture>> picturelist=PictureserviceImpl.showPicAllApp(pid, pageNumi);
			if(picturelist.isEmpty()){response.getWriter().print("{\"result\":false}");}
			else{
				response.getWriter().print(JsonUtil.EntityToJson(picturelist));
			}
		} catch (Exception e) {
			response.getWriter().print("{\"result\":\"显示失败\"}");
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
