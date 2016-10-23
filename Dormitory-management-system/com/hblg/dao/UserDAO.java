package com.hblg.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.hblg.db.DBManager;
import com.hblg.entity.User;

public class UserDAO extends DAO {

	Connection conn = null;

	public int errorMsg = 0;

	public UserDAO() {
		try {
			conn = DBManager.connectDatabase();
		} catch (Exception e) {
			errorMsg = 1;
			e.printStackTrace();
		}
	}

	/*
	 * 获取所有用户信息
	 */
	public List<User> getAllUserInfo() {
		try {
			List<User> list = new ArrayList<User>();
			String sql = "select * from LoginIn";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserName(rs.getString(1));
				user.setUserPwd(rs.getString(2));
				user.setUserPower(rs.getInt(3));
				list.add(user);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/*
	 * 获取所有用户名
	 */
	public List<String> getAllUserName() {
		try {
			List<String> list = new ArrayList<String>();
			String sql = "select userName from LoginIn";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/*
	 * 添加员工信息
	 */
	public boolean save(User user) {
		try {
			String sql = "insert into LoginIn values(?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUserName().trim());
			pst.setString(2, user.getUserPwd().trim());
			pst.setInt(3, user.getUserPower());
			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return false;
	}

	/*
	 * 根据用户名删除用户信息
	 */
	public boolean deleteUserInfoByUserName(String userName) {
		try {
			String sql = "delete from loginIn where userName = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return false;
	}

	/*
	 * 根据用户名获取用户信息并返回一个用户对象
	 */
	public User getUserByUserName(String userName) {
		try {
			User user = new User();
			String sql = "select * from loginIn where userName = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, userName);
			rs = pst.executeQuery();
			while (rs.next()) {
				user.setUserName(rs.getString(1));
				user.setUserPwd(rs.getString(2));
				user.setUserPower(rs.getInt(3));
			}
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/*
	 * 更改用户信息
	 */
	public boolean updateUserInfo(User user) {
		try {
			String sql = "update loginIn set " + "userName = ?, "
					+ "userPwd = ?, " + "userPower = ? " + "where userName = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getUserPwd());
			pst.setInt(3, user.getUserPower());
			pst.setString(4, user.getUserName());
			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return false;
	}

}
