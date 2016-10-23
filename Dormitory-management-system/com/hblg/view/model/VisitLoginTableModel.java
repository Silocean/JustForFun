package com.hblg.view.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.hblg.entity.GoodsMove;
import com.hblg.entity.Visit;

public class VisitLoginTableModel extends DefaultTableModel {
	
	List<Visit> list;
	
	public VisitLoginTableModel() {
		this.initTitle();
	}
	
	public void addVisitList(List<Visit> list) {
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
		this.addColumn("�Զ����");
		this.addColumn("����������");
		this.addColumn("����������");
		this.addColumn("�������Һ�");
		this.addColumn("����ʱ��");
		this.addColumn("�뿪ʱ��");
		this.addColumn("ֵ����");
		this.addColumn("���֤��");
		this.addColumn("��ע");
	}
	
	private void initVisitData(Visit visit) {
		Object[] obj = {visit.getAutoId(),
				visit.getVisName(),
				visit.getVisHost(),
				visit.getVisDormId(),
				visit.getVisInTime(),
				visit.getVisLevTime(),
				visit.getVisWatchId(),
				visit.getVisCred(),
				visit.getVisRemark()};
		this.addRow(obj);
	}
	
	private void initData() {
		for(Visit visit : list) {
			this.initVisitData(visit);
		}
	}

}
