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
import net.sf.json.JSONObject;

/**
 * Servlet implementation class LessonAppShow
 */
@WebServlet("/LessonAppShow")
public class LessonAppShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LessonAppShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Lessonserviceimpl lessondaoimol=new Lessonserviceimpl();
		    String lessonId=request.getParameter("lessonIdJson");;
		    try {
		    	List<Lesson> lesson=lessondaoimol.selAppLesson(lessonId);
		    	response.getWriter().println(JsonUtil.EntityToJson(lesson));
			} catch (Exception e) {
		          
				  response.getWriter().print("{\"result\":\"出错了\"}");
				  e.printStackTrace();
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
