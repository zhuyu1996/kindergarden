package kindergarden.manager3.dao;

import java.sql.SQLException;

import kindergarden.manager3.domain.Manager3;

public interface LoginDao {
Manager3 selectByMid(String appid)throws SQLException;
	}


