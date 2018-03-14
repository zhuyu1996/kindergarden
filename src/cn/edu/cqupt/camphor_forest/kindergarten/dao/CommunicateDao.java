package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Communicate;

public interface CommunicateDao {

	//删
	int deleteCom(String conId);
	//查
	List<Communicate> selectcom(String xId);
	//新增
	int insertCom(Communicate communicate);
}
