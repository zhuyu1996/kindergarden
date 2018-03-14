package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class CollectPhoto {

	public CollectPhoto(String cpid, String cpuserid, String cpname, String cpface) {
		super();
		this.cpid = cpid;
		this.cpuserid = cpuserid;
		this.cpname = cpname;
		this.cpface = cpface;
	}
	public CollectPhoto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CollectPhoto [cpid=" + cpid + ", cpuserid=" + cpuserid + ", cpname=" + cpname + ", cpface=" + cpface
				+ "]";
	}
	public String getCpid() {
		return cpid;
	}
	public void setCpid(String cpid) {
		this.cpid = cpid;
	}
	public String getCpuserid() {
		return cpuserid;
	}
	public void setCpuserid(String cpuserid) {
		this.cpuserid = cpuserid;
	}
	public String getCpname() {
		return cpname;
	}
	public void setCpname(String cpname) {
		this.cpname = cpname;
	}
	public String getCpface() {
		return cpface;
	}
	public void setCpface(String cpface) {
		this.cpface = cpface;
	}
	private String cpid;
	 private String cpuserid;
	 private String cpname;
	 private String cpface;
}
