package com.bridgelabz.fundoonotes.dto;

import javax.persistence.Column;

import com.sun.istack.NotNull;

public class LoginDTO 
{
	@NotNull
	@Column(unique = true)
	private String emailId;
	
	@NotNull
	private String password;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [emailId=" + emailId + ", password=" + password + "]";
	}

	
	
	
	
	

}
