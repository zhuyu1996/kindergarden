package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;

public interface Movieservice {
	 //增加
		int createMovie(Movie movie);
		//删除
		void declineMovie(String[] mvid);
		//web显示
		Paging appearMovieW(int pageNum,String mcid);
		//App
		List<Movie> appearMovieAp(int pageNum,String mcid);
		
		int createLike(String comId);
		
		List<Movie> ashowcollecrMovieAp(List<String> movid,int pageNum);
}
