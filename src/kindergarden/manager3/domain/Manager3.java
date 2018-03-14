package kindergarden.manager3.domain;

public class Manager3 {
	private String Appid;
	private String Apppassword;
	public String getAppid() {
		return Appid;
	}
	public void setAppid(String appid) {
		Appid = appid;
	}
	public String getApppassword() {
		return Apppassword;
	}
	public void setApppassword(String apppassword) {
		Apppassword = apppassword;
	}
	@Override
	public String toString() {
		return "Manager3 [Appid=" + Appid + ", Apppassword=" + Apppassword + "]";
	}
	
}
	
	

	

