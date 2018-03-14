package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureContentserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.PictureContent;

/**
 * Servlet implementation class PictureContentDlete
 */
@WebServlet("/PictureContentDlete")
public class PictureContentDlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureContentserviceImpl picturecontent=new PictureContentserviceImpl();
		String pid=request.getParameter("PidJson");
		try {
				picturecontent.delPicContent(pid);
				response.getWriter().print("删除成功");
		} catch (Exception e) {
			response.getWriter().print("删除失败");
			System.out.println("删除失败");
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
