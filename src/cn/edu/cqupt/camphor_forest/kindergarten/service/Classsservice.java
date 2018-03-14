package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

public interface Classsservice {
    //升级
	int upclass();
	//增
	int insertclass(Classs classs);
	//删
	int deleteclass(String uuid);
	//查找
	Classs searchclass(String search);
	//显示
	List<Classs> classshow();
	//班级详情
	List<Student> selectByClassId(String cid)throws SQLException;
    //修改
	int updateclass(Classs classs);
    //所有的班级名
	List<String> showClassName();
	
	boolean isexit(String cName);
	
	String searchNameById(String classid);
}
