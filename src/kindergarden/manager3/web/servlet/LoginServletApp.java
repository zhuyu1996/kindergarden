package kindergarden.manager3.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.Teatherservice;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollePhoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectMovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectPhotoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.ChangeStudent;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.ChangeTeacher;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;
import kindergarden.manager3.domain.Manager3;
import kindergarden.manager3.domain.Student;
import kindergarden.manager3.impl.StudentDaoImpl2;
import kindergarden.manager3.impl.Teatherserviceimpl2;
import kindergarden.manager3.service.LoginService;
import kindergarden.manager3.service.Studentserviceimpl;
import net.sf.json.JSONObject;

@WebServlet("/LoginServletApp")

public class LoginServletApp extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private LoginService loginService = new LoginService();

	public LoginServletApp() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Appid = request.getParameter("Appid");
		String Apppassword = request.getParameter("Apppassword");
		System.out.println(Appid+" "+Apppassword);
		Manager3 manager;
		try {
			manager = loginService.selectByMid(Appid);

			if (manager == null) {
				
				manager =loginService.selectByMid2(Appid);
				if(manager==null){
				JSONObject map = new JSONObject();
				map.element("Appid", Appid);
				map.element("msg", "用户为空");
				map.element("Object", "");
				
				response.getWriter().print(map);
				System.out.println(map);
				}
				else if (!manager.getApppassword().equals(Apppassword)) {
					JSONObject map = new JSONObject();
					map.element("Appid", Appid);
					map.element("msg", "密码错误");
					map.element("Object", "");
					response.getWriter().print(map);
					System.out.println(map);
				}else{
				String msg = "家长登录成功";
				JSONObject map = new JSONObject();
				map.element("Appid", Appid);
				map.element("msg", msg);
				StudentDaoImpl2 dao=new StudentDaoImpl2();
				
					
				Student	 student=dao.selectbyphone(Appid);
                  //67加
				CollectMovieserviceImpl collectMovieserviceImpl=new CollectMovieserviceImpl();
				CollectMovie collectMovie=collectMovieserviceImpl.showcollectMcontentAp(student.getsId());
				CollectPhotoserviceImpl collePhoserviceImpl=new CollectPhotoserviceImpl();
				CollectPhoto collectPhoto=collePhoserviceImpl.showcollectpiccontentAp(student.getsId());
				ChangeStudent changeStudent=new ChangeStudent();
				changeStudent.setcId(student.getcId());
				changeStudent.setMovieContentid(collectMovie.getCmid());
				changeStudent.setPictureContentid(collectPhoto.getCpid());
				changeStudent.setsAcount(student.getsAcount());
				changeStudent.setsAddress(student.getsAddress());
				changeStudent.setsComeAge(student.getsComeAge());
				changeStudent.setsComeTime(student.getsComeTime());
				changeStudent.setsFace(student.getSface());
				changeStudent.setsId(student.getsId());
				changeStudent.setsIdentifyId(student.getsIdentifyId());
				changeStudent.setsName(student.getsName());
				changeStudent.setsPassword(student.getsPassword());
				changeStudent.setsSex(student.getsSex());
				//
					map.element("Object",JsonUtil.EntityToJson(changeStudent));
				response.getWriter().print(map);
				System.out.println(map);
				}
			}
			else if (!manager.getApppassword().equals(Apppassword)) {
				JSONObject map = new JSONObject();
				map.element("Appid", Appid);
				map.element("msg", "密码错误");
				map.element("Object", "");
				response.getWriter().print(map);
				System.out.println(map);
			}else{
			String msg = "老师登录成功";
			JSONObject map = new JSONObject();
			map.element("Appid", Appid);
			map.element("msg", msg);
			
			 Teatherservice teacherservice=new Teatherserviceimpl2();
				String sss=request.getParameter("Appid");
				try {
					Teacher listTeacher=teacherservice.selteacher1(sss);
					//67加的目录id
					ChangeTeacher changeTeacher=new ChangeTeacher();
					CollectMovieserviceImpl collectMovieserviceImpl=new CollectMovieserviceImpl();
					CollectMovie collectMovie=collectMovieserviceImpl.showcollectMcontentAp(listTeacher.gettId());
					CollectPhotoserviceImpl collePhoserviceImpl=new CollectPhotoserviceImpl();
					CollectPhoto collectPhoto=collePhoserviceImpl.showcollectpiccontentAp(listTeacher.gettId());
					changeTeacher.setcId(listTeacher.getcId());
					changeTeacher.setMovieContentid(collectMovie.getCmid());
					changeTeacher.setPictureContentid(collectPhoto.getCpid());
					changeTeacher.setTface(listTeacher.getTface());
					changeTeacher.setTgrade(listTeacher.getTgrade());
					changeTeacher.settId(listTeacher.gettId());
					changeTeacher.settName(listTeacher.gettName());
					changeTeacher.settPhone(listTeacher.gettPhone());
					changeTeacher.settSex(listTeacher.gettSex());
					changeTeacher.settWorkId(listTeacher.gettWorkId());
					
					map.element("Object",JsonUtil.EntityToJson(changeTeacher) );

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					response.getWriter().print("false");
				}
				response.getWriter().print(map);
				System.out.println(map);
			}

			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
