package com.hblg.view.model;

import javax.swing.table.DefaultTableModel;

import com.hblg.dao.UserDAO;
import com.hblg.entity.User;

public class UserTableModel extends DefaultTableModel {

	User user;

	public UserTableModel() {
		this.initTitle();
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

	public void addUser(User user) {
		this.user = user;
		this.initData();
	}

	private void initData() {
		Object[] obj = { user.getUserName(),
				user.getUserPwd(),
				user.getUserPower()};
		this.addRow(obj);
	}

	private void initTitle() {
		this.addColumn("�û���");
		this.addColumn("����");
		this.addColumn("Ȩ��");
	}

}
