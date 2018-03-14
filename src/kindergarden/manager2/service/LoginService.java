package kindergarden.manager2.service;

import java.io.IOException;
import java.sql.SQLException;
import kindergarden.manager2.domain.Manager2;
import kindergarden.manager2.impl.LoginDaoImpl;

public class LoginService {
	private LoginDaoImpl loginDaoImpl= new LoginDaoImpl();
	
	public Manager2 selectByTphone(String tphone) throws ClassNotFoundException, SQLException, IOException {
		
		return loginDaoImpl.selectByTphone(tphone);
	}

}
