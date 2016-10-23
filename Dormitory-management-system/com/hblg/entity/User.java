package com.hblg.entity;
/*
 *  userName nvarchar(50) primary key,	--�û�����
	userPwd varchar(50),				--�û�����
	userPower int	
 */
public class User {
	private String userName;			//�û�����
	private String userPwd;				//�û�����
	private int userPower;				//�û�Ȩ��
	
	public User() {
		
	}
	public User(String userName, String userPwd, int userPower) {
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPower = userPower;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserPower() {
		return userPower;
	}
	public void setUserPower(int userPower) {
		this.userPower = userPower;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public String toString() {
		return "UserDAO [userName=" + userName + ", userPwd=" + userPwd
				+ ", userPower=" + userPower + "]";
	}
}
