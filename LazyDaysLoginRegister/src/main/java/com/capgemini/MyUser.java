package com.capgemini;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="userlist")
public class MyUser {
	
		
	private String userName;
	
	private String userMail;
	
	 private String phone;
	
	private String password;
	
	String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public MyUser()
	{
		super();
	}

	public MyUser(String userName, String userMail, String phone, String password) {
		super();
		this.userName = userName;
		this.userMail = userMail;
		this.phone = phone;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
