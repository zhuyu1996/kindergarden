package com.up.entity;

public class Comment {
private int idcomment;
private String name;
private String message;
private int idnews;
private int totalpage;
private String time;
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getTotalpage() {
	return totalpage;
}
public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
}
public int getIdcomment() {
	return idcomment;
}
public void setIdcomment(int idcomment) {
	this.idcomment = idcomment;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public int getIdnews() {
	return idnews;
}
public void setIdnews(int idnews) {
	this.idnews = idnews;
}
@Override
public String toString() {
	return "Comment [idcomment=" + idcomment + ", name=" + name + ", message=" + message + ", idnews=" + idnews
			+ ", totalpage=" + totalpage + "]";
}


}
