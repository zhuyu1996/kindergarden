package cn.edu.cqupt.camphor_forest.kindergarten.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.cqupt.camphor_forest.kindergarten.service.Teatherservice;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Studentserviceimpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.Teatherserviceimpl;

/**
 * Servlet implementation class StudentFace
 */
@WebServlet("/StudentFace")
public class StudentFace extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Studentserviceimpl studentserviceimpl=new Studentserviceimpl();
			String sid=request.getParameter("sid");
			System.out.println("studentid为"+sid);
			//工厂
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//解析器
			ServletFileUpload sfu=new ServletFileUpload(factory);
			//解析
			try {
				List<FileItem> filelist=sfu.parseRequest(request);
				//FileItem fik=filelist.get(0);
				FileItem fik=filelist.get(0);
				System.out.println(fik);
				//根目录（修改）
				String root="C:/upload/tface/";
				String contenttypr=fik.getContentType();
				int index=contenttypr.indexOf("/");
				if(index!=-1){   //=-1就存在\\于是截取它后面的东西
					contenttypr=contenttypr.substring(index+1);
				}
				System.out.println("类型"+contenttypr);
				//给加uuid（）；
				String savename=UUID.randomUUID().toString().replace("-", "")+"."+contenttypr;
				int code=savename.hashCode();
				String hex=Integer.toHexString(code);
	            File dirFile = new File(root, hex.charAt(0) + "/" + hex.charAt(1));
	            String savename22=hex.charAt(0) + "/" + hex.charAt(1)+"/"+savename;
				/*
				 * 3. 创建目录链
				 */
				dirFile.mkdirs(); 
				//创建目录文件
				File filr=new File(dirFile,savename);
				String url = "http://119.29.225.57:8080"  +"/tface/" + savename22;
				//String url1 ="{\"" + "url\"" +":" + "\""+url+ "\"" + "}";

				System.out.println("地址为"+filr);
				//保存
				fik.write(filr);
				int i=studentserviceimpl.changeSFace(url,sid);
				System.out.println("url为"+url);
				if(i!=0){
					response.getWriter().println(url);}
					else{response.getWriter().print("[]");}
				
				System.out.println("添加成功");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.getWriter().println("添加失败");
				System.out.println("添加失败");
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
