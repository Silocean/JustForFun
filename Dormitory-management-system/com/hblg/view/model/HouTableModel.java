package com.hblg.view.model;

import javax.swing.table.DefaultTableModel;

import com.hblg.entity.Hou;

public class HouTableModel extends DefaultTableModel {
	
	Hou hou;
	
	public HouTableModel() {
		this.initTitle();
	}
	
	public void addDormitory(Hou hou) {
		this.hou = hou;
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
		this.addColumn("¥�����");
		this.addColumn("��������");
		this.addColumn("¥������");
		this.addColumn("Ӧס����");
		this.addColumn("ʵס����");
	}
	
	private void initData() {
		Object[] obj = {hou.getHouId(),
				hou.getHouNum(),
				hou.getHouFlr(),
				hou.getHouPeo(),
				hou.getHouFact()};
		this.addRow(obj);
	}
}
