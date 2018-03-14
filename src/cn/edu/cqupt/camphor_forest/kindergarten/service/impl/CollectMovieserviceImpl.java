package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.CollectMovieDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.CollectMovieservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;

public class CollectMovieserviceImpl implements CollectMovieservice{
	CollectMovieDaoImpl collectMovieDaoImpl=new CollectMovieDaoImpl();
	@Override
	public int addcollectmovie(CollectMovie collectMovie) {
		// TODO Auto-generated method stub
		return collectMovieDaoImpl.insertcollectmovie(collectMovie);
	}
	@Override
	public CollectMovie showcollectMcontentAp(String userid) {
		// TODO Auto-generated method stub
		return collectMovieDaoImpl.showcollectmoviecontentAp(userid);
	}

}
