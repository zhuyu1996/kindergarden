package com.up.servlet;

import java.io.IOException;
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


/**
 * Servlet implementation class AllStateSreach
 */
@WebServlet("/AllStateSreach3")
public class AllStateSreach3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllStateSreach3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AllServiceImpl allServiceImpl=new AllServiceImpl();
		String A=request.getParameter("A");
		String B=request.getParameter("B");
		String C=request.getParameter("C");
		String D=request.getParameter("D");
		String E=request.getParameter("pageNum");System.out.println(E);
		int pageNumi=Integer.parseInt(E);
		
		System.out.println(A+" "+B+" "+C+" "+D+" "+pageNumi);
			try {
				List <News> News=allServiceImpl.sreachAllState(A, B, C, D,pageNumi);
				response.getWriter().print(jsonUtil.EntityToJson(News));
               System.out.println(News);
				System.out.println("成功查询资讯");
		
			} catch (Exception e) {
				// TODO: handle exception 
				e.printStackTrace();
//				response.getWriter().println(" false");
				
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
