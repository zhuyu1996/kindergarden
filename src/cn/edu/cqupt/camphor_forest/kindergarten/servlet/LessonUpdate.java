package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Lessonserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class LessonUpdate
 */
@WebServlet("/LessonUpdate")
public class LessonUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Lessonserviceimpl lessonserviceimpl=new Lessonserviceimpl();
        String lessonJson=request.getParameter("lessonJson");
        System.out.println(lessonJson);
        Lesson lesson=JsonUtil.getEntity(lessonJson, Lesson.class);
       System.out.println(lesson.toString());
        try {
            lessonserviceimpl.updLesson(lesson);
            response.getWriter().println("true");
 	   } catch (Exception e) {
 			// TODO: handle exception 
			e.printStackTrace();
			String s="false";
			JSONObject p=new JSONObject();
			p.element("false", s);
			response.getWriter().print(p);
			System.out.println("失败");
   	}
        
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
