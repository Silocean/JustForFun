package com.hblg.view.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.hblg.entity.Student;

public class StudentTableModel extends DefaultTableModel {
	
	List<Student> list;
	
	Student stu;
	
	public StudentTableModel() {
		this.initTitle();
	}
	
	public void addStuList(List<Student> list) {
		this.list = list;
		this.initDate();
	}
	
	public void addStudent(Student stu) {
		this.stu = stu;
		// 显示数据
		this.initStuData(stu);
	}
	
	
	/*
	 * 设置表格不可编辑(non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	private void initTitle() {
		this.addColumn("学号");
		this.addColumn("姓名");
		this.addColumn("寝室号");
		this.addColumn("性别");
		this.addColumn("入学日期");
		this.addColumn("出生日期");
		this.addColumn("所属学院");
		this.addColumn("所属班级");
		this.addColumn("政治面貌");
		this.addColumn("联系电话");
		this.addColumn("家庭住址");
		this.addColumn("备注");
	}
	
	private void initStuData(Student stu) {
		Object[] obj = {stu.getStuId(), 
				stu.getStuName(),
				stu.getStuDormId(),
				stu.getStuSex(),
				stu.getStuInDate(),
				stu.getStuBirDate(),
				stu.getStuCollege(),
				stu.getStuClass(),
				stu.getStuPolit(),
				stu.getStuTel(),
				stu.getStuAddress(),
				stu.getStuRemark()};
		//System.out.println(stu.getStuId());
		this.addRow(obj);
	}
	
	private void initDate() {
		for(Student stu : list) {
			this.initStuData(stu);
		}
	}


}
