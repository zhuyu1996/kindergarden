package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;

public interface CollectPhotoDao {
	int insertcollecphoto(CollectPhoto collectPhoto);
	
	CollectPhoto showcollectpicontentAp(String userid);
	
}
