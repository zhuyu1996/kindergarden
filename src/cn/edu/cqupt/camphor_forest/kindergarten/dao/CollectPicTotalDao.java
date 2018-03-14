package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPicTotal;

public interface CollectPicTotalDao {
	
	List<String> showcollectPictal(String mcid);
	
	int insertcollectPictal(String pictureid,String pmid);
	
	 void deletepicture(String[] picturreid);
}
