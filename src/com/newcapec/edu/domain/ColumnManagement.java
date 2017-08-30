package com.newcapec.edu.domain;

import java.util.List;

public class ColumnManagement {
	private int counts;
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	private int department_id;
	private int department_num;
	private String department_name;
	private List<News> news;
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getDepartment_num() {
		return department_num;
	}
	public void setDepartment_num(int department_num) {
		this.department_num = department_num;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	

}
