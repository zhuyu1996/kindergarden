package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Lessonserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Lesson;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class LessonAddteacher
 */
@WebServlet("/LessonAddteacher")
public class LessonAddteacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lessonserviceimpl lessondaoimpl=new Lessonserviceimpl();
		String lessonInJson=request.getParameter("lessonInJson");
		System.out.println(lessonInJson);
		Lesson lesson=JsonUtil.getEntity(lessonInJson,Lesson.class);
		try {
			lessondaoimpl.insLessonteacher(lesson);
			
			String s="success";
			JSONObject p=new JSONObject();
			p.element("success", s);
			response.getWriter().print(p);
			System.out.println("成功");

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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
