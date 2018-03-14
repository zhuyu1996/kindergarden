package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollePhoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureserviceImpl;

/**
 * Servlet implementation class PictureDelete
 */
@WebServlet("/PictureDelete")
public class PictureDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PictureserviceImpl pictureserviceimpl=new PictureserviceImpl();
		CollePhoserviceImpl collePhoserviceImpl=new CollePhoserviceImpl();
		String xid = request.getParameter("Xidjson");
		String xidd[]=xid.split(",");
		try {
			pictureserviceimpl.delincepicture(xidd);
			collePhoserviceImpl.delpicture(xidd);
			
			response.getWriter().print("删除成功");
		} catch (Exception e) {
			response.getWriter().print("删除失败");
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
