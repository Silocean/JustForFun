package com.hblg.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
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
import com.hblg.dao.StudentDAO;
import com.hblg.entity.Dormitory;
import com.hblg.entity.Employee;

public class UpdateEmployeeInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	
	JLabel lblEmpId = new JLabel("* 雇员编号");
	JTextField tfEmpId = new JTextField(10);
	JLabel lblEmpName = new JLabel("* 雇员姓名");
	JTextField tfEmpName = new JTextField(10);
	JLabel lblEmpAge = new JLabel("* 雇员年龄");
	JTextField tfEmpAge = new JTextField(10);
	JLabel lblEmpSex = new JLabel("* 雇员性别");
	JComboBox<String> cbEmpSex = new JComboBox<String>();
	JLabel lblEmpHouId = new JLabel("* 所属楼栋");
	JComboBox<String> cbEmpHouId = new JComboBox<String>();
	JLabel lblEmpJob = new JLabel("雇员职位");
	JTextField tfEmpJob = new JTextField(10);
	JLabel lblEmpAddress = new JLabel("家庭住址");
	JTextField tfEmpAddress = new JTextField(27);
	JLabel lblEmpTel = new JLabel("联系电话");
	JTextField tfEmpTel = new JTextField(27);
	JLabel lblEmpRemark = new JLabel("备注");
	JTextArea taEmpRemark = new JTextArea(3, 25);
	
	JButton butSure = new JButton("更改");
	JButton butDelete = new JButton("删除");
	JButton butCancel = new JButton("取消");
	
	EmployeeInfoQueryFrame employeeInfoQueryFrame;

	JScrollPane sp = new JScrollPane(taEmpRemark,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String empId= "";
	
	String empName = "";
	String empAge = "";
	String empSex = "";
	String empHouId = "";
	String empJob = "";
	String empAddress = "";
	String empTel = "";
	String empRemark = "";
	
	public UpdateEmployeeInfoFrame(EmployeeInfoQueryFrame employeeInfoQueryFrame, String empId) {
		this.employeeInfoQueryFrame = employeeInfoQueryFrame;
		this.empId = empId;
		this.initPanel();
		this.initDorHouIdData();
		this.setTitle("更改员工信息");
		this.setIconImage(Tools.img);
		this.setSize(410, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.initData();
	}
	
	private void initDorHouIdData() {
		HouDAO houDAO = new HouDAO();
		List<String> list = houDAO.getAllHouId();
		for(int i=0; i<list.size(); i++) {
			cbEmpHouId.addItem(list.get(i));
		}
	}

	
	private void initData() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		Employee emp = employeeDAO.getEmpInfoByEmpId(empId);
		tfEmpId.setText(emp.getEmpId().trim());
		tfEmpName.setText(emp.getEmpName().trim());
		tfEmpAge.setText(emp.getEmpAge()+"");
		cbEmpSex.setSelectedItem(emp.getEmpSex().trim());
		cbEmpHouId.setSelectedItem(emp.getEmpHouId()+"");
		tfEmpJob.setText(emp.getEmpJob().trim());
		tfEmpAddress.setText(emp.getEmpAddress().trim());
		tfEmpTel.setText(emp.getEmpTel().trim());
		taEmpRemark.setText(emp.getEmpRemark().trim());
	}

	private void initPanel() {
		panel.setBorder(BorderFactory.createTitledBorder("更改员工基本信息"));
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
		cbEmpSex.addItem("请选择员工性别");
		cbEmpSex.addItem("男");
		cbEmpSex.addItem("女");
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
		panel7.add(butDelete);
		panel7.add(butCancel);
		tfEmpId.setEditable(false);
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
		empId = tfEmpId.getText().trim();
		EmployeeDAO employeeDAO = new EmployeeDAO();
		if(employeeDAO.deleteEmployeeByEmpId(empId)) {
			this.initTable();
			JOptionPane.showMessageDialog(this, "删除雇员成功！");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "删除雇员失败！");
		}
	}

	private boolean check() {
		if(!this.checkEmpName()) {
			JOptionPane.showMessageDialog(this, "雇员姓名填写有误！");
			return false;
		} else if(!this.checkEmpAge()) {
			JOptionPane.showMessageDialog(this, "雇员年龄填写有误！");
			return false;
		} else if(!this.checkEmpSex()) {
			JOptionPane.showMessageDialog(this, "雇员性别填写有误！");
			return false;
		} else if(!this.checkEmpHouId()) {
			JOptionPane.showMessageDialog(this, "雇员所属楼栋填写有误！");
			return false;
		} else {
			empId = tfEmpId.getText().trim();
			empName = tfEmpName.getText().trim();
			empAge = tfEmpAge.getText().trim();
			empJob = tfEmpJob.getText().trim();
			empAddress = tfEmpAddress.getText().trim();
			empTel = tfEmpTel.getText().trim();
			empRemark = taEmpRemark.getText().trim();
		}
		return true;
	}
	
	private boolean checkEmpHouId() {
		if(empHouId.equals("") || empHouId.equals("请选择楼房编号")) {
			return false;
		}
		return true;
	}

	private boolean checkEmpSex() {
		if(empSex.equals("") || empSex.equals("请选择雇员性别")) {
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
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setEmpAge(Integer.parseInt(empAge));
			emp.setEmpSex(empSex);
			emp.setEmpHouId(Integer.parseInt(empHouId));
			emp.setEmpJob(empJob);
			emp.setEmpAddress(empAddress);
			emp.setEmpTel(empTel);
			emp.setEmpRemark(empRemark);
			if(employeeDAO.updateEmpInfo(emp)) {
				this.initTable();
				JOptionPane.showMessageDialog(this, "更改员工基本信息成功！");
			} else {
				JOptionPane.showMessageDialog(this, "更改员工基本信息失败！");
			}
		}
	}
	
	public void initTable() {
		this.employeeInfoQueryFrame.initTableData();
	}

}
