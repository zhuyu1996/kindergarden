package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.KaixueTimeserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.KaixueTime;

/**
 * Servlet implementation class KaixueShow
 */
@WebServlet("/KaixueShow")
public class KaixueShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
   		private KaixueTimeserviceImpl kaixueTimeserviceImpl=new KaixueTimeserviceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KaixueShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			KaixueTime kaixueTime=kaixueTimeserviceImpl.selectkaixuetime();
			response.getWriter().print(JsonUtil.EntityToJson(kaixueTime));	
	
		} catch (Exception e) {
			// TODO: handle exception
			response.getWriter().println("false2");
			System.out.println("false");
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
