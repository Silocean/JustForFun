package com.hblg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.hblg.db.DBManager;

public class DAO {
	
	Connection conn = null;
	PreparedStatement pst = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public DAO() {
		try {
			conn = DBManager.connectDatabase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ¹Ø±Õ×ÊÔ´
	 */
	public void closeSource() {
		try {
			if(conn != null) {
				conn.close();
				conn = null;
			}
			if(pst != null) {
				pst.close();
				pst = null;
			}
			if(rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
