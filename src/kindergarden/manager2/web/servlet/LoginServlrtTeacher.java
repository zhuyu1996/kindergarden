package kindergarden.manager2.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.up.Util.jsonUtil;

import kindergarden.manager2.domain.Manager2;
import kindergarden.manager2.service.LoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@WebServlet("/LoginServlrtTeacher")
public class LoginServlrtTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService=new LoginService();
    public LoginServlrtTeacher() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Tphone =request.getParameter("Tphone");
		 String TWorkId=request.getParameter("TWorkId");
		 System.out.println(Tphone+" "+TWorkId);
		 //通过用户ID来查找
		 Manager2 manager2;
			try{
		manager2 = loginService.selectByTphone(Tphone);
		 if(manager2==null){
			 JSONObject map=new JSONObject();
			 map.element("Tphone", Tphone);
			 map.element("msg", "教师用户不存在");
			 response.getWriter().print(map);
				System.out.println(map);
		 }
		 else if(!manager2.gettWorkId().equals(TWorkId)) {
			 JSONObject map=new JSONObject();
			 map.element("Tphone", Tphone);
			 map.element("msg", "密码错误");
			 response.getWriter().print(map);
				System.out.println(map);
			}else{
		 String msg="登录成功";
		 JSONObject map = new JSONObject();
		 map.element("Tphone", Tphone);
			map.element("msg", msg);
//			response.getWriter().print(map);
			response.getWriter().println(jsonUtil.EntityToJson(manager2));
			System.out.println(map);
			}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
	