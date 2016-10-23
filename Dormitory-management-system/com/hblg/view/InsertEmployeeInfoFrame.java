package com.hblg.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.EmployeeDAO;
import com.hblg.dao.HouDAO;
import com.hblg.entity.Employee;

public class InsertEmployeeInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	
	JLabel lblEmpId = new JLabel("* ��Ա���");
	JTextField tfEmpId = new JTextField(10);
	JLabel lblEmpName = new JLabel("* ��Ա����");
	JTextField tfEmpName = new JTextField(10);
	JLabel lblEmpAge = new JLabel("* ��Ա����");
	JTextField tfEmpAge = new JTextField(10);
	JLabel lblEmpSex = new JLabel("* ��Ա�Ա�");
	JComboBox<String> cbEmpSex = new JComboBox<String>();
	JLabel lblEmpHouId = new JLabel("* ����¥��");
	JComboBox<String> cbEmpHouId = new JComboBox<String>();
	JLabel lblEmpJob = new JLabel("��Աְλ");
	JTextField tfEmpJob = new JTextField(10);
	JLabel lblEmpAddress = new JLabel("��ͥסַ");
	JTextField tfEmpAddress = new JTextField(27);
	JLabel lblEmpTel = new JLabel("��ϵ�绰");
	JTextField tfEmpTel = new JTextField(27);
	JLabel lblEmpRemark = new JLabel("��ע");
	JTextArea taEmpRemark = new JTextArea(3, 25);
	
	JButton butSure = new JButton("ȷ������");
	JButton butCancel = new JButton("ȡ��");
	
	JLabel lblSign = new JLabel();
	

	JScrollPane sp = new JScrollPane(taEmpRemark,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String empName = "";
	String empAge = "";
	String empSex = "";
	String empHouId = "";
	String empJob = "";
	String empAddress = "";
	String empTel = "";
	String empRemark = "";
	
	public InsertEmployeeInfoFrame() {
		this.initPanel();
		this.initDorHouIdData();
		this.setTitle("����Ա��");
		this.setIconImage(Tools.img);
		this.setSize(410, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initDorHouIdData() {
		HouDAO houDAO = new HouDAO();
		List<String> list = houDAO.getAllHouId();
		for(int i=0; i<list.size(); i++) {
			cbEmpHouId.addItem(list.get(i));
		}
	}

	private void initPanel() {
		panel.setBorder(BorderFactory.createTitledBorder("����Ա��"));
		panel.setLayout(new GridLayout(7, 1));
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel1.add(lblEmpId);
		panel1.add(tfEmpId);
		panel1.add(lblEmpName);
		panel1.add(tfEmpName);
		panel2.add(lblEmpAge);
		panel2.add(tfEmpAge);
		panel2.add(lblEmpSex);
		panel2.add(cbEmpSex);
		cbEmpSex.addItem("��ѡ���Ա�Ա�");
		cbEmpSex.addItem("��");
		cbEmpSex.addItem("Ů");
		panel3.add(lblEmpHouId);
		panel3.add(cbEmpHouId);
		panel3.add(lblEmpJob);
		panel3.add(tfEmpJob);
		panel4.add(lblEmpAddress);
		panel4.add(tfEmpAddress);
		panel5.add(lblEmpTel);
		panel5.add(tfEmpTel);
		panel6.add(lblEmpRemark);
		panel6.add(sp);
		panel7.add(butSure);
		panel7.add(butCancel);
		panel7.add(lblSign);
		this.add(panel);
		cbEmpHouId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbEmpHouIdItemStateChanged(e);
			}
		});
		cbEmpSex.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbEmpSexItemStateChanged(e);
			}
		});
		butSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butSureActionPerformed(e);
			}
		});
		butCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butCancelActionPerformed(e);
			}
		});
		this.initEmpId();
	}
	
	private boolean check() {
		if(!this.checkEmpName()) {
			JOptionPane.showMessageDialog(this, "��Ա������д����");
			return false;
		} else if(!this.checkEmpAge()) {
			JOptionPane.showMessageDialog(this, "��Ա������д����");
			return false;
		} else if(!this.checkEmpSex()) {
			JOptionPane.showMessageDialog(this, "��Ա�Ա���д����");
			return false;
		} else if(!this.checkEmpHouId()) {
			JOptionPane.showMessageDialog(this, "��Ա����¥����д����");
			return false;
		} else if(!this.checkEmpId()) {
			JOptionPane.showMessageDialog(this, "�ù�Ա�Ѵ��ڣ�");
			return false;
		} else {
			empName = tfEmpName.getText().trim();
			empAge = tfEmpAge.getText().trim();
			empJob = tfEmpJob.getText().trim();
			empAddress = tfEmpAddress.getText().trim();
			empTel = tfEmpTel.getText().trim();
			empRemark = taEmpRemark.getText().trim();
		}
		return true;
	}


	private boolean checkEmpId() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<String> list = employeeDAO.getAllEmpId();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfEmpId.getText().trim())) {
				return false;
			}
		}
		return true;
	}

	private boolean checkEmpHouId() {
		if(empHouId.equals("") || empHouId.equals("��ѡ��¥�����")) {
			return false;
		}
		return true;
	}

	private boolean checkEmpSex() {
		if(empSex.equals("") || empSex.equals("��ѡ���Ա�Ա�")) {
			return false;
		}
		return true;
	}

	private boolean checkEmpAge() {
		empAge = tfEmpAge.getText().trim();
		if(empAge.equals("")) {
			return false;
		} else if(!empAge.matches("\\d+")) {
			return false;
		}
		return true;
	}

	private boolean checkEmpName() {
		empName = tfEmpName.getText().trim();
		if(empName.equals("")) {
			return false;
		}
		return true;
	}

	protected void cbEmpSexItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			empSex = e.getItem().toString();
		}
	}

	protected void cbEmpHouIdItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			empHouId = e.getItem().toString();
		}
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			EmployeeDAO employeeDAO = new EmployeeDAO();
			Employee emp = new Employee();
			emp.setEmpId(tfEmpId.getText().trim());
			emp.setEmpName(empName);
			emp.setEmpAge(Integer.parseInt(empAge));
			emp.setEmpSex(empSex);
			emp.setEmpHouId(Integer.parseInt(empHouId));
			emp.setEmpJob(empJob);
			emp.setEmpAddress(empAddress);
			emp.setEmpTel(empTel);
			emp.setEmpRemark(empRemark);
			if(employeeDAO.save(emp)) {
				JOptionPane.showMessageDialog(this, "����Ա���ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "����Ա��ʧ�ܣ�");
			}
		}
	}
	
	private void initEmpId() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		String maxEmpId = employeeDAO.getMaxEmpId();
		System.out.println(maxEmpId);
		int empId = Integer.parseInt(maxEmpId.trim());
		tfEmpId.setEditable(false);
		if(empId<9) {
			tfEmpId.setText("00"+(empId+1));
		} else if(empId>=9 && empId<99) {
			tfEmpId.setText("0"+(empId+1));
		} else {
			tfEmpId.setText((empId+1)+"");
		}
	}

}