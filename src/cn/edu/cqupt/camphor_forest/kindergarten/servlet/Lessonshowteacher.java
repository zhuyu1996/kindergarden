package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Lessonserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;

@WebServlet("/Lessonshowteacher")
public class Lessonshowteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lessonserviceimpl lessondaoimol=new Lessonserviceimpl();
	    String lessonJson=request.getParameter("lessonJson");
	    System.out.println(lessonJson);
	    Lesson les=JsonUtil.getEntity(lessonJson,Lesson.class);
	    try {
	    	Lesson lesson=lessondaoimol.selTeacherLesson(les);
	    	if(lesson==null){response.getWriter().print("{\"result\":false}");}
			else{	response.getWriter().print(JsonUtil.EntityToJson(lesson));	}
		} catch (Exception e) {
		  e.printStackTrace();
		  response.getWriter().print("{\"result\":\"出错了\"}");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
