package kindergarden.manager2.dao;

import java.sql.SQLException;

import kindergarden.manager2.domain.Manager2;
public interface LoginDao {
Manager2 selectByTphone(String Tphone)throws SQLException;

	}
