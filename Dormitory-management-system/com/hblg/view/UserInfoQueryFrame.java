package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hblg.common.PublicUser;
import com.hblg.common.Tools;
import com.hblg.dao.UserDAO;
import com.hblg.entity.User;
import com.hblg.view.model.UserTableModel;

public class UserInfoQueryFrame extends JFrame {

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();

	JLabel lblUserName = new JLabel("�û���");
	JComboBox<String> cbUserName = new JComboBox<String>();
	JTable table = new JTable();
	JScrollPane sp = new JScrollPane(table);
	JButton butDelete = new JButton("ɾ��");
	JButton butCancel = new JButton("ȡ��");

	UserTableModel utm = new UserTableModel();

	String userName = "";

	public UserInfoQueryFrame() {
		this.initPanel();
		this.initUserName();
		this.initTable();
		this.judgeUserPower();
		this.setTitle("�û���Ϣ");
		this.setIconImage(Tools.img);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void judgeUserPower() {
		int userPower = PublicUser.getUserPower();
		if (userPower == 1) {
			butDelete.setEnabled(false);
		}
	}

	private void initTable() {
		table.setModel(utm);
		table.getTableHeader().setReorderingAllowed(false); // ���������ƶ�
		// table1.getTableHeader().setResizingAllowed(false); //�����������
	}

	private void initPanel() {
		this.setLayout(new GridLayout(3, 1));
		this.add(panel1);
		this.add(panel2);
		this.add(panel3);
		panel1.setBorder(BorderFactory.createTitledBorder("ѡ���û�"));
		panel2.setBorder(BorderFactory.createTitledBorder("�û���Ϣ"));
		panel1.add(lblUserName);
		panel1.add(cbUserName);
		cbUserName.addItem("��ѡ���û���");
		panel2.setLayout(new BorderLayout());
		panel2.add(sp);
		panel3.add(butDelete);
		panel3.add(butCancel);
		cbUserName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbUserNameItemStateChanged(e);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		butDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butDeleteActionPerformed(e);
			}
		});
		butCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butCancelActionPerformed(e);
			}
		});
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butDeleteActionPerformed(ActionEvent e) {
		int row = table.getSelectedRow();
		if (row == -1) {
			JOptionPane.showMessageDialog(this, "��ѡ����Ҫɾ�����û���");
			return;
		} else {
			userName = ((String) table.getValueAt(row, 0)).trim();
			UserDAO userDAO = new UserDAO();
			if (userDAO.deleteUserInfoByUserName(userName)) {
				this.initUserName();
				utm.removeRow(0);
				JOptionPane.showMessageDialog(this, "ɾ���û��ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ���û�ʧ�ܣ�");
			}
		}
	}

	protected void tableMouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			int row = table.getSelectedRow();
			userName = ((String) table.getValueAt(row, 0)).trim();
			new UpdateUserInfoFrame(this, userName);
		}
	}

	protected void cbUserNameItemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			userName = e.getItem().toString().trim();
			if (!userName.equals("") && !userName.equals("��ѡ���û���")) {
				this.initTableData();
			}
		}
	}

	public void initTableData() {
		int count = utm.getRowCount();
		while (count >= 1) {
			utm.removeRow(--count);
		}
		UserDAO userDAO = new UserDAO();
		User user = userDAO.getUserByUserName(userName);
		utm.addUser(user);
	}

	private void initUserName() {
		int count = cbUserName.getItemCount();
		while (count >= 2) {
			cbUserName.removeItemAt(--count);
		}
		String userName = PublicUser.getUserName();
		int userPower = PublicUser.getUserPower();
		if (userPower == 1) {
			cbUserName.addItem(userName);
		} else {
			UserDAO userDAO = new UserDAO();
			List<String> list = userDAO.getAllUserName();
			for (int i = 0; i < list.size(); i++) {
				cbUserName.addItem(list.get(i));
			}
		}
	}
}
