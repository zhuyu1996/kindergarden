package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCUtils;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;

/**
 * Servlet implementation class ClassAdd
 */
@WebServlet("/ClassAdd")
public class ClassAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		String add=request.getParameter("classAdd");
		System.out.println(add);
		Classs classs=JsonUtil.getEntity(add, Classs.class);
		if(classs!=null){
			if(!classserviceimpl.isexit(classs.getcName())){   //班级名不重复
				try {
			classserviceimpl.insertclass(classs);
			response.getWriter().print("ok");	
			System.out.println("ok");
				
			} catch (Exception e) {
				response.getWriter().println("false");
				System.out.println("函数出错");
			}
			}else{response.getWriter().println("班级名重复");}
			
		}else{response.getWriter().println("发给我的是空");}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
