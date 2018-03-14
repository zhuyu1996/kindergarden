package com.up.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.serviceImpl.AllServiceImpl;

import net.sf.json.JSONObject;



/**
 * Servlet implementation class DeleteNews
 */
@WebServlet("/DeleteNews")
public class DeleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllServiceImpl allServiceImpl=new AllServiceImpl();
		String delete=request.getParameter("idnews");
		  int idnews = Integer.parseInt(delete);
		System.out.println(delete);
			try {
				allServiceImpl.deleteNews(idnews);

//				String s="success";
				JSONObject p=new JSONObject();
				p.element("success", "success");
				response.getWriter().print(p);
				System.out.println("成功");
		
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
				
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
