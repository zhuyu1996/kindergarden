package kindergarden.manager3.domain;

public class Student {
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
public String getsSex() {
		return sSex;
	}
	public void setsSex(String sSex) {
		this.sSex = sSex;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsIdentifyId() {
		return sIdentifyId;
	}
	public void setsIdentifyId(String sIdentifyId) {
		this.sIdentifyId = sIdentifyId;
	}
	public String getsComeAge() {
		return sComeAge;
	}
	public void setsComeAge(String sComeAge) {
		this.sComeAge = sComeAge;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getsComeTime() {
		return sComeTime;
	}
	public void setsComeTime(String sComeTime) {
		this.sComeTime = sComeTime;
	}
	public String getsAcount() {
		return sAcount;
	}
	public void setsAcount(String sAcount) {
		this.sAcount = sAcount;
	}
	public String getsPassword() {
		return sPassword;
	}
	public void setsPassword(String sPassword) {
		this.sPassword = sPassword;
	}
	public String getsId() {
		return sId;
	}
	public void setsId(String sId) {
		this.sId = sId;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
@Override
public String toString() {
	return "Student [sSex=" + sSex + ", sName=" + sName + ", sIdentifyId=" + sIdentifyId + ", sComeAge=" + sComeAge
			+ ", cId=" + cId + ", sComeTime=" + sComeTime + ", sAcount=" + sAcount + ", sPassword=" + sPassword
			+ ", sId=" + sId + ", sAddress=" + sAddress + ", sface=" + sface + "]";
}
public Student(String sSex, String sName, String sIdentifyId, String sComeAge, String cId, String sComeTime,
			String sAcount, String sPassword, String sId, String sAddress) {
		super();
		this.sSex = sSex;
		this.sName = sName;
		this.sIdentifyId = sIdentifyId;
		this.sComeAge = sComeAge;
		this.cId = cId;
		this.sComeTime = sComeTime;
		this.sAcount = sAcount;
		this.sPassword = sPassword;
		this.sId = sId;
		this.sAddress = sAddress;
		this.sface=sface;
	}
private String sSex;  //性别
  private String sName;  //学生名字
private String sIdentifyId;  //身份证
  private String sComeAge;    //入学年龄
  private String cId;    //班级名
  private String sComeTime;   //入学时间
  private String sAcount;    //家长信息
  private String sPassword;  //密码
 private String sId;     //学生id
 private String sAddress;   //家庭地址
 private String sface;
public String getSface() {
	return sface;
}
public void setSface(String sface) {
	this.sface = sface;
}


  
}
