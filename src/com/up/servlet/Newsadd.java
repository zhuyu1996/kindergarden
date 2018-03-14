package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.entity.News;
import com.up.serviceImpl.AllServiceImpl;

import net.sf.json.JSONObject;




/**
 * Servlet implementation class Newsadd
 */
@WebServlet("/Newsadd")
public class Newsadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Newsadd() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllServiceImpl allserviceimpl=new AllServiceImpl();
		String add1=request.getParameter("NewsAdd");
		
		System.out.println(add1);
		News Newsadd=jsonUtil.getEntity(add1, News.class);
	System.out.println("打印添加的新闻"+Newsadd);
		if (Newsadd!=null) {
			try {
				allserviceimpl.insertNews(Newsadd);
				System.out.println(Newsadd);
				JSONObject p=new JSONObject();
				p.element("success", "success");
				response.getWriter().print(p);
				System.out.println("成功添加资讯");
		
			} catch (Exception e) {
				e.printStackTrace();

				JSONObject p=new JSONObject();
				p.element("false", "false");
				response.getWriter().print(p);
				System.out.println("添加失败");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
