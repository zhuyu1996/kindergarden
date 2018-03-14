package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class Teacher {

	public Teacher(String tId, String tName, String tPhone, String tSex, String tWorkId, String cId, String tgrade,
			String tface) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.tPhone = tPhone;
		this.tSex = tSex;
		this.tWorkId = tWorkId;
		this.cId = cId;
		this.tgrade = tgrade;
		this.tface = tface;
	}
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", tName=" + tName + ", tPhone=" + tPhone + ", tSex=" + tSex + ", tWorkId="
				+ tWorkId + ", cId=" + cId + ", tgrade=" + tgrade + ", tface=" + tface + "]";
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettPhone() {
		return tPhone;
	}
	public void settPhone(String tPhone) {
		this.tPhone = tPhone;
	}
	public String gettSex() {
		return tSex;
	}
	public void settSex(String tSex) {
		this.tSex = tSex;
	}
	public String gettWorkId() {
		return tWorkId;
	}
	public void settWorkId(String tWorkId) {
		this.tWorkId = tWorkId;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getTgrade() {
		return tgrade;
	}
	public void setTgrade(String tgrade) {
		this.tgrade = tgrade;
	}
	public String getTface() {
		return tface;
	}
	public void setTface(String tface) {
		this.tface = tface;
	}
	private String tId;
	private String tName;
	private String tPhone;
	private String tSex;
	private String tWorkId;
	private String cId;
    private String tgrade;
    private String tface;
	
}
