package com.hblg.dao;

import java.util.ArrayList;
import java.util.List;

import com.hblg.entity.Dormitory;

public class DormitoryDAO extends DAO {

	/**
	 * 插入寝室信息
	 */
	public boolean save(Dormitory dorm) {
		try {
			String sql = "insert into dormitory (dormId, dormSex, dormHouId, dormNum, dormPrice, dormTel, dormRemark)values (?, ?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, dorm.getDormId());
			pst.setString(2, dorm.getDormSex());
			pst.setInt(3, dorm.getDormHouId());
			pst.setInt(4, dorm.getDormNum());
			pst.setDouble(5, dorm.getDormPrice());
			pst.setString(6, dorm.getDormTel());
			pst.setString(7, dorm.getDormRemark());
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

	/**
	 * 更改寝室基本信息
	 */
	public boolean updateDormInfo(Dormitory dorm) {
		try {
			String sql = "update dormitory set " + "dormId = ?,"
					+ "dormSex = ?," + "dormHouId = ?," + "dormNum = ?,"
					+ "dormPrice = ?," + "dormTel = ?," + "dormRemark = ? "
					+ "where dormId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, dorm.getDormId().trim());
			pst.setString(2, dorm.getDormSex().trim());
			pst.setInt(3, dorm.getDormHouId());
			pst.setInt(4, dorm.getDormNum());
			pst.setDouble(5, dorm.getDormPrice());
			pst.setString(6, dorm.getDormTel().trim());
			pst.setString(7, dorm.getDormRemark().trim());
			pst.setString(8, dorm.getDormId().trim());
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

	/**
	 * 根据寝室号DormId获取寝室基本信息
	 */
	public Dormitory getDormInfoByDormId(String dormId) {
		try {
			Dormitory dorm = new Dormitory();
			String sql = "select * from dormitory where dormId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, dormId);
			rs = pst.executeQuery();
			while (rs.next()) {
				dorm.setDormId(rs.getString(1).trim());
				dorm.setDormSex(rs.getString(2).trim());
				dorm.setDormHouId(rs.getInt(3));
				dorm.setDormNum(rs.getInt(4));
				dorm.setDormPrice(rs.getDouble(6));
				dorm.setDormTel(rs.getString(7));
				dorm.setDormRemark(rs.getString(8));
			}
			return dorm;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * 查询所有寝室ID
	 */
	public List<String> getAllDormId() {
		try {
			List<String> list = new ArrayList<String>();
			list.add("请选择寝室编号");
			String sql = "select dormId from dormitory";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1).trim());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * 根据寝室编号ID查询寝室基本信息
	 */
	public Dormitory getDormInfoById(String dormId) {
		try {
			Dormitory dorm = new Dormitory();
			String sql = "select dormId, dormSex, dormHouId, dormNum, dormPrice, dormTel, dormRemark from Dormitory where dormId = ?;";
			pst = conn.prepareStatement(sql);
			pst.setString(1, dormId);
			rs = pst.executeQuery();
			while (rs.next()) {
				dorm.setDormId(rs.getString(1).trim());
				dorm.setDormSex(rs.getString(2).trim());
				dorm.setDormHouId(rs.getInt(3));
				dorm.setDormNum(rs.getInt(4));
				dorm.setDormPrice(rs.getDouble(5));
				dorm.setDormTel(rs.getString(6));
				dorm.setDormRemark(rs.getString(7));
			}
			String sql2 = "select COUNT(*) from student where stuDormId = ?;";
			pst = conn.prepareStatement(sql2);
			pst.setString(1, dormId);
			rs = pst.executeQuery();
			while (rs.next()) {
				dorm.setDormFact(rs.getInt(1));
			}
			return dorm;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * 根据寝室编号删除寝室
	 */
	public boolean deleteDormitoryByDormId(String dormId) {
		try {
			String sql = "delete from dormitory where dormId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, dormId);
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
