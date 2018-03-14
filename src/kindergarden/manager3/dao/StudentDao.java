package kindergarden.manager3.dao;

import java.sql.SQLException;
import java.util.List;

import kindergarden.manager3.domain.Student;



public interface StudentDao {
	 int insert(Student student)throws SQLException;
		
	 int deleteById(String sid)throws SQLException;
	 
	 int updateByUuid(Student student)throws SQLException;
	 
	 List<Student> selectBySname(String sname)throws SQLException;
	 
	 List<Student> selectByPnameOrPhone(String pnamephone)throws SQLException;
    
     List<Student> selectByClassId(String cid)throws SQLException;
    
     Student selectBytId(String sid)throws SQLException;
    
     List<Student> selectAll()throws SQLException;
     Student selectbyphone(String phone)throws SQLException;
    
}
