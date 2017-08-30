package com.newcapec.edu.domain;

public class News {
private int news_id;
private String title;
private int department_id; //这是
private String mian_img;
private String detail;
private String keyword;
private int top;
private int state;
private String user_id;
private String codeValue;
private String startTime;
private String endTime;
public int getNews_id() {
	return news_id;
}
public void setNews_id(int news_id) {
	this.news_id = news_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}

public int getDepartment_id() {
	return department_id;
}
public void setDepartment_id(int department_id) {
	this.department_id = department_id;
}
public String getMian_img() {
	return mian_img;
}
public void setMian_img(String mian_img) {
	this.mian_img = mian_img;
}
public String getDetail() {
	return detail;
}
public void setDetail(String detail) {
	this.detail = detail;
}
public String getKeyword() {
	return keyword;
}
public void setKeyword(String keyword) {
	this.keyword = keyword;
}
public int getTop() {
	return top;
}
public void setTop(int top) {
	this.top = top;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}


public String getUser_id() {
	return user_id;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
public String getCodeValue() {
	return codeValue;
}
public void setCodeValue(String codeValue) {
	this.codeValue = codeValue;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}


}
