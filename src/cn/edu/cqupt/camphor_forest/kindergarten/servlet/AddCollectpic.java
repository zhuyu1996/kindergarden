package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollePhoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPicTotal;

/**
 * Servlet implementation class AddCollectpic
 */
@WebServlet("/AddCollectpic")
public class AddCollectpic extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollePhoserviceImpl PictureserviceImpl=new CollePhoserviceImpl();
		String pictureid=request.getParameter("pictureid");
		String pmid=request.getParameter("pmid");
		System.out.println(pictureid+"  1  234  "+pmid);
		
		try {
			PictureserviceImpl.addcollectPictotal(pictureid, pmid);
			response.getWriter().print("添加成功");
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
