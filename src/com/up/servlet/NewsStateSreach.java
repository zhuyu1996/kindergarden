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
import com.up.serviceImpl.NewsServiceImpl;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class NewsStateSreach
 */
@WebServlet("/NewsStateSreach")
public class NewsStateSreach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsStateSreach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsServiceImpl newserviceimpl=new NewsServiceImpl();
		
		String A=request.getParameter("A");
		String B=request.getParameter("B");
		String C=request.getParameter("C");
		String D=request.getParameter("D");
		String a=request.getParameter("pageNum");
		try {
			if(A!=null&& !A.equals("")){
			if(A.equals(new String(A.getBytes("GB2312"), "GB2312"))){ 
			System.out.println("1");
			   A= new String(A.getBytes("GB2312"),"utf-8");   
			   }else if(A.equals(new String(A.getBytes("iso-8859-1"), "iso-8859-1"))){ 
			    System.out.println("2");
			    A = new String(A.getBytes("iso-8859-1"),"utf-8");
			   }else if(A.equals(new String(A.getBytes("UTF-8"), "UTF-8"))){  
			    System.out.println("3");
			    A = new String(A.getBytes("UTF-8"),"utf-8");   
			   }else if(A.equals(new String(A.getBytes("GBK"), "GBK"))){  
			    System.out.println("4");
			    A = new String(A.getBytes("GBK"),"utf-8");   
			   }
			}
			if(B.equals(new String(B.getBytes("GB2312"), "GB2312"))){ 
				System.out.println("1");
//				   B = new String(B.getBytes("GB2312"),"utf-8");   
				B=new String(URLDecoder.decode(B, "utf-8"));
				B=new String(URLDecoder.decode(B, "utf-8"));
				   }else if(B.equals(new String(B.getBytes("iso-8859-1"), "iso-8859-1"))){ 
				    System.out.println("2");
				    B = new String(B.getBytes("iso-8859-1"),"utf-8");
				   }else if(B.equals(new String(B.getBytes("UTF-8"), "UTF-8"))){  
				    System.out.println("3");
				    B = new String(B.getBytes("UTF-8"),"utf-8");   
				   }else if(B.equals(new String(B.getBytes("GBK"), "GBK"))){  
				    System.out.println("4");
				    B = new String(B.getBytes("GBK"),"utf-8");   
				   }
			if(C.equals(new String(C.getBytes("GB2312"), "GB2312"))){ 
				System.out.println("1");
//				   C = new String(C.getBytes("GB2312"),"utf-8"); 
				C=new String(URLDecoder.decode(C, "utf-8"));
				C=new String(URLDecoder.decode(C, "utf-8"));
				   }else if(C.equals(new String(C.getBytes("iso-8859-1"), "iso-8859-1"))){ 
				    System.out.println("2");
				    C= new String(C.getBytes("iso-8859-1"),"utf-8");
				   }else if(C.equals(new String(C.getBytes("UTF-8"), "UTF-8"))){  
				    System.out.println("3");
				    C = new String(C.getBytes("UTF-8"),"utf-8");   
				   }else if(C.equals(new String(C.getBytes("GBK"), "GBK"))){  
				    System.out.println("4");
				    C = new String(C.getBytes("GBK"),"utf-8");   
				   }
			if(D.equals(new String(D.getBytes("GB2312"), "GB2312"))){ 
				System.out.println("1");
//				   D = new String(D.getBytes("GB2312"),"utf-8");  
				D=new String(URLDecoder.decode(D, "utf-8"));
				D=new String(URLDecoder.decode(D, "utf-8"));
				   }else if(D.equals(new String(D.getBytes("iso-8859-1"), "iso-8859-1"))){ 
				    System.out.println("2");
				    D = new String(D.getBytes("iso-8859-1"),"utf-8");
				   }else if(D.equals(new String(D.getBytes("UTF-8"), "UTF-8"))){  
				    System.out.println("3");
				    D = new String(D.getBytes("UTF-8"),"utf-8");   
				   }else if(D.equals(new String(D.getBytes("GBK"), "GBK"))){  
				    System.out.println("4");
				    D = new String(D.getBytes("GBK"),"utf-8");   
				   }
			
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			} 
		int pageNum=Integer.parseInt(a);
		System.out.println(A+" "+B+" "+C+" "+D);
			try {
				List <News> News=newserviceimpl.sreachNewsState(A, B, C, D,pageNum);
				response.getWriter().print(jsonUtil.EntityToJson(News));
			
				System.out.println("成功查询资讯");
		
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
