package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CommunicateserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Communicate;

/**
 * Servlet implementation class CommunicateShow
 */
@WebServlet("/CommunicateShow")
public class CommunicateShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunicateserviceImpl communicateserviceimpl=new CommunicateserviceImpl();
		String xId=request.getParameter("XId");
		try {
			List<Communicate> comlist=communicateserviceimpl.seltcom(xId);
			response.getWriter().println(JsonUtil.EntityToJson(comlist));
			System.out.println("显示成功");
		} catch (Exception e) {
			response.getWriter().println("显示失败");
			System.out.println("显示失败");
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
