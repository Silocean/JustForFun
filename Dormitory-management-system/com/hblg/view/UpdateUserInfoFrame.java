package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hblg.common.PublicUser;
import com.hblg.common.Tools;
import com.hblg.dao.UserDAO;
import com.hblg.entity.User;

public class UpdateUserInfoFrame extends JFrame {
	
	JPanel panelAdd = new JPanel();
	JPanel panelDelete = new JPanel();
	
	JPanel panelUp1 = new JPanel();
	JPanel panelDown1 = new JPanel();
	
	JPanel panelUp2 = new JPanel();
	JPanel panelDown2 = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JLabel lblUserName = new JLabel("* 用户名");
	JTextField tfUserName = new JTextField(10);
	JLabel lblUserPwd = new JLabel("* 密码  ");
	JTextField tfUserPwd = new JTextField(10);
	JLabel lblUserPower = new JLabel("* 权限");
	JComboBox<String> cbUserPower = new JComboBox<String>();
	JButton butSure1 = new JButton("更改");
	JButton butCancel1 = new JButton("取消");
	
	String userName = "";
	String userPwd = "";
	String userPower = "";
	
	UserInfoQueryFrame userInfoQueryFrame;
	
	public UpdateUserInfoFrame(UserInfoQueryFrame userInfoQueryFrame, String userName) {
		this.userInfoQueryFrame = userInfoQueryFrame;
		this.userName = userName;
		this.initPanel();
		this.initData();
		this.setTitle("修改用户信息");
		this.setIconImage(Tools.img);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initData() {
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUserName(userName);
		tfUserName.setText(user.getUserName());
		tfUserPwd.setText(user.getUserPwd());
		cbUserPower.setSelectedItem(user.getUserPower()+"");
	}

	private void initPanel() {
		this.add(panelAdd);
		panelAdd.setLayout(new BorderLayout());
		panelAdd.add(panelUp1, BorderLayout.CENTER);
		panelAdd.add(panelDown1, BorderLayout.SOUTH);
		panelUp1.setLayout(new GridLayout(3, 1));
		panelUp1.add(panel1);
		panelUp1.add(panel2);
		panelUp1.add(panel3);
		panel1.add(lblUserName);
		panel1.add(tfUserName);
		tfUserName.setEditable(false);
		panel2.add(lblUserPwd);
		panel2.add(tfUserPwd);
		panel3.add(lblUserPower);
		panel3.add(cbUserPower);
		int userPower = PublicUser.getUserPower();
		if(userPower == 1) {
			cbUserPower.addItem("请选择用户权限");
			cbUserPower.addItem(userPower+"");
		} else {
			cbUserPower.addItem("请选择用户权限");
			cbUserPower.addItem("0");
			cbUserPower.addItem("1");
		}
		panelDown1.add(butSure1);
		panelDown1.add(butCancel1);
		cbUserPower.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbUserPowerItemStateChanged(e);
			}
		});
		butSure1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butSure1ActionPerformed(e);
			}
		});
		butCancel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butCancel1ActionPerformed(e);
			}
		});
	}
	
	protected void butCancel1ActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSure1ActionPerformed(ActionEvent e) {
		if(!this.check1()) {
			return;
		} else {
			UserDAO userDAO = new UserDAO();
			User user = new User();
			user.setUserName(userName);
			user.setUserPwd(userPwd);
			user.setUserPower(Integer.parseInt(userPower));
			System.out.println(user);
			if(userDAO.updateUserInfo(user)) {
				this.userInfoQueryFrame.initTableData();
				JOptionPane.showMessageDialog(this, "更改用户信息成功！");
			} else {
				JOptionPane.showMessageDialog(this, "更改用户信息失败！");
			}
		}
	}
	

	private boolean check1() {
		if(!this.checkUserName()) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return false;
		} else if(!this.checkUserPower()) {
			JOptionPane.showMessageDialog(this, "用户权限设置不正确！");
			return false;
		} else {
			userName = tfUserName.getText().trim();
			userPwd = tfUserPwd.getText().trim();
		}
		return true;
	}

	private boolean checkUserPower() {
		if(userPower.equals("") || userPower.equals("请选择用户权限")) {
			return false;
		}
		return true;
	}

	private boolean checkUserName() {
		userName = tfUserName.getText().trim();
		if(userName.equals("")) {
			return false;
		}
		return true;
	}

	protected void cbUserPowerItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			userPower = e.getItem().toString().trim();
		}
	}
	
}
