package cn.edu.cqupt.camphor_forest.kindergarten.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;


public interface Studentservice {
	String addstudent(Student student) throws SQLException;

	int delestudent(String sid) throws SQLException;

	int updstudent(Student student) throws SQLException;
	
	int changeSFace(String sFace,String sid)throws SQLException;
	
//	Student selectUuid(String sid)throws SQLException;
	void delestudents(String[] sid) throws SQLException;
	List<Student> selstudent(String ss) throws SQLException;

	List<Student> selectAll() throws SQLException;
	
	 List<Student> selectByClassNa(String cna) throws SQLException;
	 
	 boolean isexit(String phone);

}
