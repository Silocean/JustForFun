package com.hblg.common;

public class PublicUser {
	
	static String userName = "";
	static String userPwd = "";
	static int userPower = 0;
	
	public PublicUser(String userName, String userPwd, int userPower) {
		PublicUser.userName = userName;
		PublicUser.userPwd = userPwd;
		PublicUser.userPower = userPower;
	}

	public static String getUserName() {
		return userName;
	}

	public static void setUserName(String userName) {
		PublicUser.userName = userName;
	}

	public static String getUserPwd() {
		return userPwd;
	}

	public static void setUserPwd(String userPwd) {
		PublicUser.userPwd = userPwd;
	}

	public static int getUserPower() {
		return userPower;
	}

	public static void setUserPower(int userPower) {
		PublicUser.userPower = userPower;
	}
	
}
