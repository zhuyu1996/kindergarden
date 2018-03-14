package kindergarden.manager3.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import JDBC.JDBCTemplate;
import kindergarden.manager3.dao.LoginDao;
import kindergarden.manager3.domain.Manager3;

public class LoginDaoImpl extends JDBCTemplate<Manager3>implements LoginDao {

@Override
public Manager3 selectByMid(String appid) throws SQLException {
	
	System.out.println("======================="+appid);
	// TODO Auto-generated method stub
	String sql="select * from teacher where t_phone=?";
	Object[] params={appid};
	return selectOne(sql,params);
}

@Override
protected Manager3 rowMapper(ResultSet rs) {
	// TODO Auto-generated method stub
	Manager3 manager= new Manager3();
	
	try {
		manager.setAppid(rs.getString("t_phone"));
		manager.setApppassword(rs.getString("t_work_id"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return manager;
}

}



