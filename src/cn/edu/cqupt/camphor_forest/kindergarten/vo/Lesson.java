package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class Lesson {

	public String getlId() {
		return lId;
	}
	public void setlId(String lId) {
		this.lId = lId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getlWeek() {
		return lWeek;
	}
	public void setlWeek(String lWeek) {
		this.lWeek = lWeek;
	}
	public String getlMon() {
		return lMon;
	}
	public void setlMon(String lMon) {
		this.lMon = lMon;
	}
	public String getlTue() {
		return lTue;
	}
	public void setlTue(String lTue) {
		this.lTue = lTue;
	}
	public String getlWed() {
		return lWed;
	}
	public void setlWed(String lWed) {
		this.lWed = lWed;
	}
	public String getlThu() {
		return lThu;
	}
	public void setlThu(String lThu) {
		this.lThu = lThu;
	}
	public String getLfri() {
		return lfri;
	}
	public void setLfri(String lfri) {
		this.lfri = lfri;
	}

     public Lesson() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getWorkimportant() {
		return workimportant;
	}
	public void setWorkimportant(String workimportant) {
		this.workimportant = workimportant;
	}

		@Override
	public String toString() {
		return "Lesson [lId=" + lId + ", cName=" + cName + ", lWeek=" + lWeek + ", lMon=" + lMon + ", lTue=" + lTue
				+ ", lWed=" + lWed + ", lThu=" + lThu + ", lfri=" + lfri + ", workimportant=" + workimportant
				+ ", shuxin=" + shuxin + ", lsat=" + lsat + ", lsun=" + lsun + "]";
	}
		public Lesson(String lId, String cName, String lWeek, String lMon, String lTue, String lWed, String lThu,
			String lfri, String workimportant, String shuxin, String lsat, String lsun) {
		super();
		this.lId = lId;
		this.cName = cName;
		this.lWeek = lWeek;
		this.lMon = lMon;
		this.lTue = lTue;
		this.lWed = lWed;
		this.lThu = lThu;
		this.lfri = lfri;
		this.workimportant = workimportant;
		this.shuxin = shuxin;
		this.lsat = lsat;
		this.lsun = lsun;
	}
		public String getLsat() {
		return lsat;
	}
	public void setLsat(String lsat) {
		this.lsat = lsat;
	}
	public String getLsun() {
		return lsun;
	}
	public void setLsun(String lsun) {
		this.lsun = lsun;
	}

		private String lId;
	private String cName;  //班级名    
     private String lWeek;  //第几周
     private String lMon;   //星期一
     private String lTue;   //星期二
     private String lWed;   //星期三
     private String lThu;   //星期四
     private String lfri;   //星期五
     private String workimportant;//工作重点
 	private String shuxin;  //课程的属性
 	private String lsat;  //6
 	private String lsun;    //天
 	
     public String getShuxin() {
		return shuxin;
	}
	public void setShuxin(String shuxin) {
		this.shuxin = shuxin;
	}

    
 
}
