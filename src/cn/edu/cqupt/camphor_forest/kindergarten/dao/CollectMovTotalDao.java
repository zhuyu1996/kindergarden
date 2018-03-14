package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;

public interface CollectMovTotalDao {

	
	List<String > showcollectMovtal(String mcid);
	
	int insertcollectMovtal(String Movid, String pmid);
}
