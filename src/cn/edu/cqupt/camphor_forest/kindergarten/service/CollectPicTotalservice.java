package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPicTotal;

public interface CollectPicTotalservice {
	List<String> showcollectPictotal(String mcid);
	
	int addcollectPictotal(String pictureid, String pmid);
	
	void delpicture(String[] picturreid);
}
