package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.StudentDao;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;


public class StudentDaoImpl extends JDBCTemplates<Student> implements StudentDao{

	@Override
	public String insert(Student student) throws SQLException {
		String z[]=student.getcId().split(",");
		System.out.println("z[0]="+z[0]);
		String sql7="SELECT co_flag FROM classone where co_name=?";
		String[] param7={z[0]};
        int ccflag=oneInt(sql7,param7);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param={z[1],ccflag};
        String ccid=oneString(sql1,param);
		String sql="INSERT INTO student (s_id,s_name,s_acount,s_password,s_sex,s_identify_id,c_id,s_cometime,s_comeage,s_address,s_face)VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		 String face="http://119.29.225.57:8080/photo/9/9/b1cca2b3e791469eb4fab53f1a025200.png";
		 String secrit=student.getsIdentifyId().substring(student.getsIdentifyId().length()-6,student.getsIdentifyId().length());
		Object[] params={UUID.randomUUID().toString().replace("-",""),student.getsName(),student.getsAcount(),secrit,student.getsSex(),student.getsIdentifyId(),ccid,student.getsComeTime(),student.getsComeAge(),student.getsAddress(),face};
		update(sql,params);
		return params[0].toString();
	}
	@Override
	public void deleteByIds(String[] sids) throws SQLException {
		String sql="DELETE FROM student WHERE s_id=?";	
		batchupdate(sql,sids);
	}
	@Override
	public int deleteById(String sid) throws SQLException {
		String sql="DELETE FROM student WHERE s_id=?";	
		Object[] param={sid};
		return update(sql,param);
	}

	@Override
	public int updateByUuid(Student student) throws SQLException {
		if(student.getcId().equals("已转出")){
			String sql="UPDATE student SET s_name=?,s_acount=?,s_password=?,s_sex=?,s_identify_id=?,c_id=?,s_cometime=?,s_comeage=?,s_address=? WHERE s_id=?";
			Object[] params={student.getsName(),student.getsAcount(),student.getsPassword(),student.getsSex(),student.getsIdentifyId(),student.getcId(),student.getsId(),student.getsComeTime(),student.getsComeAge(),student.getsAddress()};
		    update(sql, params);
			//处理转出学生，移到其它表,然后从学生表删除
			String sql4="INSERT INTO studentonetime (s_id,s_name,s_acount,s_password,s_sex,s_identify_id,c_id,s_cometime,s_comeage,s_address)VALUES(?,?,?,?,?,?,?,?,?,?)";
			Object[] param4={student.getsId(),student.getsName(),student.getsAcount(),"123456",student.getsSex(),student.getsIdentifyId(),"已转出",student.getsComeTime(),student.getsComeAge(),student.getsAddress()};
			update(sql4,param4);
	    	 return deleteById(student.getsId());	
		}else{
		String z[]=student.getcId().split(",");
		String sql7="SELECT co_flag FROM classone where co_name=?";
		String[] param7={z[0]};
        int ccflag=oneInt(sql7,param7);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param={z[1],ccflag};
        String ccid=oneString(sql1,param);
		String sql="UPDATE student SET s_name=?,s_acount=?,s_password=?,s_sex=?,s_identify_id=?,c_id=?,s_cometime=?,s_comeage=?,s_address=? WHERE s_id=?";
		String secrit=student.getsIdentifyId().substring(student.getsIdentifyId().length()-6,student.getsIdentifyId().length());
		Object[] params={student.getsName(),student.getsAcount(),secrit,student.getsSex(),student.getsIdentifyId(),ccid,student.getsComeTime(),student.getsComeAge(),student.getsAddress(),student.getsId()};
	    return update(sql, params);}
	}

	@Override
	public int updateSFace(String sFace, String sid) throws SQLException {
		String sql="UPDATE student SET s_face=? WHERE s_id=?";
		Object[] params={sFace,sid};
	    return update(sql, params);
	}
	
