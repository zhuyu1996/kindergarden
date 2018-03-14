package kindergarden.manager3.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.TeacherDao;
import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.TeacherDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Teatherservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;

public class Teatherserviceimpl2 implements Teatherservice{

    private TeacherDao tdi = new TeacherDaoImpl();
	@Override
	public String addteacher(Teacher teacher) throws SQLException {
		return tdi.insert(teacher);
	}

	@Override
	public int deleteacher(String tworkid) throws SQLException {
		 System.out.println("555");
		 return tdi.deleteById(tworkid);
	}

	@Override
	public int updteacher(Teacher teacher) throws SQLException {
		return tdi.updateByUuid(teacher);
	}
 	@Override
	public Teacher selectUuid(String tid) throws SQLException {
        return tdi.selectBytId(tid);
	}   
	@Override
	public List<Teacher> selteacher(String ss) throws SQLException {
          if(!tdi.selectByPhone(ss).isEmpty()){
        	 return (List<Teacher>) tdi.selectByPhone(ss);
         }else{
        	 return null;
         } 
	}
	@Override
	public List<Teacher> selectAll() throws SQLException {
           return tdi.selectAll();
	}

	@Override
	public Teacher selteacher1(String sss) throws SQLException {
		// TODO Auto-generated method stub
		return tdi.selectByPhonelogin(sss);
	}

	@Override
	public List<Teacher> steacherByClass(String classid) throws SQLException {
		// TODO Auto-generated method stub
		return tdi.selectByclasst(classid);
	}
	@Override
	public int updteacherface(String tface,String tid) throws SQLException {
		return tdi.updateTFace(tface,tid);
	}

	@Override
	public List<Teacher> showbyBaoYu() throws SQLException {
		// TODO Auto-generated method stub
		return tdi.selectbyBaoYu();
	}

	@Override
	public List<Teacher> showbymonitor() throws SQLException {
		// TODO Auto-generated method stub
		return tdi.selectbymonitor();
	}

	@Override
	public List<Teacher> showbycommontea() throws SQLException {
		// TODO Auto-generated method stub
		return tdi.selectbycommontea();
	}

	@Override
	public boolean ifexit(String phone) {
		// TODO Auto-generated method stub
		return tdi.isexit(phone);
	}

}
