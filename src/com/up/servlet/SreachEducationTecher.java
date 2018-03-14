package com.up.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.Junction;

import com.up.Util.jsonUtil;
import com.up.dao.EductionDao;
import com.up.entity.News;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class SreachEducationTecher
 */
@WebServlet("/SreachEducationTecher")
public class SreachEducationTecher extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SreachEducationTecher() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String a=request.getParameter("pageNum");
		String issuer=request.getParameter("issuer");
		int pageNum=Integer.parseInt(a);
		System.out.println(a+" "+issuer);
		try {
			EductionDao eductionDao=new EductionDao();
			List<News>news=eductionDao.sreachall(pageNum, issuer);
			response.getWriter().print(jsonUtil.EntityToJson(news));
			System.out.println("成功添加");
		} catch (Exception e) {
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
