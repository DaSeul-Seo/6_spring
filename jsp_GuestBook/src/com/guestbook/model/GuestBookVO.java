package com.guestbook.model;

import java.sql.Date;

public class GuestBookVO {
	int no;
	String name;
	String password;
	String content;
	Date reg_date;
	
	public GuestBookVO() {}

	public GuestBookVO(int no, String name, String password, String content, Date reg_date) {
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.reg_date = reg_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "GuestBookVO [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", reg_date=" + reg_date + "]";
	}
}
