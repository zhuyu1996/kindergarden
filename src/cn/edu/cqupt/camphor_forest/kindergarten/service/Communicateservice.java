package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Communicate;

public interface Communicateservice {

	//删
	int delCom(String conId);
	//查
	List<Communicate> seltcom(String xId);
	//新增
	int insCom(Communicate communicate);
}
