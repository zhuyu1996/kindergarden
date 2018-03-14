package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.dao.AllDao;
import com.up.dao.kidsDao;
import com.up.entity.Kids;
import com.up.entity.News;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Addkids
 */
@WebServlet("/Addkids")
public class Addkids extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addkids() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
String add1=request.getParameter("Addkids");
		
		System.out.println(add1);
		Kids Kidsadd=jsonUtil.getEntity(add1, Kids.class);
	System.out.println("打印添加"+Kidsadd);
		if (Kidsadd!=null) {
			try {
				kidsDao kidsdao=new kidsDao();
				if(kidsdao.checkkids(Kidsadd)==null){
					kidsdao.add(Kidsadd);
					JSONObject p=new JSONObject();
					p.element("success", "success");
					response.getWriter().print(p);
					System.out.println("成功添加资讯");
				

					
				}
					else{
						JSONObject p=new JSONObject();
						p.element("false", "用户已经存在");
						response.getWriter().print(p);
						System.out.println("添加失败");}
				
		
			} catch (Exception e) {
				e.printStackTrace();

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
