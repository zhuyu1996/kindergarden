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

import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.MovieserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.impl.PictureserviceImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Ffpegpicture;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Picture;

/**
 * Servlet implementation class MovieAdd
 */
@WebServlet("/MovieAdd")
public class MovieAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String belong=request.getParameter("McidJson");

		MovieserviceImpl movieserviceImpl=new MovieserviceImpl();
		//工厂
		DiskFileItemFactory factory=new DiskFileItemFactory();
		//解析器
		ServletFileUpload sfu=new ServletFileUpload(factory);
		//解析
		try {
			List<FileItem> filelist=sfu.parseRequest(request);
			System.out.println("aa");
			//FileItem fik=filelist.get(0);
			for(int i=1;i<filelist.size();i++){
			FileItem fik=filelist.get(i);
			System.out.println(fik);
			//根目录（修改）
			String root="C:/upload/movie/";
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
			String url = "http://119.29.225.57:8080"  +"/movie/" + savename22;
		//	String url1 ="{\"" + "url\"" +":" + "\""+url+ "\"" + "}";

			System.out.println(filr);
			//保存
			fik.write(filr);
			
			//jietu
			String moviepath="C:/upload/movie/"+savename22;
			//截图
			Ffpegpicture ff=new Ffpegpicture();
			String savename1=ff.makeScreenCut(moviepath);
			String ur3 = "http://119.29.225.57:8080"  +"/movieface/" + savename1;
			
			Movie movie=new Movie();
			movie.setMvAdress(url);
			movie.setMcId(belong);
	    	movie.setMface(ur3);
			System.out.println("视频"+movie.toString());
			movieserviceImpl.createMovie(movie);
			
			}
			response.getWriter().println("添加成功");
			System.out.println("添加成功");
		} catch (Exception e) {
			response.getWriter().println("添加失败");
			System.out.println("添加失败");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
