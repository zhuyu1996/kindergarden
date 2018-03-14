package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;

/**
 * Servlet implementation class ClassUpate
 */
@WebServlet("/ClassUpate")
public class ClassUpate extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public ClassUpate() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassserviceImpl classserviceimpl=new ClassserviceImpl();
		String update=request.getParameter("classUpdate");
		System.out.println("?????"+update);
		Classs classs=JsonUtil.getEntity(update, Classs.class);
		if(classs!=null){
				try {
					classserviceimpl.updateclass(classs);
					response.getWriter().print("ok");	
					System.out.println("ok");
					} catch (Exception e) {
						response.getWriter().println("false2");
						System.out.println("false");
					}
			
			

		}else{response.getWriter().println("收到的是null，不好意思啊");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
