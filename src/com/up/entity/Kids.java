package com.up.entity;

public class Kids {
	private int idkids;
	private String kidsName;
	private String kidsPhone;
	private String kidskind;
	
	
	public String getKidskind() {
		return kidskind;
	}
	public void setKidskind(String kidskind) {
		this.kidskind = kidskind;
	}
	public int getIdkids() {
		return idkids;
	}
	public void setIdkids(int idkids) {
		this.idkids = idkids;
	}
	public String getKidsName() {
		return kidsName;
	}
	public void setKidsName(String kidsName) {
		this.kidsName = kidsName;
	}
	public String getKidsPhone() {
		return kidsPhone;
	}
	public void setKidsPhone(String kidsPhone) {
		this.kidsPhone = kidsPhone;
	}
	@Override
	public String toString() {
		return "Kids [idkids=" + idkids + ", kidsName=" + kidsName + ", kidsPhone=" + kidsPhone + ", kidskind="
				+ kidskind + "]";
	}
	
}
