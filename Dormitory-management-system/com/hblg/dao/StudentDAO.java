package com.hblg.dao;

import java.util.ArrayList;
import java.util.List;

import com.hblg.entity.Student;

public class StudentDAO extends DAO {

	/**
	 * ����ѧ��������Ϣ
	 */
	public boolean save(Student stu) {
		try {
			String sql = "insert into student values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stu.getStuId());
			pst.setString(2, stu.getStuName());
			pst.setString(3, stu.getStuDormId());
			pst.setString(4, stu.getStuSex());
			pst.setString(5, stu.getStuInDate());
			pst.setString(6, stu.getStuBirDate());
			pst.setString(7, stu.getStuCollege());
			pst.setString(8, stu.getStuClass());
			pst.setString(9, stu.getStuPolit());
			pst.setString(10, stu.getStuTel());
			pst.setString(11, stu.getStuAddress());
			pst.setString(12, stu.getStuRemark());
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
	 * ����ѧ��StuId����ѧ��������Ϣ
	 */
	public boolean updateStuInfo(Student stu) {
		try {
			String sql = "update student set " + "stuName = ?,"
					+ "stuDormId = ?," + "stuSex = ?," + "stuInDate = ?,"
					+ "stuBirDate = ?," + "stuCollege = ?," + "stuClass = ?,"
					+ "stuPolit = ?," + "stuTel = ?," + "stuAddress = ?,"
					+ "stuRemark = ? " + "where stuId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stu.getStuName().trim());
			pst.setString(2, stu.getStuDormId().trim());
			pst.setString(3, stu.getStuSex().trim());
			pst.setString(4, stu.getStuInDate().trim());
			pst.setString(5, stu.getStuBirDate().trim());
			pst.setString(6, stu.getStuCollege().trim());
			pst.setString(7, stu.getStuClass().trim());
			pst.setString(8, stu.getStuPolit().trim());
			pst.setString(9, stu.getStuTel().trim());
			pst.setString(10, stu.getStuAddress().trim());
			pst.setString(11, stu.getStuRemark().trim());
			pst.setString(12, stu.getStuId().trim());
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
	 * �������Һ�ID��ѯѧ��������Ϣ
	 */
	public List<Student> getStuInfoByDormId(String dormId) {
		try {
			List<Student> list = new ArrayList<Student>();
			String sql = "select * from student where stuDormId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, dormId);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student stu = new Student(); // ע��ÿ�ζ�Ҫnewһ��student
				stu.setStuId(rs.getString(1).trim());
				stu.setStuName(rs.getString(2).trim());
				stu.setStuDormId(rs.getString(3).trim());
				stu.setStuSex(rs.getString(4).trim());
				stu.setStuInDate(rs.getString(5).trim());
				stu.setStuBirDate(rs.getString(6).trim());
				stu.setStuCollege(rs.getString(7).trim());
				stu.setStuClass(rs.getString(8).trim());
				stu.setStuPolit(rs.getString(9).trim());
				stu.setStuTel(rs.getString(10).trim());
				stu.setStuAddress(rs.getString(11).trim());
				stu.setStuRemark(rs.getString(12).trim());
				list.add(stu); // ÿ����list�м�һ���µ�student
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
	 * ����ѧ��stuId��ѯѧ��������Ϣ
	 */
	public Student getStuInfoByStuId(String stuId) {
		try {
			Student stu = new Student();
			String sql = "select * from student where stuId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stuId);
			System.out.println(stuId);
			rs = pst.executeQuery();
			while (rs.next()) {
				stu.setStuId(rs.getString(1).trim());
				stu.setStuName(rs.getString(2).trim());
				stu.setStuDormId(rs.getString(3).trim());
				stu.setStuSex(rs.getString(4).trim());
				stu.setStuInDate(rs.getString(5).trim());
				stu.setStuBirDate(rs.getString(6).trim());
				stu.setStuCollege(rs.getString(7).trim());
				stu.setStuClass(rs.getString(8).trim());
				stu.setStuPolit(rs.getString(9).trim());
				stu.setStuTel(rs.getString(10).trim());
				stu.setStuAddress(rs.getString(11).trim());
				stu.setStuRemark(rs.getString(12).trim());
			}
			return stu;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return null;
	}

	/**
	 * ����ѧ��������ѯѧ��������Ϣ
	 */
	public List<Student> getStuInfoByStuName(String stuName) {
		try {
			List<Student> list = new ArrayList<Student>();
			String sql = "select * from student where stuName = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stuName);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student stu = new Student(); // ע��ÿ�ζ�Ҫnewһ��student
				stu.setStuId(rs.getString(1).trim());
				stu.setStuName(rs.getString(2).trim());
				stu.setStuDormId(rs.getString(3).trim());
				stu.setStuSex(rs.getString(4).trim());
				stu.setStuInDate(rs.getString(5).trim());
				stu.setStuBirDate(rs.getString(6).trim());
				stu.setStuCollege(rs.getString(7).trim());
				stu.setStuClass(rs.getString(8).trim());
				stu.setStuPolit(rs.getString(9).trim());
				stu.setStuTel(rs.getString(10).trim());
				stu.setStuAddress(rs.getString(11).trim());
				stu.setStuRemark(rs.getString(12).trim());
				list.add(stu); // ÿ����list�м�һ���µ�student
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
	 * ��ȡ����ѧ��ѧ��
	 */
	public List<String> getAllStuId() {
		try {
			List<String> list = new ArrayList<String>();
			String sql = "select stuId from student";
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
	 * �������ҺŲ�ѯ������ʵ��ס�˶�����
	 */
	public int getStuFactNumByDormId(String stuDormId) {
		try {
			int num = 0;
			String sql = "select count(*) from student where stuDormId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stuDormId);
			rs = pst.executeQuery();
			while (rs.next()) {
				num = rs.getInt(1);
			}
			return num;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeSource();
		}
		return 0;
	}

	/**
	 * ���ݰ༶����ѯѧ��������Ϣ
	 */
	public List<Student> getStuInfoByStuClass(String stuClass) {
		try {
			List<Student> list = new ArrayList<Student>();
			String sql = "select * from student where stuClass = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stuClass);
			rs = pst.executeQuery();
			while (rs.next()) {
				Student stu = new Student(); // ע��ÿ�ζ�Ҫnewһ��student
				stu.setStuId(rs.getString(1).trim());
				stu.setStuName(rs.getString(2).trim());
				stu.setStuDormId(rs.getString(3).trim());
				stu.setStuSex(rs.getString(4).trim());
				stu.setStuInDate(rs.getString(5).trim());
				stu.setStuBirDate(rs.getString(6).trim());
				stu.setStuCollege(rs.getString(7).trim());
				stu.setStuClass(rs.getString(8).trim());
				stu.setStuPolit(rs.getString(9).trim());
				stu.setStuTel(rs.getString(10).trim());
				stu.setStuAddress(rs.getString(11).trim());
				stu.setStuRemark(rs.getString(12).trim());
				list.add(stu); // ÿ����list�м�һ���µ�student
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
	 * ����ѧ��ɾ����ѧ��
	 */
	public boolean deleteStudentByStuId(String stuId) {
		try {
			String sql = "delete from student where stuId = ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, stuId);
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
