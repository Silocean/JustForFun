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
	 * 设置表格不可编辑(non-Javadoc)
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
		this.addColumn("用户名");
		this.addColumn("密码");
		this.addColumn("权限");
	}

}
