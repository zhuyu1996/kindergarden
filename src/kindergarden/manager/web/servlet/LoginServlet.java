package kindergarden.manager.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kindergarden.manager.domain.Manager;
import kindergarden.manager.service.LoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginService loginService = new LoginService();

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Mid = request.getParameter("Mid");
		String Mpassword = request.getParameter("Mpassword");
		System.out.println(Mid+" "+Mpassword);
		// 通过用户ID来查找
		Manager manager;
		try {
			manager = loginService.selectByMid(Mid);

			if (manager == null) {
				JSONObject map = new JSONObject();
				map.element("Mid", Mid);
				map.element("msg", "用户为空");
				response.getWriter().print(map);
				System.out.println(map);
			}
			else if (!manager.getMpassword().equals(Mpassword)) {
				JSONObject map = new JSONObject();
				map.element("Mid", Mid);
				map.element("msg", "密码错误");
				response.getWriter().print(map);
				System.out.println(map);
			}else{
			String msg = "登录成功";
			JSONObject map = new JSONObject();
			map.element("Mid", Mid);
			map.element("msg", msg);
			response.getWriter().print(map);
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
