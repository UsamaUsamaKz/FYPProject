package com.springboot.fyp.validationmapper;

public class RegistrationMapper {
	
	private String name;
	private String formemail;
	private String formpassword;
	private String passwordConfirm;
	private String phoneNo;

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getFormemail() {
		return formemail;
	}

	public void setFormemail(String formemail) {
		this.formemail = formemail;
	}

	public String getFormpassword() {
		return formpassword;
	}

	public void setFormpassword(String formpassword) {
		this.formpassword = formpassword;
	}

}
