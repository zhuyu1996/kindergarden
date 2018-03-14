package com.up.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.dao.ReplyDao;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class showallreply
 */
@WebServlet("/showallreply")
public class showallreply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showallreply() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("pageNum");
		String b=request.getParameter("idcomment");
		int pageNum=Integer.parseInt(a);
		int idcomment=Integer.parseInt(b);
		try {
			ReplyDao replyDao=new ReplyDao();
			List<com.up.entity.Reply> replys=replyDao.showAllReply(pageNum, idcomment);
			response.getWriter().println(jsonUtil.EntityToJson(replys));
		} catch (Exception e) {
			// TODO: handle exception
			JSONObject p1=new JSONObject();
			p1.element("false", "false");
			response.getWriter().print(p1);
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
