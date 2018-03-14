package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.entity.News;
import com.up.serviceImpl.GrowthServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GrowthAdd
 */
@WebServlet("/GrowthAdd")
public class GrowthAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GrowthAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			GrowthServiceImpl growthServiceImpl =new GrowthServiceImpl();
		String add1=request.getParameter("NewsAdd");
		
		System.out.println(add1);
		News Newsadd=jsonUtil.getEntity(add1, News.class);
	
		if (Newsadd!=null) {
			try {
				growthServiceImpl.insertRecord(Newsadd);
//				String s="success";
				JSONObject p=new JSONObject();
				p.element("success", "success");
				response.getWriter().print(p);
				System.out.println("成功添加资讯");
		
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
//				String s="false";
				JSONObject p=new JSONObject();
				p.element("false", "false");
				response.getWriter().print(p);
				System.out.println("添加失败");
			}
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
