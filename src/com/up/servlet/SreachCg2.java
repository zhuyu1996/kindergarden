package com.up.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

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
 * Servlet implementation class SreachGgBC
 */
@WebServlet("/SreachCg2")
public class SreachCg2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SreachCg2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllServiceImpl allServiceImpl=new AllServiceImpl();
		
		String a=request.getParameter("pageNum");
		String issuer=request.getParameter("issuer");
		System.out.println("jinru");
		try {
			
			if(issuer!=null&& !issuer.equals("")){
			if(issuer.equals(new String(issuer.getBytes("GB2312"), "GB2312"))){ 
			System.out.println("1");
//			   issuer= new String(issuer.getBytes("GB2312"),"utf-8");  
			issuer=new String(URLDecoder.decode(issuer, "utf-8"));
			issuer=new String(URLDecoder.decode(issuer, "utf-8"));
			   }else if(issuer.equals(new String(issuer.getBytes("iso-8859-1"), "iso-8859-1"))){ 
			    System.out.println("2");
			    issuer = new String(issuer.getBytes("iso-8859-1"),"utf-8");
			   }else if(issuer.equals(new String(issuer.getBytes("UTF-8"), "UTF-8"))){  
			    System.out.println("3");
			    issuer = new String(issuer.getBytes("UTF-8"),"utf-8");   
			   }else if(issuer.equals(new String(issuer.getBytes("GBK"), "GBK"))){  
			    System.out.println("4");
			    issuer = new String(issuer.getBytes("GBK"),"utf-8");   
			   }
			}
			
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println(a+" "+ issuer);
		int pageNum=Integer.parseInt(a);
		System.out.println(pageNum+" "+issuer);
		
		try {
			List<News> news= allServiceImpl.showAllSaveNews(pageNum,issuer);
			System.out.println(news+"servlet news");
			response.getWriter().println(jsonUtil.EntityToJson(news));
			System.out.println("成功查询草稿");
	
		} catch (Exception e2) {
			// TODO: handle exception 
			e2.printStackTrace();
			String s="false";
			JSONObject p=new JSONObject();
			p.element("false", "false");
			response.getWriter().print(p);
		
			System.out.println("失败");
		}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
