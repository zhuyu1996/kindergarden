package kindergarden.manager3.impl;

import java.sql.ResultSet;
import java.sql.SQLException;


import JDBC.JDBCTemplate;

import kindergarden.manager3.dao.LoginDao2;
import kindergarden.manager3.domain.Manager3;

public class LoginDaoImpl2 extends JDBCTemplate<Manager3>implements LoginDao2 {

@Override
public Manager3 selectByMid2(String appid) throws SQLException {
	
	System.out.println("======================="+appid);
	String sql = "SELECT * FROM student where s_acount like ?";
	Object[] params = {"%"+appid+"%"};
	return selectOne(sql, params);
}
@Override
protected Manager3 rowMapper(ResultSet rs) {
	// TODO Auto-generated method stub
	Manager3 manager= new Manager3();
	try {
		manager.setAppid(rs.getString("s_acount"));
		manager.setApppassword(rs.getString("s_password"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return manager;
}

}



