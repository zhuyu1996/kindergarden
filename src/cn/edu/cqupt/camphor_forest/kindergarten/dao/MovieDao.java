package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;


public interface MovieDao {
	 //增加
		int insertMovie(Movie movie);
		//删除
		void deleMovie(String[] mvid);
		//web显示
		Paging showMovieW(int pageNum,String mcid);
		//App
		List<Movie> showMovieAp(int pageNum,String mcid);
		
		int incrLike(String comId);
		
		List<Movie> showcollecrMovieAp(List<String> movid,int pageNum);
}
