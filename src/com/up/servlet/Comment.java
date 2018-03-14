package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.dao.CommentDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class Comment
 */
@WebServlet("/Comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name=request.getParameter("name");
		String message=request.getParameter("message");
		String a=request.getParameter("idnews");
		int idnews=Integer.parseInt(a);
		System.out.println(name+" "+message+" "+idnews);
		try {
			CommentDao commentDao=new CommentDao();
			if(commentDao.select(name,idnews)==null){
			commentDao.Commentadd(name, message, idnews);
			JSONObject p=new JSONObject();
			p.element("success", "success");
			response.getWriter().print(p);
			System.out.println("成功添加");}
			else{
				JSONObject p=new JSONObject();
				p.element("false", "用户已经评论过了");
				response.getWriter().print(p);
				}
			}catch (Exception e) {
			// TODO: handle exception
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
