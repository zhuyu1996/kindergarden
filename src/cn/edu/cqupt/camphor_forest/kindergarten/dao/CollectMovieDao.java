package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;

public interface CollectMovieDao {

	int insertcollectmovie(CollectMovie collectMovie);
	
	CollectMovie showcollectmoviecontentAp(String userid);
}
