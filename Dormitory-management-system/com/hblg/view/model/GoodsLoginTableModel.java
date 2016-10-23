package com.hblg.view.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.hblg.entity.GoodsMove;

public class GoodsLoginTableModel extends DefaultTableModel {
	
	List<GoodsMove> list;
	
	public GoodsLoginTableModel() {
		this.initTitle();
	}
	
	public void addGodsMoveList(List<GoodsMove> list) {
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
		this.addColumn("ѧ��ѧ��");
		this.addColumn("���");
		this.addColumn("��¥ʱ��");
		this.addColumn("��¥ʱ��");
		this.addColumn("ֵ����");
		this.addColumn("��ע");
	}
	
	private void initGodsMoveData(GoodsMove gm) {
		Object[] obj = {gm.getGodsStuId(),
				gm.getGodsId(),
				gm.getGodsInTime(),
				gm.getGodsLevTime(),
				gm.getGodsWatchId(),
				gm.getGodsRemark()};
		this.addRow(obj);
	}
	
	private void initData() {
		for(GoodsMove gm : list) {
			this.initGodsMoveData(gm);
		}
	}

}
