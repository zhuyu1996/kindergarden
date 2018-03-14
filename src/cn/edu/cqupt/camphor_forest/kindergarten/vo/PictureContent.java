package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class PictureContent {
 
	
	public PictureContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PictureContent(String picid, String picname, String picmdescribe, String picdate, String picface,
			String cid) {
		super();
		this.picid = picid;
		this.picname = picname;
		this.picmdescribe = picmdescribe;
		this.picdate = picdate;
		this.picface = picface;
		this.cid = cid;
	}
	@Override
	public String toString() {
		return "PictureContent [picid=" + picid + ", picname=" + picname + ", picmdescribe=" + picmdescribe
				+ ", picdate=" + picdate + ", picface=" + picface + ", cid=" + cid + "]";
	}
	public String getPicid() {
		return picid;
	}
	public void setPicid(String picid) {
		this.picid = picid;
	}
	public String getPicname() {
		return picname;
	}
	public void setPicname(String picname) {
		this.picname = picname;
	}
	public String getPicmdescribe() {
		return picmdescribe;
	}
	public void setPicmdescribe(String picmdescribe) {
		this.picmdescribe = picmdescribe;
	}
	public String getPicdate() {
		return picdate;
	}
	public void setPicdate(String picdate) {
		this.picdate = picdate;
	}
	public String getPicface() {
		return picface;
	}
	public void setPicface(String picface) {
		this.picface = picface;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	private String picid;
	private String picname;
	private String picmdescribe;
	private String picdate;
	private String picface;
	private String cid;
}
