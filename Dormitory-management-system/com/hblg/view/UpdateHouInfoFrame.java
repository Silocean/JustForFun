package com.hblg.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.EmployeeDAO;
import com.hblg.dao.HouDAO;
import com.hblg.entity.Dormitory;
import com.hblg.entity.Hou;

public class UpdateHouInfoFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	JPanel panelUp1 = new JPanel();
	JPanel panelUp2 = new JPanel();
	JPanel panelUp3 = new JPanel();
	JPanel panelUp4 = new JPanel();
	JPanel panelUp5 = new JPanel();
	JLabel lblId = new JLabel("* ¥�����");
	JTextField tfId = new JTextField(15);
	JLabel lblNum = new JLabel("* ��������");
	JTextField tfNum = new JTextField(15);
	JLabel lblFlr = new JLabel("* ¥������");
	JTextField tfFlr = new JTextField(15);
	JLabel lblPeo = new JLabel("* Ӧס����");
	JTextField tfPeo = new JTextField(15);
	JButton butSure = new JButton("����");
	JButton butDelete = new JButton("ɾ��");
	JButton butCancel = new JButton("ȡ��");
	
	int index = 0;
	
	int houId;
	
	String houRoomNum = "";
	String houFlr = "";
	String houPeo = "";
	
	HouInfoQueryFrame houInfoQueryFrame;
	
	public UpdateHouInfoFrame(HouInfoQueryFrame houInfoQueryFrame, int houId) {
		this.houInfoQueryFrame = houInfoQueryFrame;
		this.houId = houId;
		this.addPanelUp();
		this.add(panelUp);
		this.setTitle("����¥����Ϣ");
		this.setIconImage(Tools.img);
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.initData();
	}
	
	private boolean check() {
		if(!this.checkHouRoomNum()) {
			JOptionPane.showMessageDialog(this, "����������д����ȷ��");
			return false;
		} else if(!this.checkHouFlr()) {
			JOptionPane.showMessageDialog(this, "¥��������д����ȷ��");
			return false;
		} else if(!this.checkHouPeo()) {
			JOptionPane.showMessageDialog(this, "Ӧס������д����ȷ��");
			return false;
		}
		return true;
	}
	
	private boolean checkHouRoomNum() {
		houRoomNum = tfNum.getText().trim();
		if(houRoomNum.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkHouFlr() {
		houFlr = tfFlr.getText().trim();
		if(houFlr.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkHouPeo() {
		houPeo = tfPeo.getText().trim();
		if(houPeo.equals("")) {
			return false;
		}
		return true;
	}
	
	private void initData() {
		HouDAO houDAO = new HouDAO();
		Hou hou = houDAO.getHouInfoByHouId(houId);
		tfId.setText(hou.getHouId()+"");
		tfNum.setText(hou.getHouNum()+"");
		tfFlr.setText(hou.getHouFlr()+"");
		tfPeo.setText(hou.getHouPeo()+"");
	}


	private void addPanelUp() {
		panelUp.setLayout(new GridLayout(5, 1));
		panelUp.add(panelUp1);
		panelUp.add(panelUp2);
		panelUp.add(panelUp3);
		panelUp.add(panelUp4);
		panelUp.add(panelUp5);
		panelUp1.add(lblId);
		panelUp1.add(tfId);
		panelUp2.add(lblNum);
		panelUp2.add(tfNum);
		panelUp3.add(lblFlr);
		panelUp3.add(tfFlr);
		panelUp4.add(lblPeo);
		panelUp4.add(tfPeo);
		panelUp5.add(butSure);
		panelUp5.add(butDelete);
		panelUp5.add(butCancel);
		tfId.setEditable(false);
		panelUp.setBorder(BorderFactory.createTitledBorder("����¥����Ϣ"));
		butSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butSureActionPerformed(e);
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
	
	protected void butDeleteActionPerformed(ActionEvent e) {
		houId = Integer.parseInt(tfId.getText().trim());
		HouDAO houDAO = new HouDAO();
		int people = houDAO.getStuNumByHouId(houId);
		if(people>0) {
			JOptionPane.showMessageDialog(this, "��¥���л���ѧ����ס���ݲ���ɾ����");
		} else {
			if(houDAO.deleteHouByHouId(houId)) {
				this.initTable();
				JOptionPane.showMessageDialog(this, "ɾ��¥���ɹ���");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "ɾ��¥��ʧ�ܣ�");
			}
		}
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			HouDAO houDAO = new HouDAO();
			Hou hou = new Hou();
			hou.setHouId(Integer.parseInt(tfId.getText().trim()));
			hou.setHouNum(Integer.parseInt(tfNum.getText().trim()));
			hou.setHouFlr(Integer.parseInt(tfFlr.getText().trim()));
			hou.setHouPeo(Integer.parseInt(tfPeo.getText().trim()));
			if(houDAO.updateHouInfo(hou)) {
				this.initTable();
				JOptionPane.showMessageDialog(this, "����¥����Ϣ�ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "����¥����Ϣʧ�ܣ�");
			}
		}
	}
	
	private void initTable() {
		this.houInfoQueryFrame.initTableData();
	}
	
}
