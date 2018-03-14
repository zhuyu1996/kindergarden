package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.Teatherservice;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Teatherserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;

/**
 * Servlet implementation class TeacherUpdate
 */
@WebServlet("/TeacherUpdate")
public class TeacherUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Teatherservice teacherservice=new Teatherserviceimpl();
		String TeacherJson=request.getParameter("TeacherJson");
       Teacher teacher = JsonUtil.getEntity(TeacherJson, Teacher.class);
       System.out.println(TeacherJson);
//       if(teacherservice.ifexit(teacher.gettPhone())){
       try {
    	   //修改
		teacherservice.updteacher(teacher);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		response.getWriter().println("false");}
//	}else{
// 	   response.getWriter().print("用户已存在");}
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
