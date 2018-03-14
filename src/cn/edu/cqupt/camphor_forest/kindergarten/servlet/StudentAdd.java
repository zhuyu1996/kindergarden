package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectMovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.CollectPhotoserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Studentserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JsonUtil;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

/**
 * Servlet implementation class StudentAdd
 */
@WebServlet("/StudentAdd")
public class StudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentAdd() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Studentserviceimpl studentserviceimpl = new Studentserviceimpl();
		CollectMovieserviceImpl collectMovieserviceImpl=new CollectMovieserviceImpl();
	    CollectPhotoserviceImpl collectPhotoserviceImpl=new CollectPhotoserviceImpl();
		String studentjson = request.getParameter("studentjson");
		System.out.println("添加学生" + studentjson);
		 CollectMovie collectmovie=new CollectMovie();
	       CollectPhoto collectPhoto=new CollectPhoto();
//		InputStream is = request.getInputStream();
//		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
//		String line = null;
//		StringBuilder sb = new StringBuilder();
//		while ((line = br.readLine()) != null) {
//			sb.append(line);
//		}
//		System.out.println("====INPUTSTREAM" + sb);

		if (studentjson== null) {
			response.getWriter().print("传给我的是null，添加失败");
		} else {//判断是非用户重复
			Student student = JsonUtil.getEntity(studentjson, Student.class);
			String s[]=student.getsAcount().split(":");
			boolean result=true;
			for(int i=1;i<s.length;i++){
				if(result==true){
					String one=s[i];
					String b=one.substring(0, 11);
				if(!studentserviceimpl.isexit(b)){
					
					result=false;
				}
				}
			}
			System.out.println(result);
            if(result){
			try {
				String stuid=studentserviceimpl.addstudent(student);
				System.out.println("stuid"+stuid);
			      collectmovie.setCmuserid(stuid);
			      collectMovieserviceImpl.addcollectmovie(collectmovie);
			      collectPhoto.setCpuserid(stuid);
			      collectPhotoserviceImpl.addcollecphoto(collectPhoto);
				response.getWriter().print("成功");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				response.getWriter().print("false");
			}
		}else{
			response.getWriter().print("某个用户已存在");
			}
		}
 
	}

}
