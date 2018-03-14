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


/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String totalurl="";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("aaaa");
	
		//工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//解析器
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//解析
		sfu.setFileSizeMax(100*1024*1024);
		try {
			List<FileItem> filelist=sfu.parseRequest(request);
			//FileItem fik=filelist.get(0);
			for(int i=1;i<filelist.size();i++){
			FileItem fik=filelist.get(i);
			System.out.println(fik);
			//根目录
			String root="c:/upload/temp2/";
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
			String url = "http://119.29.225.57:8080"  +"/kid/" + savename22;
			String url1 ="{\"" + "url\"" +":" + "\""+url+ "\"" + "}";
			totalurl=totalurl+url1;
			if(i+1<filelist.size())
			{    
				String url2=totalurl+",";
				totalurl=url2;
			}
			else{
				String url2="["+totalurl+"]";
				totalurl=url2;
			}
			System.out.println(filr);
			//保存
			fik.write(filr);
			//response.getWriter().println(url);
			}
			response.getWriter().println(totalurl);
			System.out.println(totalurl);
			totalurl="";
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
