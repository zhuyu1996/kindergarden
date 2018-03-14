package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.ClassserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Studentserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

/**
 * Servlet implementation class ClassUp
 */
@WebServlet("/ClassUp")
public class ClassUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ClassUp() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   System.out.println("升级班级");
	   ClassserviceImpl classserviceimpl=new ClassserviceImpl();
	   Studentserviceimpl studentserviceimpl=new Studentserviceimpl();
	  try {
		classserviceimpl.upclass();
	    List<Student> liststudent=studentserviceimpl.selectAll();
		response.getWriter().print("ok");	
		System.out.println("ok");
	} catch (Exception e) {
		response.getWriter().println("false2");
		System.out.println("false");
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
