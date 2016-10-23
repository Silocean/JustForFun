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
		// ��ʾ����
		this.initStuData(stu);
	}
	
	
	/*
	 * ���ñ�񲻿ɱ༭(non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	private void initTitle() {
		this.addColumn("ѧ��");
		this.addColumn("����");
		this.addColumn("���Һ�");
		this.addColumn("�Ա�");
		this.addColumn("��ѧ����");
		this.addColumn("��������");
		this.addColumn("����ѧԺ");
		this.addColumn("�����༶");
		this.addColumn("������ò");
		this.addColumn("��ϵ�绰");
		this.addColumn("��ͥסַ");
		this.addColumn("��ע");
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
