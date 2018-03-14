package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollePhoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPicTotal;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

/**
 * Servlet implementation class CollectPicTotal
 */
@WebServlet("/CollectPicTotal")
public class CollectPictureTotal extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CollePhoserviceImpl collePhoserviceImpl=new CollePhoserviceImpl();
		PictureserviceImpl pictureserviceImpl=new PictureserviceImpl();
		String pid=request.getParameter("pid");
		String pageNum=request.getParameter("pageNum");
		int pageNumi=Integer.parseInt(pageNum);
		System.out.println(pid+"   /   "+pageNumi);
		try {
			List<String> piclist=collePhoserviceImpl.showcollectPictotal(pid);
			List<Picture> picturelist=pictureserviceImpl.ashowPictureAp(piclist, pageNumi);
		    SiChanping<Picture> scp=new SiChanping<Picture>();
		    scp.setTime("");
		    scp.setT(picturelist);
		    List<SiChanping<Picture>> pic=new ArrayList<SiChanping<Picture>>();
		    pic.add(scp);
			if(picturelist.isEmpty()){response.getWriter().print("{\"result\":false}");}
			else{
				response.getWriter().print(JsonUtil.EntityToJson(pic));
			}
		} catch (Exception e) {
			response.getWriter().print("{\"result\":\"显示失败\"}");
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
