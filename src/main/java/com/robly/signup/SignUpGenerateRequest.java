package com.robly.signup;

public class SignUpGenerateRequest {
	
	private String lname = null;
	
	private String fname = null;
	
	private String email = null;
	
	private boolean doubleOptIn = false;
	private boolean welcomeEmail = false;
	
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isDoubleOptIn() {
		return doubleOptIn;
	}

	public void setDoubleOptIn(boolean doubleOptIn) {
		this.doubleOptIn = doubleOptIn;
	}

	public boolean isWelcomeEmail() {
		return welcomeEmail;
	}

	public void setWelcomeEmail(boolean welcomeEmail) {
		this.welcomeEmail = welcomeEmail;
	}

	public boolean isIncludeAutoresponder() {
		return includeAutoresponder;
	}

	public void setIncludeAutoresponder(boolean includeAutoresponder) {
		this.includeAutoresponder = includeAutoresponder;
	}

	private boolean includeAutoresponder = false;
	


}
