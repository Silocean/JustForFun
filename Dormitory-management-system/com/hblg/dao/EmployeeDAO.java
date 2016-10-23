package com.hblg.dao;

import java.util.ArrayList;
import java.util.List;

import com.hblg.entity.Employee;

public class EmployeeDAO extends DAO {

	/**
	 * 获取最大雇员编号
	 */
	public String getMaxEmpId() {
		try {
			String maxEmpId = "";
			String sql = "select empId from employee";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				maxEmpId = rs.getString(1);
			}
			return maxEmpId;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return "";
	}

	/**
	 * 插入雇员基本信息
	 */
	public boolean save(Employee emp) {
		try {
			String sql = "insert into employee values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getEmpId());
			pst.setString(2, emp.getEmpName());
			pst.setInt(3, emp.getEmpAge());
			pst.setString(4, emp.getEmpSex());
			pst.setInt(5, emp.getEmpHouId());
			pst.setString(6, emp.getEmpJob());
			pst.setString(7, emp.getEmpAddress());
			pst.setString(8, emp.getEmpTel());
			pst.setString(9, emp.getEmpRemark());
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
	 * 根据雇员编号获取员工基本信息
	 */
	public Employee getEmpInfoByEmpId(String empId) {
		try {
			Employee emp = new Employee();
			String sql = "select * from employee where empId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, empId);
			rs = pst.executeQuery();
			while (rs.next()) {
				emp.setEmpId(rs.getString(1).trim());
				emp.setEmpName(rs.getString(2).trim());
				emp.setEmpAge(rs.getInt(3));
				emp.setEmpSex(rs.getString(4).trim());
				emp.setEmpHouId(rs.getInt(5));
				emp.setEmpJob(rs.getString(6).trim());
				emp.setEmpAddress(rs.getString(7).trim());
				emp.setEmpTel(rs.getString(8).trim());
				emp.setEmpRemark(rs.getString(9).trim());
			}
			return emp;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * 获取所有雇员编号
	 */
	public List<String> getAllEmpId() {
		try {
			List<String> list = new ArrayList<String>();
			String sql = "select empId from employee";
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
	 * 更改雇员基本信息
	 */
	public boolean updateEmpInfo(Employee emp) {
		try {
			String sql = "update employee set " + "empId = ?, "
					+ "empName = ?," + "empAge = ?," + "empSex = ?,"
					+ "empHouId = ?," + "empJob = ?," + "empAddress = ?,"
					+ "empTel = ?," + "empRemark = ? " + "where empId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, emp.getEmpId());
			pst.setString(2, emp.getEmpName());
			pst.setInt(3, emp.getEmpAge());
			pst.setString(4, emp.getEmpSex());
			pst.setInt(5, emp.getEmpHouId());
			pst.setString(6, emp.getEmpJob());
			pst.setString(7, emp.getEmpAddress());
			pst.setString(8, emp.getEmpTel());
			pst.setString(9, emp.getEmpRemark());
			pst.setString(10, emp.getEmpId());
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
	 * 根据员工所属楼栋编号empHouId获取员工基本信息
	 */
	public List<Employee> getEmpInfoByEmpId(int empHouId) {
		try {
			List<Employee> list = new ArrayList<Employee>();
			String sql = "select * from employee where empHouId = ?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, empHouId);
			rs = pst.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getString(1).trim());
				emp.setEmpName(rs.getString(2).trim());
				emp.setEmpAge(rs.getInt(3));
				emp.setEmpSex(rs.getString(4).trim());
				emp.setEmpHouId(rs.getInt(5));
				emp.setEmpJob(rs.getString(6).trim());
				emp.setEmpAddress(rs.getString(7).trim());
				emp.setEmpTel(rs.getString(8).trim());
				emp.setEmpRemark(rs.getString(9).trim());
				list.add(emp);
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
	 * 根据雇员编号删除雇员
	 */
	public boolean deleteEmployeeByEmpId(String empId) {
		try {
			String sql = "delete from employee where empId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, empId);
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
