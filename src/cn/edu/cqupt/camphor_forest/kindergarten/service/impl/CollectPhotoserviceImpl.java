package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.CollectPhotoDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.CollectPhotoservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPhoto;

public class CollectPhotoserviceImpl implements CollectPhotoservice{
    private CollectPhotoDaoImpl collectPhotoserviceImpl=new CollectPhotoDaoImpl();
	@Override
	public int addcollecphoto(CollectPhoto collectPhoto) {
		// TODO Auto-generated method stub
		return collectPhotoserviceImpl.insertcollecphoto(collectPhoto);
	}
	@Override
	public CollectPhoto showcollectpiccontentAp(String userid) {
		// TODO Auto-generated method stub
		return collectPhotoserviceImpl.showcollectpicontentAp(userid);
	}

}
