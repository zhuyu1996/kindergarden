package kindergarden.manager2.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import JDBC.JDBCTemplate;
import kindergarden.manager.domain.Manager;
import kindergarden.manager2.dao.LoginDao;
import kindergarden.manager2.domain.Manager2;

public class LoginDaoImpl extends JDBCTemplate<Manager2> implements LoginDao{
@Override
public Manager2 selectByTphone(String tphone) throws SQLException {
	// TODO Auto-generated method stub
	String sql="select * from teacher where t_phone=?";
	Object[] params={tphone};
	return selectOne(sql,params);
}
@Override
protected Manager2 rowMapper(ResultSet rs) {
	// TODO Auto-generated method stub
		Manager2 manager= new Manager2();
		try {
			manager.settId(rs.getString("t_id"));
			manager.settName(rs.getString("t_name"));
			manager.settPhone(rs.getString("t_phone"));
			manager.settWorkId(rs.getString("t_work_id"));
			manager.setcId(rs.getString("c_id"));
			manager.setTgrade(rs.getString("t_grade"));
			manager.settSex(rs.getString("t_sex"));
			manager.setT_face(rs.getString("t_face"));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manager;
	}
}

