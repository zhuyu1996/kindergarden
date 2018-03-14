package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.MovieContent;

public interface MovieContentDao {
        int insertMovieContent(MovieContent moviecontent);
        
        void deletMovieContent(String[] mcid);
	    
        int updateMovieContent(MovieContent moviecontent);
        //班级视频
        Paging selectMCByclass(String classid,int pageNum);
        //班级视频
        Paging selectMCByclassApp(String classid,int pageNum);
	    //全校视频
        Paging selectMCByAdmi(int pageNum);
        
        List<MovieContent> selectALLMC(String classid,int pageNum);
}
