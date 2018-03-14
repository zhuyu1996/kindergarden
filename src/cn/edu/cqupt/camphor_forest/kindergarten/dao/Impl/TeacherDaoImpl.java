package cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.TeacherDao;
import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Teacher;


public class TeacherDaoImpl extends JDBCTemplates<Teacher> implements TeacherDao{

	@Override
	public String insert(Teacher teacher) throws SQLException {
		String z[]=teacher.getcId().split(",");
		String sql7="SELECT co_flag FROM classone where co_name=?";
		String[] param7={z[0]};
        int ccflag=oneInt(sql7,param7);
		String sql1="SELECT c_id FROM class where c_name=? and c_flag=?";
		Object[] param={z[1],ccflag};
        String ccid=oneString(sql1,param);
        System.out.println(ccid);
		String sql="INSERT INTO teacher(t_id,t_name,t_phone,t_work_id,c_id,t_grade,t_sex,t_face)VALUES(?,?,?,?,?,?,?,?)";
		 String face="http://119.29.225.57:8080/photo/9/9/b1cca2b3e791469eb4fab53f1a025200.png";
		Object[] params={UUID.randomUUID().toString().replace("-",""),teacher.gettName(),teacher.gettPhone(),teacher.gettWorkId(),ccid,teacher.getTgrade(),teacher.gettSex(),face};
		update(sql,params);
		return params[0].toString();
	}

	@Override
	public int deleteById(String tid) throws SQLException {
		String sql="DELETE FROM teacher WHERE t_id=?";
		Object[] param={tid};
		return update(sql,param);
	}

	@Override
	public List<Teacher> selectByName(String name) throws SQLException {
		String sql = "SELECT * FROM teacher where t_name = ?";
		Object[] params = {name};
		List<Teacher> Teacher=selectAll(sql, params);
		for(int i=0;i<Teacher.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.get(i).setcId(cconame);
		}
		return Teacher;
	}

	@Override
	public List<Teacher> selectByPhone(String phone) throws SQLException {
		String sql = "SELECT * FROM teacher where t_phone = ?";
		Object[] params = {phone};
		List<Teacher> Teacher=selectAll(sql, params);
		for(int i=0;i<Teacher.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.get(i).setcId(cconame);
		}
		return Teacher;
	}

	@Override
	public  List<Teacher> selectByClassId(String cid) throws SQLException {
		//班级名
		String b[]=cid.split("");
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
		String sql5="SELECT * FROM teacher WHERE c_id = ?";
		Object[] param5={ccid};
		return selectAll(sql5,param5);
	}
	@Override
	public Teacher selectBytId(String tid) throws SQLException {
		String sql = "SELECT * FROM teacher where t_id = ?";
		Object[] params = {tid};
		Teacher teacher=selectOne(sql, params);
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={teacher.getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={teacher.getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		teacher.setcId(cconame);
		return teacher;
	}
	@Override
	public int updateByUuid(Teacher teacher) throws SQLException {
		String sql="UPDATE teacher SET t_name=?,t_phone=?,t_work_id=?,c_id=?,t_grade=?,t_sex=? WHERE t_id=?";
		Object[] params={teacher.gettName(),teacher.gettPhone(),teacher.gettWorkId(),teacher.getcId(),teacher.getTgrade(),teacher.gettSex(),teacher.gettId()};
	    return update(sql, params);
	}


	@Override
	public int updateTFace(String tface, String tid) throws SQLException {
		String sql="UPDATE teacher SET t_face=? WHERE t_id=?";
		Object[] params={tface,tid};
	    return update(sql, params);
	}
	
	
	@Override
	public List<Teacher> selectAll() throws SQLException {
		String sql="SELECT * FROM teacher";
		List<Teacher> Teacher=selectByAll(sql);
		for(int i=0;i<Teacher.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.get(i).setcId(cconame);
		}
		return Teacher;
	}

	
	@Override
	protected Teacher rowMapper(ResultSet rs) {
		Teacher teacher = new Teacher();
		try {
			teacher.settId(rs.getString("t_id"));
			teacher.settName(rs.getString("t_name"));
			teacher.settPhone(rs.getString("t_phone"));
			teacher.settWorkId(rs.getString("t_work_id"));
			teacher.setcId(rs.getString("c_id"));
			teacher.setTgrade(rs.getString("t_grade"));
			teacher.settSex(rs.getString("t_sex"));
			teacher.setTface(rs.getString("t_face"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public Teacher selectByPhonelogin(String phone) throws SQLException {
		String sql = "SELECT * FROM teacher where t_phone = ?";
		Object[] params = {phone};
		Teacher Teacher=selectOne(sql, params);
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.setcId(cconame);
		return Teacher;
	}

	@Override
	public List<Teacher> selectByclasst(String classid) throws SQLException{
		String b[]=classid.split("");
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
		Object[] param1={cname,ccflag};
        String ccid=oneString(sql1,param1);
        String sql = "SELECT * FROM teacher where c_id = ?";
        Object[] param={ccid};
		return selectAll(sql,param);
	}

	@Override
	public List<Teacher> selectbyBaoYu() throws SQLException {
		String sql="SELECT * FROM teacher where t_grade=?";
		Object[] paramss={"保育员"};
		List<Teacher> Teacher=selectAll(sql,paramss);
		for(int i=0;i<Teacher.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.get(i).setcId(cconame);
		}
		return Teacher;
	}

	@Override
	public List<Teacher> selectbymonitor() throws SQLException {
		String sql="SELECT * FROM teacher where t_grade=?";
		Object[] paramss={"班主任"};
		List<Teacher> Teacher=selectAll(sql,paramss);
		for(int i=0;i<Teacher.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.get(i).setcId(cconame);
		}
		return Teacher;
	}

	@Override
	public List<Teacher> selectbycommontea() throws SQLException {
		String sql="SELECT * FROM teacher where t_grade=?";
		Object[] paramss={"老师"};
		List<Teacher> Teacher=selectAll(sql,paramss);
		for(int i=0;i<Teacher.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		Object[] param={Teacher.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		String sql3="SELECT c_name FROM class where c_id=?";
		Object[] param3={Teacher.get(i).getcId().toString()};
		String cname=oneString(sql3,param3);
		String sql2="SELECT co_name FROM classone where co_flag=? ";
		Object[] param2={t};
		String coname=oneString(sql2,param2);
		String cconame=coname+cname;
		Teacher.get(i).setcId(cconame);
		}
		return Teacher;
	}

	@Override
	public boolean isexit(String phone) {
		boolean result=false;
		String sql = "SELECT * FROM teacher where t_phone = ?";
		Object[] params = {phone};
		List<Teacher> Teacher=selectAll(sql, params);
		System.out.println("老师为"+Teacher);
		if(Teacher.isEmpty()){
			result=true;
		}

		return result;
	}



}
