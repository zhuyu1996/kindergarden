package com.up.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.dao.CommentDao;

import net.sf.json.JSONObject;
import com.up.entity.Comment;
/**
 * Servlet implementation class showallcomment
 */
@WebServlet("/showallcomment")
public class showallcomment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showallcomment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String p=request.getParameter("pageNum");
	String w=request.getParameter("idnews");
	System.out.println(p+w);
	int idnews=Integer.parseInt(w);
	int pageNum=Integer.parseInt(p);
try {
	CommentDao commentDao=new CommentDao();
	List<Comment> a =commentDao.showAllComment(pageNum,idnews);
	System.out.println(a);
	response.getWriter().print(jsonUtil.EntityToJson(a));
	
} catch (Exception e) {
		// TODO: handle exception
		JSONObject p1=new JSONObject();
		p1.element("false", "false");
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
