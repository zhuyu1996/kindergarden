package kindergarden.manager.lmpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import JDBC.JDBCTemplate;
import kindergarden.manager.dao.LoginDao;
import kindergarden.manager.domain.Manager;

public class LoginDaoImpl extends JDBCTemplate<Manager>implements LoginDao {

@Override
public Manager selectByMid(String mid) throws SQLException {
	
	// TODO Auto-generated method stub
	String sql="select * from manager where m_id=?";
	Object[] params={mid};
	return selectOne(sql,params);
}
@Override
protected Manager rowMapper(ResultSet rs) {
	// TODO Auto-generated method stub
	Manager manager= new Manager();
	try {
		manager.setMid(rs.getString("m_id"));
		manager.setMpassword(rs.getString("m_password"));
		manager.setUrl1(rs.getString("url1"));
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return manager;
}

}



