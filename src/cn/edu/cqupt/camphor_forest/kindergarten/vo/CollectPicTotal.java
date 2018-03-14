package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class CollectPicTotal {

	public CollectPicTotal() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CollectPicTotal(String xcId, String xcAdress, String pId, String xcDate) {
		super();
		this.xcId = xcId;
		this.xcAdress = xcAdress;
		this.pId = pId;
		this.xcDate = xcDate;
	}
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

	@Override
	public String toString() {
		return "Picture [xcDate=" + xcDate + ", xcId=" + xcId + ", xcAdress=" + xcAdress + ", pId=" + pId  + "]";
	}
	
	
	private String xcId;
	private String xcAdress;
	private String pId;
	private String xcDate;
}
