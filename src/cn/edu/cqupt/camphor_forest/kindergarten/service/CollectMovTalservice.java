package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;

public interface CollectMovTalservice {
	List<String > showcollectMovtal(String mcid);
	
	int addcollectMovtotal(String Movid, String pmid);
}
