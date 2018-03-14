package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.StudentDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Studentservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;


public class Studentserviceimpl implements Studentservice{
    private StudentDaoImpl studentDao=new StudentDaoImpl();
	@Override
	public String addstudent(Student student) throws SQLException {
		return studentDao.insert(student);
	}
	@Override
	public void delestudents(String[] sid) throws SQLException {
		studentDao.deleteByIds(sid);;
	}
	@Override
	public int delestudent(String sid) throws SQLException {
		return studentDao.deleteById(sid);
	}

	@Override
	public int updstudent(Student student) throws SQLException {
		return studentDao.updateByUuid(student);
	}

//	@Override
//	public Student selectUuid(String sid) throws SQLException {
//		return studentDao.selectBytId(sid);
//	}

	@Override
	public List<Student> selstudent(String ss) throws SQLException {
        if(!studentDao.selectBySname(ss).isEmpty()){
        	return  (List<Student>) studentDao.selectBySname(ss); 	
        }else if(!studentDao.selectByPnameOrPhone(ss).isEmpty()) {
       	 return (List<Student>) studentDao.selectByPnameOrPhone(ss);
        }else if(!studentDao.selectByPnameOrPhone(ss).isEmpty()){
          	 return (List<Student>) studentDao.selectBySname(ss);
        }else if(!studentDao.selectByClassNannnnn(ss).isEmpty()){
          	 return  (List<Student>) studentDao.selectByClassNannnnn(ss);
        }else{
       	 return null;
        } 
	}

	@Override
	public List<Student> selectAll() throws SQLException {
	    return studentDao.selectAll();
	}
	@Override
	public int changeSFace(String sFace, String sid) throws SQLException {
		return studentDao.updateSFace(sFace, sid);
	}
	@Override
	public List<Student> selectByClassNa(String cna) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.selectByClassNannnnn(cna);
	}
	@Override
	public boolean isexit(String phone) {
		// TODO Auto-generated method stub
		return studentDao.ifexit(phone);
	}
       
}
