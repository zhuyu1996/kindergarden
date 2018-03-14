package cn.edu.cqupt.camphor_forest.kindergarten.vo;

public class KaixueTime {

	private String k_id;
	public KaixueTime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KaixueTime(String k_id, int k_month, int k_day) {
		super();
		this.k_id = k_id;
		this.k_month = k_month;
		this.k_day = k_day;
	}
	
	public String getK_id() {
		return k_id;
	}
	public void setK_id(String k_id) {
		this.k_id = k_id;
	}
	public int getK_month() {
		return k_month;
	}
	public void setK_month(int k_month) {
		this.k_month = k_month;
	}
	public int getK_day() {
		return k_day;
	}
	public void setK_day(int k_day) {
		this.k_day = k_day;
	}
	private int k_month;
	private int k_day;
	
}
