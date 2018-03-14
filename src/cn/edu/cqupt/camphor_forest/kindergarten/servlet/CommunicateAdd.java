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
 * Servlet implementation class CommunicateAdd
 */
@WebServlet("/CommunicateAdd")
public class CommunicateAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommunicateserviceImpl communicateserviceimpl=new CommunicateserviceImpl();
		String communi=request.getParameter("CommuniJson");
		Communicate communicate=JsonUtil.getEntity(communi, Communicate.class);
		try {
			communicateserviceimpl.insCom(communicate);
			response.getWriter().println("添加成功");
			System.out.println("添加成功");
		} catch (Exception e) {
			response.getWriter().println("添加失败");
			System.out.println("添加失败");
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
