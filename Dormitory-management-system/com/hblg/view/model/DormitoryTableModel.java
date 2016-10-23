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
		// ��ʾ����
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
		this.addColumn("���Һ�");
		this.addColumn("�����Ա�");
		this.addColumn("����¥��");
		this.addColumn("Ӧס����");
		this.addColumn("ʵס����");
		this.addColumn("ס�޷���");
		this.addColumn("�绰����");
		this.addColumn("��ע");
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
