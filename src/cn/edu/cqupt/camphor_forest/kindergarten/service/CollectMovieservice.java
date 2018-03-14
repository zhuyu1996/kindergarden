package cn.edu.cqupt.camphor_forest.kindergarten.service;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovie;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;

public interface CollectMovieservice {
	int addcollectmovie(CollectMovie collectMovie);

	CollectMovie showcollectMcontentAp(String userid);
}
