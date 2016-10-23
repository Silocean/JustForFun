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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.UserDAO;
import com.hblg.entity.User;

public class UserManageFrame extends JFrame {
	
	JTabbedPane tp = new JTabbedPane();
	
	JPanel panelAdd = new JPanel();
	JPanel panelDelete = new JPanel();
	
	JPanel panelUp1 = new JPanel();
	JPanel panelDown1 = new JPanel();
	
	JPanel panelUp2 = new JPanel();
	JPanel panelDown2 = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JLabel lblUserName = new JLabel("* �û���");
	JTextField tfUserName = new JTextField(10);
	JLabel lblUserPwd = new JLabel("* ����  ");
	JTextField tfUserPwd = new JTextField(10);
	JLabel lblUserPower = new JLabel("* Ȩ��");
	JComboBox<String> cbUserPower = new JComboBox<String>();
	JButton butSure1 = new JButton("���");
	JButton butCancel1 = new JButton("ȡ��");
	
	JLabel lblName = new JLabel("�û���");
	JComboBox<String> cbUserName = new JComboBox<String>();
	JButton butSure2 = new JButton("ɾ��");
	JButton butCancel2 = new JButton("ȡ��");
	
	String userName = "";
	String userPwd = "";
	String userPower = "";
	
	public UserManageFrame() {
		this.initPanel();
		this.initUserName();
		this.setTitle("�û�����");
		this.setIconImage(Tools.img);
		this.setSize(400, 300);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initPanel() {
		this.add(tp);
		tp.add(panelAdd, "����û�");
		tp.add(panelDelete, "ɾ���û�");
		this.initPanelAdd();
		this.initPanelDelete();
	}
	
	private void initPanelAdd() {
		panelAdd.setLayout(new BorderLayout());
		panelAdd.add(panelUp1, BorderLayout.CENTER);
		panelAdd.add(panelDown1, BorderLayout.SOUTH);
		panelUp1.setLayout(new GridLayout(3, 1));
		panelUp1.add(panel1);
		panelUp1.add(panel2);
		panelUp1.add(panel3);
		panel1.add(lblUserName);
		panel1.add(tfUserName);
		panel2.add(lblUserPwd);
		panel2.add(tfUserPwd);
		panel3.add(lblUserPower);
		panel3.add(cbUserPower);
		cbUserPower.addItem("��ѡ���û�Ȩ��");
		cbUserPower.addItem("0");
		cbUserPower.addItem("1");
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

	protected void cbUserPowerItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			userPower = e.getItem().toString().trim();
		}
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
			if(userDAO.save(user)) {
				this.initUserName();
				JOptionPane.showMessageDialog(this, "����û��ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "����û�ʧ�ܣ�");
			}
		}
	}

	private boolean check1() {
		if(!this.checkUserName()) {
			JOptionPane.showMessageDialog(this, "�û�������Ϊ�����7���ַ���");
			return false;
		} else if(!this.checkUserPower()) {
			JOptionPane.showMessageDialog(this, "�û�Ȩ�����ò���ȷ��");
			return false;
		} else if(!this.checkUserNameExisted()) {
			JOptionPane.showMessageDialog(this, "�û��Ѵ��ڣ�");
			return false;
		} else {
			userName = tfUserName.getText().trim();
			userPwd = tfUserPwd.getText().trim();
		}
		return true;
	}

	private boolean checkUserNameExisted() {
		UserDAO userDAO = new UserDAO();
		List<String> list = userDAO.getAllUserName();
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(userName.equals(list.get(i))) {
				flag = true;
			}
		}
		if(flag) {
			return false; //�û��Ѵ���
		}
		return true; //�û�������
	}

	private boolean checkUserPower() {
		if(userPower.equals("") || userPower.equals("��ѡ���û�Ȩ��")) {
			return false;
		}
		return true;
	}

	private boolean checkUserName() {
		userName = tfUserName.getText().trim();
		if(userName.equals("")) {
			return false;
		} else if(userName.length() > 7) {
			return false;
		}
		return true;
	}

	protected void butCancel1ActionPerformed(ActionEvent e) {
		this.dispose();
	}

	private void initPanelDelete() {
		panelDelete.setLayout(new GridLayout(2, 1));
		panelDelete.add(panelUp2);
		panelDelete.add(panelDown2);
		panelUp2.add(lblName);
		panelUp2.add(cbUserName);
		cbUserName.addItem("��ѡ���û���");
		panelDown2.add(butSure2);
		panelDown2.add(butCancel2);
		cbUserName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbUserNameItemStateChanged(e);
			}
		});
		butSure2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butSure2ActionPerformed(e);
			}
		});
		butCancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butCancel2ActionPerformed(e);
			}
		});
	}

	protected void cbUserNameItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			userName = e.getItem().toString().trim();
		}
	}

	protected void butSure2ActionPerformed(ActionEvent e) {
		if(!this.check2()) {
			return;
		} else {
			UserDAO userDAO = new UserDAO();
			if(userDAO.deleteUserInfoByUserName(userName)) {
				this.initUserName();
				JOptionPane.showMessageDialog(this, "ɾ���û��ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ���û�ʧ�ܣ�");
			}
		}
	}

	private boolean check2() {
		if(!this.checkCbUserName()) {
			JOptionPane.showMessageDialog(this, "�㻹û��ѡ����Ҫɾ�����û���");
			return false;
		}
		return true;
	}

	private boolean checkCbUserName() {
		if(userName.equals("") || userName.equals("��ѡ���û���")) {
			return false;
		}
		return true;
	}

	protected void butCancel2ActionPerformed(ActionEvent e) {
		this.dispose();
	}

	public void initUserName() {
		int count = cbUserName.getItemCount();
		while(count>=2) {
			cbUserName.removeItemAt(--count);
		}
		UserDAO userDAO = new UserDAO();
		List<String> list = userDAO.getAllUserName();
		for(int i=0; i<list.size(); i++) {
			cbUserName.addItem(list.get(i));
		}
	}

}
