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
import com.up.Util.jsonUtil;
import com.up.entity.News;
import com.up.serviceImpl.AllServiceImpl;
import com.up.serviceImpl.GgServiceImpl;
import com.up.serviceImpl.NewsServiceImpl;

import net.sf.json.JSONObject;


/**
 * Servlet implementation class StateChange
 */
@WebServlet("/StateChange")
public class StateChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StateChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllServiceImpl allServiceImpl=new AllServiceImpl();
		
		String a=request.getParameter("idnews");
		String state=request.getParameter("state");
		try {
			if(state!=null&& !state.equals("")){
			if(state.equals(new String(state.getBytes("GB2312"), "GB2312"))){ 
			System.out.println("1");
//			   state= new String(state.getBytes("GB2312"),"utf-8"); 
			state=new String(URLDecoder.decode(state, "utf-8"));
			state=new String(URLDecoder.decode(state, "utf-8"));
			   }else if(state.equals(new String(state.getBytes("iso-8859-1"), "iso-8859-1"))){ 
			    System.out.println("2");
			    state = new String(state.getBytes("iso-8859-1"),"utf-8");
			   }else if(state.equals(new String(state.getBytes("UTF-8"), "UTF-8"))){  
			    System.out.println("3");
			    state = new String(state.getBytes("UTF-8"),"utf-8");   
			   }else if(state.equals(new String(state.getBytes("GBK"), "GBK"))){  
			    System.out.println("4");
			    state = new String(state.getBytes("GBK"),"utf-8");   
			   }
			}
			
			} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			} 
		int idnews=Integer.parseInt(a);
		
		try {
			int change= allServiceImpl.changeState(idnews, state);
			
			String s="success";
			JSONObject p=new JSONObject();
			p.element("success", "success");
			response.getWriter().print(p);
			
		
//			response.getWriter().println("修改状态"+change+"条");
			System.out.println("修改状态"+ change+"条");
	
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
