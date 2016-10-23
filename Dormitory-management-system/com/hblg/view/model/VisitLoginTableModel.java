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
	 * 设置表格不可编辑(non-Javadoc)
	 * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int row, int column) {
		// TODO Auto-generated method stub
		return false;
	}

	private void initTitle() {
		this.addColumn("自动编号");
		this.addColumn("来访人姓名");
		this.addColumn("被仿人姓名");
		this.addColumn("访问寝室号");
		this.addColumn("来访时间");
		this.addColumn("离开时间");
		this.addColumn("值班人");
		this.addColumn("身份证号");
		this.addColumn("备注");
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
