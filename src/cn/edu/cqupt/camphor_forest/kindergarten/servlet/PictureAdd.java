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
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureContentserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

/**
 * Servlet implementation class PictureAdd
 */
@WebServlet("/PictureAdd")
public class PictureAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PictureserviceImpl pictureserviceimpl=new PictureserviceImpl();
		String pid=request.getParameter("picturecontenid");
		System.out.println("相片"+pid);
		//工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//解析器
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//解析
		try {
			List<FileItem> filelist=sfu.parseRequest(request);
			//FileItem fik=filelist.get(0);
			for(int i=1;i<filelist.size();i++){
			FileItem fik=filelist.get(i);
			System.out.println("第"+i+fik);
			//根目录（修改）
			String root="C:/upload/photo/";
			String contenttypr=fik.getContentType();
			int index=contenttypr.indexOf("/");
			if(index!=-1){   //=-1就存在\\于是截取它后面的东西
				contenttypr=contenttypr.substring(index+1);
			}
			System.out.println("看到汉字"+contenttypr);
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
			String url = "http://119.29.225.57:8080"  +"/photo/" + savename22;
		//	String url1 ="{\"" + "url\"" +":" + "\""+url+ "\"" + "}";

			System.out.println(filr);
			//保存
			fik.write(filr);
			Picture picture=new Picture();
			picture.setpId(pid);
			picture.setXcAdress(url);
			System.out.println(picture.toString());
			pictureserviceimpl.createpicture(picture);
			
			}
			response.getWriter().println("添加成功");
			System.out.println("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			response.getWriter().println("添加失败");
			System.out.println("添加失败");
		}
		
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
