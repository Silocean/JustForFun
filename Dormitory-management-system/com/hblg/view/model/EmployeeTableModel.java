package com.hblg.view.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.hblg.entity.Employee;

public class EmployeeTableModel extends DefaultTableModel {
	
	List<Employee> list;
	
	public EmployeeTableModel() {
		this.initTitle();
	}
	
	public void addEmpList(List<Employee> list) {
		this.list = list;
		this.initData();
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
		this.addColumn("���");
		this.addColumn("����");
		this.addColumn("����");
		this.addColumn("�Ա�");
		this.addColumn("����¥��");
		this.addColumn("ְλ");
		this.addColumn("��ͥסַ");
		this.addColumn("��ϵ�绰");
		this.addColumn("��ע");
	}
	
	private void initEmpData(Employee emp) {
		Object[] obj = {emp.getEmpId(),
				emp.getEmpName(),
				emp.getEmpAge(),
				emp.getEmpSex(),
				emp.getEmpHouId(),
				emp.getEmpJob(),
				emp.getEmpAddress(),
				emp.getEmpTel(),
				emp.getEmpRemark()};
		this.addRow(obj);
	}
	
	private void initData() {
		for(Employee emp : list) {
			this.initEmpData(emp);
		}
	}
}
