package kindergarden.manager3.dao;

import java.sql.SQLException;

import kindergarden.manager3.domain.Manager3;

public interface LoginDao2 {
Manager3 selectByMid2(String appid)throws SQLException;
	}


