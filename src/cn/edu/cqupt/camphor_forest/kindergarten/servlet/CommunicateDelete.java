package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CommunicateserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Communicate;

/**
 * Servlet implementation class CommunicateDelete
 */
@WebServlet("/CommunicateDelete")
public class CommunicateDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunicateserviceImpl communicateserviceimpl=new CommunicateserviceImpl();
		String comId=request.getParameter("ComId");
		try {
			communicateserviceimpl.delCom(comId);
			response.getWriter().println("删除成功");
			System.out.println("删除成功");
		} catch (Exception e) {
			response.getWriter().println("删除失败");
			System.out.println("删除失败");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
