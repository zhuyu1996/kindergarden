package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;

public interface MovieContentservice {
	
    int addMovieContent(MovieContent moviecontent);
    
    void delMovieContent(String[] mcid);
    
    int updMovieContent(MovieContent moviecontent);
    //班级视频
    Paging showMCByclass(String classid,int pageNum);
    //班级视频
    Paging showMCByclassApp(String classid,int pageNum);
    //全校视频
    Paging showMCByAdmi(int pageNum);
}
