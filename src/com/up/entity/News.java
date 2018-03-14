package com.up.entity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class News {
private int idnews;
private String issuer;
private String time;
private String state;
private String title;
private String message;
private String kind;
private String url1;
private String url2;
private String cid;


public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
private int totalPage;


public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}

public String getUrl1() {
	return url1;
}
public void setUrl1(String url1) {
	this.url1 = url1;
}


public String getUrl2() {
	return url2;
}
public void setUrl2(String string) {
	this.url2 =  string;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time =time ;
}
public int getIdnews() {
	return idnews;
}
public void setIdnews(int idnews) {
	this.idnews = idnews;
}

public String getIssuer() {
	return issuer;
}
public void setIssuer(String issuer) {
	this.issuer = issuer;
}

public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getKind() {
	return kind;
}
public void setKind(String kind) {
	this.kind = kind;
}
@Override
public String toString() {
	return "News [idnews=" + idnews + ", issuer=" + issuer + ", time=" + time + ", state=" + state + ", title=" + title
			+ ", message=" + message + ", kind=" + kind + ", url1=" + url1 + ", url2=" + url2 + ", cid=" + cid
			+ ", totalPage=" + totalPage + "]";
}



}
