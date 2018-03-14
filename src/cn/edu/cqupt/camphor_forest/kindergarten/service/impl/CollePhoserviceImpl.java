package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.CollectPicTotalDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.CollectPicTotalservice;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.SiChanping;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectPicTotal;

public class CollePhoserviceImpl implements CollectPicTotalservice{

	CollectPicTotalDaoImpl collectPicTotalDaoImpl=new CollectPicTotalDaoImpl();
	@Override
	public List<String> showcollectPictotal(String mcid) {
		// TODO Auto-generated method stub
		return collectPicTotalDaoImpl.showcollectPictal( mcid);
	}
	@Override
	public int addcollectPictotal(String pictureid, String pmid) {
		// TODO Auto-generated method stub
		return collectPicTotalDaoImpl.insertcollectPictal(pictureid,pmid);
	}
	@Override
	public void delpicture(String[] picturreid) {
		// TODO Auto-generated method stub
		 collectPicTotalDaoImpl.deletepicture(picturreid);
	}

	
}
