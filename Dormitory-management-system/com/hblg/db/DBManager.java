package com.hblg.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	
	private static Connection conn = null;

	public static Connection connectDatabase() throws Exception {
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/dormitory";
		Class.forName(driverName);
		conn = DriverManager.getConnection(url, "root", "123456");
		return conn;
	}
	
}
