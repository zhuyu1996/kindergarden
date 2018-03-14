package kindergarden.manager.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kindergarden.manager.domain.Manager;
import net.sf.json.JSONArray;


@WebServlet("/quitServlet")
public class quitServlet extends HttpServlet {
	
       
    public quitServlet() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		String Mid =request.getParameter("Mid");
		 String Mpassword=request.getParameter("Mpassword");
		 String msg="";
		 if(Mid==null||Mpassword==null){
			 msg="你还没有登录";
		 }else{
			 msg="你已经退出";
		 }
		 JSONArray list = new JSONArray();
			list.add(msg);
		response.getWriter().print(list);
		System.out.println(list);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
