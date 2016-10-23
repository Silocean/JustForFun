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
		this.addColumn("楼房编号");
		this.addColumn("房间数量");
		this.addColumn("楼层数量");
		this.addColumn("应住人数");
		this.addColumn("实住人数");
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
