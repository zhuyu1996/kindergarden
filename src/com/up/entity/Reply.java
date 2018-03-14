package com.up.entity;

public class Reply {
	 private int idcomment;
	 private String a;
private int totalpage;
	private String b;
	 private String message;
	 private int idreply;
	 private String time;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getIdreply() {
			return idreply;
		}
		public void setIdreply(int idreply) {
			this.idreply = idreply;
		}
	public int getIdcomment() {
		return idcomment;
	}
	public void setIdcomment(int idcomment) {
		this.idcomment = idcomment;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	@Override
	public String toString() {
		return "Reply [idcomment=" + idcomment + ", a=" + a + ", totalpage=" + totalpage + ", b=" + b + ", message="
				+ message + ", idreply=" + idreply + "]";
	}
	
	
	 
}
