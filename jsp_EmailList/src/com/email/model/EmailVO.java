package com.email.model;

public class EmailVO {
	int no;
	String last_name;
	String first_name;
	String email;
	
	public EmailVO() {}

	public EmailVO(int no, String last_name, String first_name, String email) {
		this.no = no;
		this.last_name = last_name;
		this.first_name = first_name;
		this.email = email;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "EmailVO [no=" + no + ", last_name=" + last_name + ", first_name=" + first_name + ", email=" + email
				+ "]";
	}
	
}
