package com.hblg.view.model;

import javax.swing.table.DefaultTableModel;

import com.hblg.entity.Dormitory;

public class DormitoryTableModel extends DefaultTableModel {
	
	Dormitory dorm;
	
	public DormitoryTableModel() {
		this.initTitle();
	}
	
	public void addDormitory(Dormitory dorm) {
		this.dorm = dorm;
		// 显示数据
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
		this.addColumn("寝室号");
		this.addColumn("寝室性别");
		this.addColumn("所属楼栋");
		this.addColumn("应住人数");
		this.addColumn("实住人数");
		this.addColumn("住宿费用");
		this.addColumn("电话号码");
		this.addColumn("备注");
	}
	
	private void initData() {
		Object[] obj = {dorm.getDormId(),
				dorm.getDormSex(), 
				dorm.getDormHouId(),
				dorm.getDormNum(), 
				dorm.getDormFact(), 
				dorm.getDormPrice(),
				dorm.getDormTel(), 
				dorm.getDormRemark()};
		this.addRow(obj);
	}

}
