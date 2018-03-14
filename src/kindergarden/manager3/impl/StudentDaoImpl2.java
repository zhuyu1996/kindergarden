package kindergarden.manager3.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;



import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import kindergarden.manager3.dao.StudentDao;
import kindergarden.manager3.domain.Student;



public class StudentDaoImpl2 extends JDBCTemplates<Student> implements StudentDao{

	@Override
	public int insert(Student student) throws SQLException {
		String sql="INSERT INTO student (s_id,s_name,s_acount,s_password,s_sex,s_identify_id,c_id,s_cometime,s_comeage,s_address)VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] params={UUID.randomUUID().toString().replace("-",""),student.getsName(),student.getsAcount(),"123456",student.getsSex(),student.getsIdentifyId(),student.getcId(),student.getsComeTime(),student.getsComeAge(),student.getsAddress()};
		return update(sql,params);
	}

	@Override
	public int deleteById(String sid) throws SQLException {
		String sql="DELETE FROM student WHERE s_id=?";	
		Object[] param={sid};
		return update(sql,param);
	}

	@Override
	public int updateByUuid(Student student) throws SQLException {
		String sql="UPDATE student SET s_name=?,s_acount=?,s_password=?,s_sex=?,s_identify_id=?,c_id=?,s_cometime=?,s_comeage=?,s_address=? WHERE s_id=?";
		System.out.println("jinlai");
		Object[] params={student.getsName(),student.getsAcount(),student.getsPassword(),student.getsSex(),student.getsIdentifyId(),student.getcId(),student.getsComeTime(),student.getsComeAge(),student.getsAddress(),student.getsId()};
	    return update(sql, params);
	}

	@Override
	public List<Student> selectBySname(String sname) throws SQLException {
		String sql = "SELECT * FROM student where s_name = ?";
		Object[] params = {sname};
		return selectAll(sql, params);
	}
public  Student selectbyphone(String phone){
	String sql="SELECT * FROM student where s_acount like ?";
	Object[]  params = {"%"+phone+"%"};
	Student student=selectOne(sql, params);
	String sql1="SELECT c_flag FROM class where c_id=?";
	Object[] param={student.getcId().toString()};
	int t=oneInt(sql1,param);
	String sql3="SELECT c_name FROM class where c_id=?";
	Object[] param3={student.getcId().toString()};
	String cname=oneString(sql3,param3);
	String sql2="SELECT co_name FROM classone where co_flag=?";
	Object[] param2={t};
	String coname=oneString(sql2,param2);
	String cconame=coname+cname;
	student.setcId(cconame);
	return student; 
}
	@Override   //
	public List<Student> selectByPnameOrPhone(String pnamephone) throws SQLException {
		String sql = "SELECT * FROM student where s_acount like ?";
		Object[] params = {"%"+pnamephone+"%"};
		List<Student> student=selectAll(sql, params);
		for(int i=0;i<student.size();i++){
		String sql1="SELECT c_flag FROM class where c_id=?";
		System.out.println(student.get(i).getcId().toString());
		Object[] param={student.get(i).getcId().toString()};
		int t=oneInt(sql1,param);
		System.out.println(t);
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
	
	@Override
	public List<Student> selectByClassId(String cid) throws SQLException {
		String sql = "SELECT * FROM student WHERE c_id = ?";
		Object[] params = {cid};
		return selectAll(sql, params);
	}

	@Override
	public Student selectBytId(String sid) throws SQLException {
		String sql = "SELECT * FROM student where s_id = ?";
		Object[] params = {sid};
		return selectOne(sql, params);
	}

	@Override
	public List<Student> selectAll() throws SQLException {
		String sql="SELECT * FROM student";
	    return selectByAll(sql);
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
                student.setsComeAge(rs.getString("s_comeage"));
                student.setsComeTime(rs.getString("s_cometime"));
                student.setsAddress(rs.getString("s_address"));
                student.setSface(rs.getString("s_face"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		
	}

}
