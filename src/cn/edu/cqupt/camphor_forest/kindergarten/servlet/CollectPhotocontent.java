package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectPhotoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

/**
 * Servlet implementation class CollectPhotocontent
 */
@WebServlet("/CollectPhotocontent")
public class CollectPhotocontent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollectPhotoserviceImpl collectPhotoserviceImpl=new CollectPhotoserviceImpl();
		String userid=request.getParameter("userid");
		try {
			CollectPhoto collectPhoto=collectPhotoserviceImpl.showcollectpiccontentAp(userid);
			response.getWriter().print(JsonUtil.EntityToJson(collectPhoto));
		
		} catch (Exception e) {
			response.getWriter().print("显示失败");
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
