package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class MovieContent {
	

	public MovieContent(String mcid, String mcpeople, String mctime, String mccontent, String mcclassid) {
		super();
		this.mcid = mcid;
		this.mcpeople = mcpeople;
		this.mctime = mctime;
		this.mccontent = mccontent;
		this.mcclassid = mcclassid;
	}
	public MovieContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMcid() {
		return mcid;
	}
	public void setMcid(String mcid) {
		this.mcid = mcid;
	}
	public String getMcpeople() {
		return mcpeople;
	}
	public void setMcpeople(String mcpeople) {
		this.mcpeople = mcpeople;
	}
	public String getMctime() {
		return mctime;
	}
	public void setMctime(String mctime) {
		this.mctime = mctime;
	}
	public String getMccontent() {
		return mccontent;
	}
	public void setMccontent(String mccontent) {
		this.mccontent = mccontent;
	}
	public String getMcclassid() {
		return mcclassid;
	}
	public void setMcclassid(String mcclassid) {
		this.mcclassid = mcclassid;
	}
	@Override
	public String toString() {
		return "MovieContent [mcid=" + mcid + ", mcpeople=" + mcpeople + ", mctime=" + mctime + ", mccontent="
				+ mccontent + ", mcclassid=" + mcclassid + "]";
	}
	private String mcpeople;
	private String mctime;
	private String mccontent;
	private String mcclassid;
 	private String mcid;
}
