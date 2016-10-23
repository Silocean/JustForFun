package com.hblg.dao;

import java.util.ArrayList;
import java.util.List;

import com.hblg.entity.Visit;

public class VisitDAO extends DAO {

	/**
	 * 获取最大编号
	 */
	public int getMaxId() {
		try {
			int maxId = 0;
			String sql = "select autoId from visit";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				maxId = rs.getInt(1);
			}
			return maxId;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return 0;
	}

	/**
	 * 插入来访人信息
	 */
	public boolean save(Visit vis) {
		try {
			String sql = "insert into visit values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, vis.getAutoId());
			pst.setString(2, vis.getVisName());
			pst.setString(3, vis.getVisHost());
			pst.setString(4, vis.getVisDormId());
			pst.setString(5, vis.getVisInTime());
			pst.setString(6, vis.getVisLevTime());
			pst.setString(7, vis.getVisWatchId());
			pst.setString(8, vis.getVisCred());
			pst.setString(9, vis.getVisRemark());
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
	 * 根据日期获取来访人详细信息
	 */
	public List<Visit> getVisitInfoByDate(String date) {
		try {
			List<Visit> list = new ArrayList<Visit>();
			String sql = "select * from visit where visInTime like ? or visLevTIme like ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, "%" + date + "%");
			pst.setString(2, "%" + date + "%");
			rs = pst.executeQuery();
			while (rs.next()) {
				Visit vis = new Visit();
				vis.setAutoId(rs.getInt(1));
				vis.setVisName(rs.getString(2).trim());
				vis.setVisHost(rs.getString(3).trim());
				vis.setVisDormId(rs.getString(4).trim());
				vis.setVisInTime(rs.getString(5).trim());
				vis.setVisLevTime(rs.getString(6).trim());
				vis.setVisWatchId(rs.getString(7).trim());
				vis.setVisCred(rs.getString(8).trim());
				vis.setVisRemark(rs.getString(9).trim());
				list.add(vis);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据自动编号删除人员来访记录（批处理）
	 */
	public boolean deleteVisitInfoByAutoId(List<Integer> autoIdList) {
		try {
			String sql = "delete from visit where autoId = ?";
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < autoIdList.size(); i++) {
				pst.setInt(1, autoIdList.get(i));
				pst.addBatch();
			}
			boolean flag = true;
			int[] result = pst.executeBatch();
			for (int i = 0; i < result.length; i++) {
				if (result[i] != 1) {
					flag = false; // 删除出错
				}
			}
			if (flag) {
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
