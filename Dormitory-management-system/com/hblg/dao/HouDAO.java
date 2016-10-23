package com.hblg.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hblg.entity.Hou;

public class HouDAO extends DAO {

	/**
	 * 查询所有楼栋编号
	 */
	public List<String> findAllId() {
		try {
			String sql = "select houId from hou";
			List<String> list = new ArrayList<String>();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			System.out.println(sql);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			this.closeSource();
		}
		return null;
	}

	/**
	 * 查找最大楼栋编号
	 */
	public int findMaxHouId() {
		try {
			String sql = "select MAX(houId) from hou";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 根据楼房编号查找楼房信息
	 */
	public Hou findAll(String houId) {
		try {
			Hou hou = new Hou();
			String sql = "select * from hou where houId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(houId));
			rs = pst.executeQuery();
			while (rs.next()) {
				hou.setHouNum(rs.getInt(2));
				hou.setHouFlr(rs.getInt(3));
				hou.setHouPeo(rs.getInt(4));
			}
			System.out.println(sql);
			return hou;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 插入楼栋信息
	 */
	public boolean save(Hou hou) {
		try {
			String sql = "insert into hou values (?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, hou.getHouId());
			pst.setInt(2, hou.getHouNum());
			pst.setInt(3, hou.getHouFlr());
			pst.setInt(4, hou.getHouPeo());
			int result = pst.executeUpdate();
			if (result == 1) {
				return true;
			}
			System.out.println(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 获取所有楼房编号
	 */
	public List<String> getAllHouId() {
		try {
			List<String> list = new ArrayList<String>();
			list.add("请选择楼房编号");
			String sql = "select houId from hou";
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
	 * 根据楼房编号查询楼房基本信息
	 */
	public Hou getHouInfoById(int houId) {
		try {
			Hou hou = new Hou();
			String sql = "select * from hou where houId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, houId);
			rs = pst.executeQuery();
			while (rs.next()) {
				hou.setHouId(rs.getInt(1));
				hou.setHouNum(rs.getInt(2));
				hou.setHouFlr(rs.getInt(3));
				hou.setHouPeo(rs.getInt(4));
			}
			String sql2 = "select COUNT(*) from student where stuDormId in (select dormId from Dormitory where dormHouId = ?)";
			pst = conn.prepareStatement(sql2);
			pst.setInt(1, houId);
			rs = pst.executeQuery();
			while (rs.next()) {
				hou.setHouFact(rs.getInt(1));
			}
			return hou;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * 根据楼房编号houId获取楼房基本信息
	 */
	public Hou getHouInfoByHouId(int houId) {
		try {
			Hou hou = new Hou();
			String sql = "select * from hou where houId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, houId);
			rs = pst.executeQuery();
			while (rs.next()) {
				hou.setHouId(rs.getInt(1));
				hou.setHouNum(rs.getInt(2));
				hou.setHouFlr(rs.getInt(3));
				hou.setHouPeo(rs.getInt(4));
			}
			return hou;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * 更改楼房基本信息
	 */
	public boolean updateHouInfo(Hou hou) {
		try {
			String sql = "update hou set " + "houId = ?, " + "houNum = ?, "
					+ "houFlr = ?, " + "houPeo = ? " + "where houId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, hou.getHouId());
			pst.setInt(2, hou.getHouNum());
			pst.setInt(3, hou.getHouFlr());
			pst.setInt(4, hou.getHouPeo());
			pst.setInt(5, hou.getHouId());
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
	 * 根据楼房编号删除楼栋
	 */
	public boolean deletebyId(String houId) {
		try {
			String sql = "delete from hou where houId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, Integer.parseInt(houId));
			pst.executeUpdate();
			System.out.println(sql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return false;
	}

	/**
	 * 根据楼房编号删除楼房
	 */
	public boolean deleteHouByHouId(int houId) {
		try {
			String sql = "delete from hou where houId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, houId);
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
	 * 根据楼房编号获取该楼房中实际住的人数
	 */
	public int getStuNumByHouId(int houId) {
		try {
			int people = 0;
			String sql2 = "select COUNT(*) from student where stuDormId in (select dormId from Dormitory where dormHouId = ?)";
			pst = conn.prepareStatement(sql2);
			pst.setInt(1, houId);
			rs = pst.executeQuery();
			while (rs.next()) {
				people = rs.getInt(1);
			}
			return people;
		} catch (Exception e) {

		}
		return 0;
	}

}
