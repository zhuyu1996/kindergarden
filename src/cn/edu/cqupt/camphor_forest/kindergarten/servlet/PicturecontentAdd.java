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
 * Servlet implementation class PicturecontentAdd
 */
@WebServlet("/PcAdd")
public class PicturecontentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureContentserviceImpl picturecontent=new PictureContentserviceImpl();
		String PicContent=request.getParameter("PictureContentJson");
		PictureContent pic=JsonUtil.getEntity(PicContent, PictureContent.class);
		System.out.println(pic.toString());
		try {
				picturecontent.crePicContent(pic);
				response.getWriter().print("增加成功");
		
		} catch (Exception e) {
			response.getWriter().print("增加失败");
			System.out.println("增加失败");
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
