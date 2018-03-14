package cn.edu.cqupt.camphor_forest.kindergarten.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

public interface StudentDao {
	String insert(Student student)throws SQLException;
		
	 int deleteById(String sid)throws SQLException;
	 
	 int updateByUuid(Student student)throws SQLException;
	 
	 int updateSFace(String sFace,String sid)throws SQLException;
	 
	 List<Student> selectBySname(String sname)throws SQLException;
	 
	 List<Student> selectByPnameOrPhone(String pnamephone)throws SQLException;
    
     List<Student> selectByClassName(String cid)throws SQLException;

     void deleteByIds(String[] sids)throws SQLException;
     
     List<Student> selectAll()throws SQLException;
    
     List<Student> selectByClassNannnnn(String cna) throws SQLException;
     
     boolean ifexit(String phone);

}