	@Override
	public List<Student> selectBySname(String sname) throws SQLException {
		System.out.println("查找sname");
		String sql = "SELECT * FROM student where s_name =?";
		Object[] params = {sname};
		List<Student> student=selectAll(sql, params);
		for(int i=0;i<student.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={student.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={student.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		student.get(i).setcId(cconame);
		}
		return student;
	}
//v
	@Override   
	public List<Student> selectByPnameOrPhone(String pnamephone) throws SQLException {
		System.out.println("查找acount");
		String sql = "SELECT * FROM student where s_acount like ?";
		Object[] params = {"%"+pnamephone+"%"};	
		System.out.println(selectAll(sql,params));
		if(selectAll(sql,params)==null){
			return selectAll(sql,params);
		}else{
		List<Student> student=selectAll(sql,params);
		for(int i=0;i<student.size();i++){
			String sql1="SELECT c_flag FROM class where c_id=?";
			Object[] param={student.get(i).getcId().toString()};
			int t=oneInt(sql1,param);
			String sql3="SELECT c_name FROM class where c_id=?";
			Object[] param3={student.get(i).getcId().toString()};
			String cname=oneString(sql3,param3);
			String sql2="SELECT co_name FROM classone where co_flag=?";
			Object[] param2={t};
			String coname=oneString(sql2,param2);
			String cconame=coname+cname;
			student.get(i).setcId(cconame);
		}
		return student;
		}
	}
//是查找的班级名字
	@Override
	public List<Student> selectByClassName(String cna) throws SQLException {
		System.out.println("班级id查找");
		String sql = "SELECT * FROM student WHERE c_id = ?";
		Object[] params={cna};
		List<Student> student=selectAll(sql, params);
		for(int i=0;i<student.size();i++){
			String sql4="SELECT c_flag FROM class where c_id=?";
			Object[] param4={student.get(i).getcId().toString()};
			int a=oneInt(sql4,param4);
			String sql3="SELECT c_name FROM class where c_id=?";
			Object[] param3={student.get(i).getcId().toString()};
			String cname=oneString(sql3,param3);
			String sql2="SELECT co_name FROM classone where co_flag=?";
			Object[] param2={a};
			String coname=oneString(sql2,param2);
			String cconame=coname+cname;
			student.get(i).setcId(cconame);
		}
		 return student;
		 }
	
//x
//	@Override
//	public Student selectBytId(String sid) throws SQLException {
//		String sql = "SELECT * FROM student where s_id = ?";
//		Object[] params = {sid};
//		Student student=selectOne(sql, params);
//		String sql4="SELECT c_flag FROM class where c_id=?";
//		Object[] param4={student.getcId()};
//		int a=oneInt(sql4,param4);
//		String sql3="SELECT c_name FROM class where c_id=?";
//		Object[] param3={student.getcId()};
//		String cname=oneString(sql3,param3);
//		String sql2="SELECT co_name FROM classone where c_flag=?";
//		Object[] param2={a};
//		String coname=oneString(sql2,param2);
//		String cconame=coname+cname;
//		student.setcId(cconame);
//		return student;
//	}
//x
	@Override
	public List<Student> selectAll() throws SQLException {
		//处理毕业学生，移到其它表,然后从学生表删除
		String sql3="select c_id from class where c_name=?";
		Object[] param3={"已毕业"};
		if(!onestringlist(sql3,param3).isEmpty()){
		List list=onestringlist(sql3,param3);
		for(int j=0;j<list.size();j++){
			String sql5="select*from student where c_id=?";
			Object[] param5={list.get(j).toString()};
			List<Student> student=selectAll(sql5,param5);
			for(int i=0;i<student.size();i++){
			String sql4="INSERT INTO studentonetime (s_id,s_name,s_acount,s_password,s_sex,s_identify_id,c_id,s_cometime,s_comeage,s_address)VALUES(?,?,?,?,?,?,?,?,?,?)";
			Object[] param4={student.get(i).getsId(),student.get(i).getsName(),student.get(i).getsAcount(),"123456",student.get(i).getsSex(),student.get(i).getsIdentifyId(),"已毕业",student.get(i).getsComeTime(),student.get(i).getsComeAge(),student.get(i).getsAddress()};
			update(sql4,param4);
			deleteById(student.get(i).getsId());
			}	
		}
		}
//		//处理转出学生，移到其它表,然后从学生表删除
//		String sql5="select*from student where c_id=?";
//		Object[] param5={"已转出"};
//		if(!selectAll(sql5,param5).isEmpty()){
//		List<Student> student=selectAll(sql5,param5);
//		for(int i=0;i<student.size();i++){
//		String sql4="INSERT INTO studentonetime (s_id,s_name,s_acount,s_password,s_sex,s_identify_id,c_id)VALUES(?,?,?,?,?,?,?)";
//		Object[] param4={student.get(i).getsId(),student.get(i).getsName(),student.get(i).getsAcount(),"123456",student.get(i).getsSex(),student.get(i).getsIdentifyId(),"已转出"};
//		update(sql4,param4);
//		deleteById(student.get(i).getsId());
//		}
//		}
		//查所有学生
		String sql="SELECT * FROM student ";
	    	List<Student> student1=selectByAll(sql);
	    	for(int k=0;k<student1.size();k++){
			String sql7="SELECT c_flag FROM class where c_id=?";
			Object[] param7={student1.get(k).getcId()};
			int a=oneInt(sql7,param7);
			String sql6="SELECT c_name FROM class where c_id=?";
			Object[] param6={student1.get(k).getcId()};
			String cname=oneString(sql6,param6);
			String sql2="SELECT co_name FROM classone where co_flag=?";
			Object[] param2={a};
			String coname=oneString(sql2,param2);
			String cconame=coname+cname;
			student1.get(k).setcId(cconame);
		}
		 return student1;
	}
	

	@Override
	protected  Student rowMapper(ResultSet rs) {
			Student student = new Student();
			try {
				student.setsId(rs.getString("s_id"));
				student.setsName(rs.getString("s_name"));
                student.setsAcount(rs.getString("s_acount"));
                student.setsPassword(rs.getString("s_password"));
                student.setsSex(rs.getString("s_sex"));
                student.setsIdentifyId(rs.getString("s_identify_id"));
                student.setcId(rs.getString("c_id"));
                student.setsComeTime(rs.getString("s_cometime"));
                student.setsComeAge(rs.getString("s_comeage"));
                student.setsAddress(rs.getString("s_address"));
                student.setsFace(rs.getString("s_face"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		
	}
	public List<Student> selectByClassNannnnn(String cna) throws SQLException{
		int pagesize=20;
	String b[]=cna.split("");
	int siz=b.length;
	String cname="";
	if(siz==4){
		cname=b[2]+b[3];
	}
	if(siz==3){
		cname=b[2];
	}
	String sql7="SELECT co_flag FROM classone where co_name=?";
	String[] param7={b[1]};
    int ccflag=oneInt(sql7,param7);
	String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
	Object[] param={cname,ccflag};
    String ccid=oneString(sql1,param);
	String sql5="SELECT * FROM student WHERE c_id = ?";
	Object[] param5={ccid};
	return selectAll(sql5,param5);

	}
	@Override
	public boolean ifexit(String phone) {
		boolean result=false;
		try {
			result=selectByPnameOrPhone(phone).isEmpty();
			System.out.println("是不是空"+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
