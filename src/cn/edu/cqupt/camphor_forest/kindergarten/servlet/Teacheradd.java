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
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectMovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectPhotoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Teatherserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;

/**
 * Servlet implementation class Teacheradd
 */
@WebServlet("/Teacheradd")
public class Teacheradd extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacheradd() {
        super();
    }
     //添加   用id判断是否重复存在老师
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Teatherservice teacherservice=new Teatherserviceimpl();
	    CollectMovieserviceImpl collectMovieserviceImpl=new CollectMovieserviceImpl();
	    CollectPhotoserviceImpl collectPhotoserviceImpl=new CollectPhotoserviceImpl();
		String TeacherJson=request.getParameter("TeacherJson");
		System.out.println(TeacherJson);
       Teacher teacher = JsonUtil.getEntity(TeacherJson, Teacher.class);
       CollectMovie collectmovie=new CollectMovie();
       CollectPhoto collectPhoto=new CollectPhoto();
       if(teacherservice.ifexit(teacher.gettPhone())){
       
       try {
			  String teaid=teacherservice.addteacher(teacher);
			  System.out.println("teaid"+teaid);
		      collectmovie.setCmuserid(teaid);
		      collectMovieserviceImpl.addcollectmovie(collectmovie);
		      collectPhoto.setCpuserid(teaid);
		      collectPhotoserviceImpl.addcollecphoto(collectPhoto);
		      response.getWriter().print("ok");
	} catch (SQLException e) {
		 response.getWriter().print("false");}
       }else{
    	   response.getWriter().print("用户已存在");}
       }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
