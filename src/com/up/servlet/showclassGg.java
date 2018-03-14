package com.up.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.dao.AllDao;
import com.up.entity.News;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class showclassGg
 */
@WebServlet("/showclassGg")
public class showclassGg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showclassGg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String A=request.getParameter("pagenum");
		String cid=request.getParameter("cid");
		int pagenum=Integer.parseInt(A);
		AllDao alldao=new AllDao();
		try {
			List<News>news=alldao.showclassGg(cid, pagenum);
		response.getWriter().print(jsonUtil.EntityToJson(news));
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("cuowu");
			JSONObject p=new JSONObject();
			p.element("false", "false");
			response.getWriter().print(p);
		
			System.out.println("失败");
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
