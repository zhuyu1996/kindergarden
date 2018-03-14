package cn.edu.cqupt.camphor_forest.kindergarten.service;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;

public interface CollectPhotoservice {
	int addcollecphoto(CollectPhoto collectPhoto);
	
	CollectPhoto showcollectpiccontentAp(String userid);
}
