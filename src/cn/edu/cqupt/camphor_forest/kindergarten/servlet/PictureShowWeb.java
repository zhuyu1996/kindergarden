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
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

/**
 * Servlet implementation class PictureShowWeb
 */
@WebServlet("/PictureShowWeb")
public class PictureShowWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureserviceImpl PictureserviceImpl=new PictureserviceImpl();
		String pid=request.getParameter("pid");
		String pageNum=request.getParameter("pageNum");
		System.out.println(pid+"   /   "+pageNum);
		int pageNumi=Integer.parseInt(pageNum);
		
		try {
			    Paging picturelist=PictureserviceImpl.showPicAllWeb(pid,pageNumi);
				System.out.println(JsonUtil.EntityToJson(picturelist));
				response.getWriter().print(JsonUtil.EntityToJson(picturelist));
				
		} catch (Exception e) {
			response.getWriter().print("显示失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
