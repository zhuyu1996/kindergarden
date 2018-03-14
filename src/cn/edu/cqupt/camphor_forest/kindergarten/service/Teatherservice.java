package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;

public interface Teatherservice {
        
	String addteacher(Teacher teacher) throws SQLException;

	int deleteacher(String tworkid) throws SQLException;

	int updteacher(Teacher teacher) throws SQLException;

	
	Teacher selectUuid(String tid)throws SQLException;
	
	List<Teacher> selteacher(String ss) throws SQLException;

	List<Teacher> selectAll() throws SQLException;

	Teacher selteacher1(String sss) throws SQLException;

	List<Teacher> steacherByClass(String classid) throws SQLException;
	
	int updteacherface(String tface,String tid) throws SQLException;
	
	List<Teacher> showbyBaoYu()throws SQLException;
	
	List<Teacher> showbymonitor()throws SQLException;
	
	List<Teacher> showbycommontea()throws SQLException;
	
	boolean ifexit(String phone);
}
