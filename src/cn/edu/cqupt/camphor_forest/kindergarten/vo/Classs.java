package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class Classs{
    public Classs(String cId, String cName, String tTeacher, int sNumber) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.tTeacher = tTeacher;
		this.sNumber = sNumber;
	}
	public Classs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String gettTeacher() {
		return tTeacher;
	}
	public void settTeacher(String tTeacher) {
		this.tTeacher = tTeacher;
	}
	public int getsNumber() {
		return sNumber;
	}
	public void setsNumber(int sNumber) {
		this.sNumber = sNumber;
	}
	private String cId;
    private String cName;
    private String tTeacher; 
	private int sNumber;
}
