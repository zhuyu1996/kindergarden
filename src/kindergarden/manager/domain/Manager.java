package kindergarden.manager.domain;

public class Manager {
	private String Mid;
	private String Mpassword;
	private String url1;
	public String getMid() {
		return Mid;
	}
	public void setMid(String mid) {
		Mid = mid;
	}
	public String getUrl1() {
		return url1;
	}
	public void setUrl1(String url1) {
		this.url1 = url1;
	}
	public String getMpassword() {
		return Mpassword;
	}
	public void setMpassword(String mpassword) {
		Mpassword = mpassword;
	}
	@Override
	public String toString() {
		return "Manager [Mid=" + Mid + ", Mpassword=" + Mpassword + ", url1=" + url1 + "]";
	}
	
	

	
}
