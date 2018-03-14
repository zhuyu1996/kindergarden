package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;

public interface ClassDao {
    //班级升级
	int upclass();
	//只要班级名的搜索
	String searchClassName();
	//搜索班级
	Classs searchclassid(String search);
	//搜索老师
	Classs searchclassidtea(String search);
	//创建班级
	int createclass(Classs classs);
	//班级解散
	int deleteclass(String uuid);
    //显示班级
	List<Classs> showClass(); 
	//修改老师
	int updateclass(Classs classs);
    //所有的班级名
	List<String> showClassname();
	
	boolean ifexit(String cname);
	
	String showNameById(String classid);
}
