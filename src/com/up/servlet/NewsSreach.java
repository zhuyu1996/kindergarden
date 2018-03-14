package com.up.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
;

/**
 * Servlet implementation class NewsSreach
 */
@WebServlet("/NewsSreach")
public class NewsSreach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsSreach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllServiceImpl allServiceImpl=new AllServiceImpl();
		String title=request.getParameter("title");
		String time=request.getParameter("time");
		String issuer=request.getParameter("issuer"); 
		try {
			if(title!=null&& !title.equals("")){
			if(title.equals(new String(title.getBytes("GB2312"), "GB2312"))){ 
			System.out.println("1");
			   title= new String(title.getBytes("GB2312"),"utf-8");   
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
			}
			
			if(issuer!=null&& !issuer.equals("")){
			if(issuer.equals(new String(issuer.getBytes("GB2312"), "GB2312"))){ 
				System.out.println("1");
				   issuer = new String(issuer.getBytes("GB2312"),"utf-8");   
				   }else if(issuer.equals(new String(issuer.getBytes("iso-8859-1"), "iso-8859-1"))){ 
				    System.out.println("2");
				    issuer= new String(issuer.getBytes("iso-8859-1"),"utf-8");
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
			} 
	
		String a=request.getParameter("pageNum");
		int pageNum=Integer.parseInt(a);
		System.out.println(" + "+title+" + "+time+" + "+issuer);
			try {
				List <News> News=allServiceImpl.NewsSreach(title, time, issuer,pageNum);
				response.getWriter().print(jsonUtil.EntityToJson(News));
				System.out.println("成功查询资讯");
		
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();

				JSONObject p=new JSONObject();
				p.element("false","false");
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
