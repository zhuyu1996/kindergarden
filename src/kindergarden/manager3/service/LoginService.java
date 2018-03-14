package kindergarden.manager3.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import cn.edu.cqupt.camphor_forest.kindergarten.dao.Impl.StudentDaoImpl;
import kindergarden.manager3.domain.Manager3;
import kindergarden.manager3.impl.LoginDaoImpl;
import kindergarden.manager3.impl.LoginDaoImpl2;

public class LoginService {
	private LoginDaoImpl loginDaoImpl= new LoginDaoImpl();
	private LoginDaoImpl2 loginDaoImpl2= new LoginDaoImpl2();
	 
	public Manager3 selectByMid(String appid) throws ClassNotFoundException, SQLException, IOException {
		
		return loginDaoImpl.selectByMid(appid);
	}
	public Manager3 selectByMid2(String appid) throws ClassNotFoundException, SQLException, IOException {
		
		return loginDaoImpl2.selectByMid2(appid);
	}

}
