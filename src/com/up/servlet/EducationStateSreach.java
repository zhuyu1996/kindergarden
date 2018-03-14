package com.up.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;
import com.up.dao.EductionDao;
import com.up.entity.News;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class EducationStateSreach
 */
@WebServlet("/EducationStateSreach")
public class EducationStateSreach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EducationStateSreach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String title,String time,String issuer, int pageNum
		String title=request.getParameter("title");
		String time=request.getParameter("time");
		String issuer=request.getParameter("issuer");
		String a=request.getParameter("pageNum");
		int pageNum=Integer.parseInt(a);
		try {
			EductionDao eductionDao=new EductionDao();
			List<News>news=eductionDao.NewsSreach(title, time, issuer, pageNum);
			response.getWriter().print(jsonUtil.EntityToJson(news));
			System.out.println("success");
		} catch (Exception e) {
			// TODO: handle exception
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
