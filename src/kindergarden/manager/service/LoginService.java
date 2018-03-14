package kindergarden.manager.service;

import java.io.IOException;
import java.sql.SQLException;
import kindergarden.manager.domain.Manager;
import kindergarden.manager.lmpl.LoginDaoImpl;

public class LoginService {
	private LoginDaoImpl loginDaoImpl= new LoginDaoImpl();
	public Manager selectByMid(String mid) throws ClassNotFoundException, SQLException, IOException {
		return loginDaoImpl.selectByMid(mid);
	}
	

}
