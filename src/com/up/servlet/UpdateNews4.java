package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.serviceImpl.AllServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateNews4
 */
@WebServlet("/UpdateNews4")
public class UpdateNews4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNews4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 用于解决教育随笔UPdateNews 前端跨域的问题
		AllServiceImpl allServiceImpl=new AllServiceImpl();

		String a=request.getParameter("idnews");
		String title=request.getParameter("title");
		String message=request.getParameter("message");
		String url1=request.getParameter("url1");
		String url2=request.getParameter("url2");
		System.out.println(a+"+"+title+"+" +message+" +"+url1+" +"+url2);
		int idnews=Integer.parseInt(a);
		try {
			int b=allServiceImpl.update(idnews,title,message,url1,url2);
		JSONObject p= new JSONObject();
		p.element("修改条数", b);
		response.getWriter().println(p);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JSONObject p= new JSONObject();
			p.element("false", "false");
			response.getWriter().println(p);
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
