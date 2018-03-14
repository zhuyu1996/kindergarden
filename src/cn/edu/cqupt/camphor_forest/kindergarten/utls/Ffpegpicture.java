package cn.edu.cqupt.camphor_forest.kindergarten.utls;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;

public class Ffpegpicture {

    private static final String FFMPEG_PATH="C:/ffmpeg/bin/ffmpeg.exe";
    //cmd:  
    //c:\ffmpeg -i c:\abc.mp4 e:\sample.jpg -ss 00:00:05  -r 1 -vframes 1  -an -vcodec mjpeg  
    public String makeScreenCut(String videoRealPath){  
        List<String> commend = new ArrayList<String>();  
        String picadress=UUID.randomUUID().toString().replace("-", "")+".png";
        String keepdress="C:/upload/movieface/"+picadress;
       
        commend.add(FFMPEG_PATH);  
        commend.add("-i");  
        commend.add(videoRealPath);  
        commend.add("-y");  
        commend.add("-f");  
        commend.add("image2");  
        commend.add("-ss");  
        commend.add("2");  
        commend.add("-t");  
        commend.add("0.001");  
        commend.add(keepdress);  
  
        try {  
        ProcessBuilder builder = new ProcessBuilder();  
        builder.command(commend);  
        builder.redirectErrorStream(true);  
        System.out.println("视频截图开始...");  
  
        Process process = builder.start();  
        InputStream in = process.getInputStream();  
        byte[] bytes = new byte[1024];  
        System.out.print("正在进行截图，请稍候");  
        while (in.read(bytes)!= -1){  
            System.out.println(".");  
        }  
            System.out.println("");  
            System.out.println("视频截取完成...");  
            return picadress;
        } catch (IOException e) {  
            e.printStackTrace();  
            System.out.println("视频截图失败！");  
            return null;
        }  
    }  
	
//	Runtime runtime = Runtime.getRuntime();  
//    Process proce = null; 
//    //视频截图命令，封面图。  8是代表第8秒的时候截图
//    String cmd = "";  
//    String cut = "c:\\ffmpeg\\ffmpeg.exe   -i   "  
//            + oldfilepath  
//            + "   -y   -f   image2   -ss   8   -t   0.001   -s   600x500   c:\\ffmpeg\\output\\"  
//            + "a.jpg";  
//    String cutCmd = cmd + cut;  
//    proce = runtime.exec(cutCmd);  
//	

	
}
