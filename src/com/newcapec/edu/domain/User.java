package com.newcapec.edu.domain;

public class User {
	/*
	 * 用户实体类的创建
	 */

	private String username;
	private String password;
	private int level;
	private String code;
	private int state;
	private String email;
	/**
	 * 
	 */
	private Manage manage;
	public Manage getManage() {
		return manage;
	}
	public void setManage(Manage manage) {
		this.manage = manage;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
