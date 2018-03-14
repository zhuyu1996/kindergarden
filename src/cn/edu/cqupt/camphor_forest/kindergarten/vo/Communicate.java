package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class Communicate {
  
	public Communicate(String comId, String poneId, String ptwoId, String comContent, int comcount, String xId,
			String comTime) {
		super();
		this.comId = comId;
		this.poneId = poneId;
		this.ptwoId = ptwoId;
		this.comContent = comContent;
		this.comcount = comcount;
		this.xId = xId;
		this.comTime = comTime;
	}
	public Communicate() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Communicate [comId=" + comId + ", poneId=" + poneId + ", ptwoId=" + ptwoId + ", comContent="
				+ comContent + ", comcount=" + comcount + ", xId=" + xId + ", comTime=" + comTime + "]";
	}
	public String getComId() {
		return comId;
	}
	public void setComId(String comId) {
		this.comId = comId;
	}
	public String getPoneId() {
		return poneId;
	}
	public void setPoneId(String poneId) {
		this.poneId = poneId;
	}
	public String getPtwoId() {
		return ptwoId;
	}
	public void setPtwoId(String ptwoId) {
		this.ptwoId = ptwoId;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public int getComcount() {
		return comcount;
	}
	public void setComcount(int comcount) {
		this.comcount = comcount;
	}
	public String getxId() {
		return xId;
	}
	public void setxId(String xId) {
		this.xId = xId;
	}
	public String getComTime() {
		return comTime;
	}
	public void setComTime(String comTime) {
		this.comTime = comTime;
	}
	
	
	private String comId;
	private String poneId;
	private String ptwoId;
	private String comContent;
	private int comcount;
	private String xId;
	private String comTime;
}
