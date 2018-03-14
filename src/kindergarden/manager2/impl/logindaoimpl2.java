package kindergarden.manager2.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cqupt.camphor_forest.kindergarten.utls.JDBCTemplates;
import cn.edu.cqupt.camphor_forest.kindergarten.vo.Student;

public class logindaoimpl2 extends JDBCTemplates<Student> {
	public Student selectByPhone(String phone) throws SQLException {

		System.out.println("查找acount");
		String sql = "SELECT * FROM student where s_acount like ?";
		Object[] params = {"%"+phone+"%"};	
		Student student=selectOne(sql, params);
		return student;
		}
		
		
		@Override
		protected Student rowMapper(ResultSet rs) {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}
}
