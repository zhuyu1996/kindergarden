package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.KaixueTimeDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.KaixueTimeservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.KaixueTime;

public class KaixueTimeserviceImpl implements KaixueTimeservice {
	KaixueTimeDaoImpl kaixueTimeDaoImpl=new KaixueTimeDaoImpl();
	@Override
	public int updatekaixuetime(KaixueTime kaixueTime) {
		return kaixueTimeDaoImpl.updatetime(kaixueTime);
	}

	@Override
	public KaixueTime selectkaixuetime() {
		// TODO Auto-generated method stub
		return kaixueTimeDaoImpl.selecttime();
	}

}
