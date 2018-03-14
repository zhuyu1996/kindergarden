package com.up.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;
import com.up.entity.News;
import com.up.serviceImpl.AllServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class UpdateNews
 */
@WebServlet("/UpdateNews")
public class UpdateNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			AllServiceImpl allServiceImpl=new AllServiceImpl();

			String a=request.getParameter("idnews");
			String title=request.getParameter("title");
			String message=request.getParameter("message");
			String url1=request.getParameter("url1");
			String url2=request.getParameter("url2");
		try {
				
				if(title.equals(new String(title.getBytes("GB2312"), "GB2312"))){ 
				System.out.println("GB2312");
//				   title= new String(title.getBytes("GB2312"),"utf-8");  
				   title = java.net.URLDecoder.decode(title,"utf-8");
				   title = java.net.URLDecoder.decode(title,"utf-8");
				   System.out.println("jiema");
				   System.out.println(title);
				   }else if(title.equals(new String(title.getBytes("iso-8859-1"), "iso-8859-1"))){ 
				    System.out.println("2");
				    title = new String(title.getBytes("iso-8859-1"),"utf-8");
				   }else if(title.equals(new String(title.getBytes("UTF-8"), "UTF-8"))){  
				    System.out.println("3");
				    title = new String(title.getBytes("UTF-8"),"utf-8");   
				   }else if(title.equals(new String(title.getBytes("GBK"), "GBK"))){  
				    System.out.println("4");
				    title = new String(title.getBytes("GBK"),"utf-8");   
				   }
				
				if(message.equals(new String(message.getBytes("GB2312"), "GB2312"))){ 
					System.out.println("GB2312");
//					   message = new String(message.getBytes("GB2312"),"utf-8"); 
					  message = java.net.URLDecoder.decode(message,"utf-8");
					 
					   }else if(message.equals(new String(message.getBytes("iso-8859-1"), "iso-8859-1"))){ 
					    System.out.println("2");
					    message = new String(message.getBytes("iso-8859-1"),"utf-8");
					   }else if(message.equals(new String(message.getBytes("UTF-8"), "UTF-8"))){  
					    System.out.println("3");
					    message = new String(message.getBytes("UTF-8"),"utf-8");   
					   }else if(message.equals(new String(message.getBytes("GBK"), "GBK"))){  
					    System.out.println("4");
					    message = new String(message.getBytes("GBK"),"utf-8");   
					   }
			
				if(url1.equals(new String(url1.getBytes("GB2312"), "GB2312"))){ 
					System.out.println("GB2312");
//					   url1 = new String(url1.getBytes("GB2312"),"utf-8"); 
					url1 = java.net.URLDecoder.decode(url1,"utf-8");
					   
					   }else if(url1.equals(new String(url1.getBytes("iso-8859-1"), "iso-8859-1"))){ 
					    System.out.println("2");
					    url1= new String(url1.getBytes("iso-8859-1"),"utf-8");
					   }else if(url1.equals(new String(url1.getBytes("UTF-8"), "UTF-8"))){  
					    System.out.println("3");
					    url1 = new String(url1.getBytes("UTF-8"),"utf-8");   
					   }else if(url1.equals(new String(url1.getBytes("GBK"), "GBK"))){  
					    System.out.println("4");
					    url1 = new String(url1.getBytes("GBK"),"utf-8");   
					   }
				if(url2.equals(new String(url2.getBytes("GB2312"), "GB2312"))){ 
					System.out.println("GB2312");
//					   url2 = new String(url2.getBytes("GB2312"),"utf-8"); 
					url2 = java.net.URLDecoder.decode(url2,"utf-8");
					   }else if(url2.equals(new String(url2.getBytes("iso-8859-1"), "iso-8859-1"))){ 
					    System.out.println("2");
					    url2 = new String(url2.getBytes("iso-8859-1"),"utf-8");
					   }else if(url2.equals(new String(url2.getBytes("UTF-8"), "UTF-8"))){  
					    System.out.println("3");
					    url2 = new String(url2.getBytes("UTF-8"),"utf-8");   
					   }else if(url2.equals(new String(url2.getBytes("GBK"), "GBK"))){  
					    System.out.println("4");
					    url2 = new String(url2.getBytes("GBK"),"utf-8");   
					   }
				
				} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				} 
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
