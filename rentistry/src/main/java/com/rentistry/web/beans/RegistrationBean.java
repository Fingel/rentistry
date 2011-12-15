package com.rentistry.web.beans;

public class RegistrationBean {
	
	private String userEmail;
	private String firstName;
	private String lastName;
	private String password;
	private String robotAnswer;
	private String aboutMe;
	private byte[] avatar;
	
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRobotAnswer() {
		return robotAnswer;
	}
	public void setRobotAnswer(String robotAnswer) {
		this.robotAnswer = robotAnswer;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public byte[] getAvatar() {
		return avatar;
	}
	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}
