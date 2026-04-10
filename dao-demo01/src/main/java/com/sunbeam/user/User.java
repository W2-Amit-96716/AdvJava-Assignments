package com.sunbeam.user;

import java.sql.Date;

// It is POJO class for user
public class User {
	private int id;
	private String name;
	private String passwd;
	private String email;
	private String addr;
	private String role;
	private Date bitrh;
	
	
	public User() {
		super();
	}
	public User(int id, String name, String passwd, String email, String addr, String role, Date bitrh) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.email = email;
		this.addr = addr;
		this.role = role;
		this.bitrh = bitrh;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getBitrh() {
		return bitrh;
	}
	public void setBitrh(Date bitrh) {
		this.bitrh = bitrh;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", passwd=" + passwd + ", email=" + email + ", addr=" + addr
				+ ", role=" + role + ", bitrh=" + bitrh + "]";
	}
	
	
}
