package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Studentserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;
/**
 * Servlet implementation class StudentDlete
 */
@WebServlet("/StudentDlete")
public class StudentDlete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDlete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studentserviceimpl studentserviceimpl=new Studentserviceimpl();
		String sid=request.getParameter("sid");
		
		if(sid==null){
			response.getWriter().println("删除失败，送过来的是null");
		}else{
			String[] sidd=sid.split(",");
		System.out.println(sid);
		try {
			studentserviceimpl.delestudents(sidd);
			response.getWriter().print("true");
	    	   //刷新，显示修改后的所有数据
//			List<Student> liststudent=studentserviceimpl.selectAll();
//			response.getWriter().print(JsonUtil.EntityToJson(liststudent));
		} catch (SQLException e) {
			response.getWriter().print("false");
		}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
