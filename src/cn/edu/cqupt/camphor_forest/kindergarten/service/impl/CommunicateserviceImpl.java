package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.CommunicateDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Communicateservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Communicate;

public class CommunicateserviceImpl implements Communicateservice{
	CommunicateDaoImpl communicatedaoimpl=new CommunicateDaoImpl();
	@Override
	public int delCom(String conId) {
		return communicatedaoimpl.deleteCom(conId);
	}

	@Override
	public List<Communicate> seltcom(String xId) {
		return communicatedaoimpl.selectcom(xId);
	}

	@Override
	public int insCom(Communicate communicate) {
		return communicatedaoimpl.insertCom(communicate);
	}


	
}
