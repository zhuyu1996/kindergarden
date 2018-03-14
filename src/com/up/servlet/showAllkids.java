package com.up.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.dao.kidsDao;
import com.up.entity.Kids;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class showAllkids
 */
@WebServlet("/showAllkids")
public class showAllkids extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showAllkids() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{kidsDao kidsdao=new kidsDao();
		
		List<Kids>kids=kidsdao.showall();
		System.out.println(kids);
		response.getWriter().println(jsonUtil.EntityToJson(kids));
		
		System.out.println("成功查询");
		
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
