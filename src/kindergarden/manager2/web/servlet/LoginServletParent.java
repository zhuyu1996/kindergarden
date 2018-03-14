package kindergarden.manager2.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;
import kindergarden.manager2.impl.logindaoimpl2;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServletParent
 */
@WebServlet("/LoginServletParent")
public class LoginServletParent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServletParent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String Appid = request.getParameter("phone");
			String Apppassword = request.getParameter("spassword");
			System.out.println(Appid+" "+Apppassword);
			Student student = null;
			logindaoimpl2 logindaoimpl2=new logindaoimpl2();
		
				
					try {
						student =logindaoimpl2.selectByPhone(Appid);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

				if (student == null) {
					JSONObject map = new JSONObject();
					map.element("Appid", Appid);
					map.element("msg", "用户为空");
					map.element("Object", "");
					
					response.getWriter().print(map);
					System.out.println(map);
					}
					else if (!student.getsPassword().equals(Apppassword)) {
						JSONObject map = new JSONObject();
						map.element("phone", Appid);
						map.element("msg", "密码错误");
						map.element("Object", "");
						response.getWriter().print(map);
						System.out.println(map);
						System.out.println(student);
					}else{
					String msg = "家长登录成功";
					JSONObject map = new JSONObject();
					map.element("Appid", Appid);
					map.element("msg", msg);
	                map.element("Object",JsonUtil.EntityToJson(student));
	                response.getWriter().print(map);
			}
		
				}
				
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

}
