package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.dao.ReplyDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Reply
 */
@WebServlet("/Reply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("chatone");
		String b=request.getParameter("chattwo");
		String c=request.getParameter("idcomment");
		String message=request.getParameter("message");
		int idcomment=Integer.parseInt(c);
		try {
			ReplyDao replyDao=new ReplyDao();
			replyDao.Replyadd(a, b, message, idcomment);
			JSONObject p=new JSONObject();
			p.element("success", "success");
			response.getWriter().print(p);
			System.out.println("成功添加");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			JSONObject p=new JSONObject();
			p.element("false", "false");
			response.getWriter().print(p);
			System.out.println("添加失败");
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
