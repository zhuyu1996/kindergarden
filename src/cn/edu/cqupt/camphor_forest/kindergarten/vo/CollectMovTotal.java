package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class CollectMovTotal {
	public CollectMovTotal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CollectMovTotal(String mvDate, String mvId, String mvAdress, String mcId, String mface) {
		super();
		this.mvDate = mvDate;
		this.mvId = mvId;
		this.mvAdress = mvAdress;
		this.mcId = mcId;
		this.mface = mface;
	}

	@Override
	public String toString() {
		return "Movie [mvDate=" + mvDate + ", mvId=" + mvId + ", mvAdress=" + mvAdress +  ", mcId=" + mcId + ", mface=" + mface + "]";
	}

	public String getMvDate() {
		return mvDate;
	}
	public void setMvDate(String mvDate) {
		this.mvDate = mvDate;
	}
	public String getMvId() {
		return mvId;
	}
	public void setMvId(String mvId) {
		this.mvId = mvId;
	}
	public String getMvAdress() {
		return mvAdress;
	}
	public void setMvAdress(String mvAdress) {
		this.mvAdress = mvAdress;
	}
	public String getMcId() {
		return mcId;
	}
	public void setMcId(String mcId) {
		this.mcId = mcId;
	}
	public String getMface() {
		return mface;
	}
	public void setMface(String mface) {
		this.mface = mface;
	}
	private String mvDate;
	private String mvId;
	private String mvAdress;
	private String mcId;  //视频册id
	private String mface;
	
}
