package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;

public interface TeacherDao {
	 
	 String insert(Teacher teacher)throws SQLException;
	
	 int deleteById(String tworkid)throws SQLException;
	 
	 int updateByUuid(Teacher teacher)throws SQLException;
	
	 List<Teacher> selectByName(String name)throws SQLException;
     
     List<Teacher> selectByPhone(String phone)throws SQLException;
     
     List<Teacher> selectByClassId(String cid)throws SQLException;
     
     Teacher selectBytId(String tid)throws SQLException;
     
     List<Teacher> selectAll()throws SQLException;
     
     Teacher selectByPhonelogin(String phone) throws SQLException;

	List<Teacher> selectByclasst(String classid)throws SQLException;
	
	int updateTFace(String tface,String tid)throws SQLException;
	
	List<Teacher> selectbyBaoYu()throws SQLException;
	
	List<Teacher> selectbymonitor()throws SQLException;
	
	List<Teacher> selectbycommontea()throws SQLException;
	
	boolean isexit(String phone);
}
