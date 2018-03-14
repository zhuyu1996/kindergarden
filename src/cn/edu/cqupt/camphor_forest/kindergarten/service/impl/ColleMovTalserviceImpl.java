package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.CollectMovTotalDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.CollectMovTalservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.CollectMovTotal;

public class ColleMovTalserviceImpl implements CollectMovTalservice{
	CollectMovTotalDaoImpl collectMovTotalDaoImpl=new CollectMovTotalDaoImpl();
	@Override
	public int addcollectMovtotal(String Movid, String pmid) {
		return collectMovTotalDaoImpl.insertcollectMovtal(Movid,pmid);
	}

	@Override
	public List<String> showcollectMovtal(String mcid) {
		return collectMovTotalDaoImpl.showcollectMovtal(mcid);
	}

}
