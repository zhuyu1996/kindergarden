package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class CollectMovie {

        public CollectMovie() {
		super();
		// TODO Auto-generated constructor stub
	}
		public CollectMovie(String cmname, String cmid, String cmuserid) {
		super();
		this.cmname = cmname;
		this.cmid = cmid;
		this.cmuserid = cmuserid;
	}
		@Override
	public String toString() {
		return "CollectMovie [cmname=" + cmname + ", cmid=" + cmid + ", cmuserid=" + cmuserid + "]";
	}
		public String getCmname() {
		return cmname;
	}
	public void setCmname(String cmname) {
		this.cmname = cmname;
	}
	public String getCmid() {
		return cmid;
	}
	public void setCmid(String cmid) {
		this.cmid = cmid;
	}
	public String getCmuserid() {
		return cmuserid;
	}
	public void setCmuserid(String cmuserid) {
		this.cmuserid = cmuserid;
	}
		private String cmname;
		private String cmid;
	    private String cmuserid;
}
