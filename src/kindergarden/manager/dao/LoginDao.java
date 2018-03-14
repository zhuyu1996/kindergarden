package kindergarden.manager.dao;

import java.sql.SQLException;

import kindergarden.manager.domain.Manager;

public interface LoginDao {
Manager selectByMid(String mid)throws SQLException;

	}


