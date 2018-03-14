package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.MovieDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Movieservice;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.Paging;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Movie;

public class MovieserviceImpl implements Movieservice{
    MovieDaoImpl moviedaoimpl=new MovieDaoImpl();

	@Override
	public int createMovie(Movie movie) {
		return moviedaoimpl.insertMovie(movie);
	}

	@Override
	public void declineMovie(String[] mvid) {
		 moviedaoimpl.deleMovie(mvid);
	}

	@Override
	public Paging appearMovieW(int pageNum, String mcid) {
		// TODO Auto-generated method stub
		return moviedaoimpl.showMovieW(pageNum, mcid);
	}

	@Override
	public List<Movie> appearMovieAp(int pageNum, String mcid) {
		// TODO Auto-generated method stub
		return moviedaoimpl.showMovieAp(pageNum, mcid);
	}

	@Override
	public int createLike(String comId) {
		// TODO Auto-generated method stub
		return moviedaoimpl.incrLike(comId);
	}

	@Override
	public List<Movie> ashowcollecrMovieAp(List<String> movid, int pageNum) {
		// TODO Auto-generated method stub
		return moviedaoimpl.showcollecrMovieAp(movid, pageNum);
	}
	
}
