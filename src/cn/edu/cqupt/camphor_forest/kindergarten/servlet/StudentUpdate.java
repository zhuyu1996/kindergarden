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
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/StudentUpdate")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studentserviceimpl studentserviceimpl=new Studentserviceimpl();
		String StudentJson=request.getParameter("StudentJson");
		System.out.println(StudentJson);
		Student student = JsonUtil.getEntity(StudentJson, Student.class);
//		boolean result=true;
//		String s[]=student.getsAcount().split(":");
//		for(int i=1;i<s.length;i++){
//			if(result==true){
//				String one=s[i];
//				String b=one.substring(0, 11);
//			if(!studentserviceimpl.isexit(b)){
//				
//				result=false;
//			}
//			}
//		}
//		System.out.println(result);
//        if(result){
       try {
    	   //修改
    	   studentserviceimpl.updstudent(student);
    	   //刷新，显示删除后的所有数据
		List<Student> listStudent=studentserviceimpl.selectAll();
		response.getWriter().print(JsonUtil.EntityToJson(listStudent));
	} catch (SQLException e) {
		response.getWriter().println("false");
	}//}else{
	//	response.getWriter().print("某个用户已存在");
		
	}
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
