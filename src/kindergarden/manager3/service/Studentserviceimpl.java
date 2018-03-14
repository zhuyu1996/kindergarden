package kindergarden.manager3.service;

import java.sql.SQLException;
import java.util.List;

import kindergarden.manager3.domain.Student;
import kindergarden.manager3.impl.StudentDaoImpl2;


public class Studentserviceimpl {
    private StudentDaoImpl2 studentDao=new StudentDaoImpl2();
	public int addstudent(Student student) throws SQLException {
		return studentDao.insert(student);
	}

	public int delestudent(String sid) throws SQLException {
		return studentDao.deleteById(sid);
	}

	public int updstudent(Student student) throws SQLException {
		return studentDao.updateByUuid(student);
	}

	public Student selectUuid(String sid) throws SQLException {
		return studentDao.selectBytId(sid);
	}

	public List<Student> selstudent(String ss) throws SQLException {
        if(!studentDao.selectByClassId(ss).isEmpty()){
       	 return  (List<Student>) studentDao.selectByClassId(ss);
        }else if(!studentDao.selectByPnameOrPhone(ss).isEmpty()) {
       	 return (List<Student>) studentDao.selectByPnameOrPhone(ss);
        }else if(!studentDao.selectByPnameOrPhone(ss).isEmpty()){
          	 return (List<Student>) studentDao.selectBySname(ss);
        }else{
       	 return null;
        } 
	}

	public List<Student> selectAll() throws SQLException {
		String sql="SELECT * FROM student";
	    return studentDao.selectByAll(sql);
	}
       
}
