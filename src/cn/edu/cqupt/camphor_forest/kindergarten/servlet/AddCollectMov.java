package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ColleMovTalserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;

/**
 * Servlet implementation class AddCollectMov
 */
@WebServlet("/AddCollectMov")
public class AddCollectMov extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ColleMovTalserviceImpl movietotalserviceImpl=new ColleMovTalserviceImpl();
		String pictureid=request.getParameter("pictureid");
		String pmid=request.getParameter("pmid");
		System.out.println(pictureid+"/"+pmid);
		try {
			movietotalserviceImpl.addcollectMovtotal(pictureid, pmid);
			System.out.println("添加成功");
			response.getWriter().print("添加成功");
		} catch (Exception e) {
			response.getWriter().print("{\"result\":\"显示失败\"}");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
