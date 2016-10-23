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
	 * 设置表格不可编辑(non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	private void initTitle() {
		this.addColumn("编号");
		this.addColumn("姓名");
		this.addColumn("年龄");
		this.addColumn("性别");
		this.addColumn("所属楼栋");
		this.addColumn("职位");
		this.addColumn("家庭住址");
		this.addColumn("联系电话");
		this.addColumn("备注");
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
