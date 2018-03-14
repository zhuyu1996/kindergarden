package cn.edu.cqupt.camphor_forest.kindergarten.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.ClassDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.StudentDaoImpl;
import cn.edu.cqupt.camphor_forest.kindergarten.service.Classsservice;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Classs;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

public class ClassserviceImpl implements Classsservice{
       ClassDaoImpl classdaoimpl=new ClassDaoImpl();
       private StudentDaoImpl studentDao=new StudentDaoImpl();
	@Override
	public int upclass() {
		return classdaoimpl.upclass();
	}

	@Override
	public int insertclass(Classs classs) {
		return classdaoimpl.createclass(classs);
	}

	@Override
	public int deleteclass(String uuid) {
		
	    return classdaoimpl.deleteclass(uuid);
	}

	@Override
	public Classs searchclass(String search) {
		if(classdaoimpl.searchclassidtea(search)!= null)
		{
			return classdaoimpl.searchclassidtea(search);
		}
		else if(classdaoimpl.searchclassid(search) != null){
			System.out.println(2);
			return classdaoimpl.searchclassid(search);
		}else{
			return null;
		}
	}

	@Override
	public List<Classs> classshow() {
		return classdaoimpl.showClass();
	}

	@Override
	public List<Student> selectByClassId(String cid) throws SQLException {
		// TODO Auto-generated method stub
		return studentDao.selectByClassName(cid);
	}

	@Override
	public int updateclass(Classs classs) {
		// TODO Auto-generated method stub
		return classdaoimpl.updateclass(classs);
	}

	@Override
	public List<String> showClassName() {
		// TODO Auto-generated method stub
		return classdaoimpl.showClassname();
	}

	@Override
	public boolean isexit(String cName) {
		// TODO Auto-generated method stub
		return classdaoimpl.ifexit(cName);
	}

	@Override
	public String searchNameById(String classid) {
		// TODO Auto-generated method stub
		return classdaoimpl.showNameById(classid);
	}
   
}
