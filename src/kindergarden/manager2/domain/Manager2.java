package kindergarden.manager2.domain;

public class Manager2 {
	private String tId;
	private String tName;
	private String tPhone;
	private String tSex;
	private String tWorkId;
	private String cId;
    private String tgrade;
    private String t_face;
	public String getT_face() {
		return t_face;
	}
	public void setT_face(String t_face) {
		this.t_face = t_face;
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
	@Override
	public String toString() {
		return "Manager2 [tId=" + tId + ", tName=" + tName + ", tPhone=" + tPhone + ", tSex=" + tSex + ", tWorkId="
				+ tWorkId + ", cId=" + cId + ", tgrade=" + tgrade + ", t_face=" + t_face + "]";
	}
	public void setTgrade(String tgrade) {
		this.tgrade = tgrade;
	}
	

}
