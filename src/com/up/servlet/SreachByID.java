package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.entity.News;
import com.up.serviceImpl.AllServiceImpl;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SreachByID
 */
@WebServlet("/SreachByID")
public class SreachByID extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SreachByID() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AllServiceImpl allServiceImpl=new AllServiceImpl();
		String a=request.getParameter("idnews");
		int idnews=Integer.parseInt(a);
		System.out.println("idnews"+idnews);
		try {
			News news=allServiceImpl.sreachByID(idnews);
			response.getWriter().println(JsonUtil.EntityToJson(news));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			String s="false";
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
