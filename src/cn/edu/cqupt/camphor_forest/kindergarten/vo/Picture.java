package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class Picture {
   

	public String getXcDate() {
		return xcDate;
	}
	public void setXcDate(String xcDate) {
		this.xcDate = xcDate;
	}
	public String getXcId() {
		return xcId;
	}
	public void setXcId(String xcId) {
		this.xcId = xcId;
	}
	public String getXcAdress() {
		return xcAdress;
	}
	public void setXcAdress(String xcAdress) {
		this.xcAdress = xcAdress;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpLike() {
		return pLike;
	}
	public void setpLike(String pLike) {
		this.pLike = pLike;
	}
	@Override
	public String toString() {
		return "Picture [xcDate=" + xcDate + ", xcId=" + xcId + ", xcAdress=" + xcAdress + ", pId=" + pId + ", pLike="
				+ pLike + "]";
	}
	public Picture() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String xcId;
	private String xcAdress;
	private String pId;
	private String pLike;
	private String xcDate;
}
