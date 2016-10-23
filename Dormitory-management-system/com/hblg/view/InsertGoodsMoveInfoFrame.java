package com.hblg.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.EmployeeDAO;
import com.hblg.dao.GoodsMoveDAO;
import com.hblg.dao.StudentDAO;
import com.hblg.entity.GoodsMove;

public class InsertGoodsMoveInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	
	JLabel lblGodsStuId = new JLabel("* ѧ��ѧ��");
	JTextField tfGodsStuId = new JTextField(10);
	JLabel lblGodsId = new JLabel("* ��Ʒ���");
	JTextField tfGodsId = new JTextField(10);
	JLabel lblGodsInTime = new JLabel("* ��¥ʱ��");
	JTextField tfGodsInTime = new JTextField(10);
	JLabel lblGodsLevTime = new JLabel("* ��¥ʱ��");
	JTextField tfGodsLevTime = new JTextField(10);
	JLabel lblGodsWatchId = new JLabel("* ֵ���˱��");
	JTextField tfGodsWatchId = new JTextField(25);
	JLabel lblGodsRemark = new JLabel("��ע");
	JTextArea taGodsRemark = new JTextArea(3, 25);
	
	JButton butSure = new JButton("ȷ���Ǽ�");
	JButton butCancel = new JButton("ȡ��");
	
	JScrollPane sp = new JScrollPane(taGodsRemark,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String godsStuId = "";
	String godsId = "";
	String godsInTime = "";
	String godsLevTime = "";
	String godsWatchId = "";
	
	public InsertGoodsMoveInfoFrame() {
		this.setTitle("��Ʒ����Ǽ�");
		this.setIconImage(Tools.img);
		this.initPanel();
		this.setSize(400, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initPanel() {
		panel.setBorder(BorderFactory.createTitledBorder("��Ʒ����Ǽ�"));
		panel.setLayout(new GridLayout(5, 1));
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel1.add(lblGodsStuId);
		panel1.add(tfGodsStuId);
		panel1.add(lblGodsId);
		panel1.add(tfGodsId);
		panel2.add(lblGodsInTime);
		panel2.add(tfGodsInTime);
		panel2.add(lblGodsLevTime);
		panel2.add(tfGodsLevTime);
		panel3.add(lblGodsWatchId);
		panel3.add(tfGodsWatchId);
		panel4.add(lblGodsRemark);
		panel4.add(sp);
		panel5.add(butSure);
		panel5.add(butCancel);
		this.add(panel);
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
	}
	
	private boolean check() {
		if(!this.checkGodsStuId()) {
			JOptionPane.showMessageDialog(this, "ѧ����д����ȷ��");
			return false;
		} else if(!this.checkGodsId()) {
			JOptionPane.showMessageDialog(this, "��Ʒ�����д����ȷ��");
			return false;
		} else if(!this.checkGodsInTime()) {
			JOptionPane.showMessageDialog(this, "��¥ʱ����д����ȷ��");
			return false;
		} else if(!this.checkGodsLevTime()) {
			JOptionPane.showMessageDialog(this, "��¥ʱ����д����ȷ��");
			return false;
		} else if(!this.checkGodsWatchId()){
			JOptionPane.showMessageDialog(this, "ֵ���˱����д����ȷ��");
			return false;
		} else if(this.checkIfStuExisted()) {
			JOptionPane.showMessageDialog(this, "��ѧ�������ڣ�");
			return false;
		} else if(!this.checkIfGodsIdExisted()) {
			JOptionPane.showMessageDialog(this, "����Ʒ����Ѵ��ڣ�");
			return false;
		} else if(this.checkIfgodsWatchIdExisted()) {
			JOptionPane.showMessageDialog(this, "��ֵ���˲����ڣ�");
			return false;
		} else {
			godsStuId = tfGodsStuId.getText().trim();
			godsId = tfGodsId.getText().trim();
			godsInTime = tfGodsInTime.getText().trim();
			godsLevTime = tfGodsLevTime.getText().trim();
			godsWatchId = tfGodsWatchId.getText().trim();
		}
		return true;
	}
	
	private boolean checkIfStuExisted() {
		StudentDAO studentDAO = new StudentDAO();
		List<String> list = studentDAO.getAllStuId(); 
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfGodsStuId.getText().trim())) {
				flag = true;
			}
		}
		if(flag) {
			return false; //��ѧ�Ŵ���
		}
		return true; //��ѧ�Ų�����
	}
	
	private boolean checkIfGodsIdExisted() {
		GoodsMoveDAO goodsMoveDAO = new GoodsMoveDAO();
		List<String> list = goodsMoveDAO.getAllGodsId();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(godsId)) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkIfgodsWatchIdExisted() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<String> list = employeeDAO.getAllEmpId();
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfGodsWatchId.getText().trim())) {
				flag = true;
			}
		}
		if(flag) {
			return false; //��ֵ����ID����
		}
		return true; //��ֵ����ID������
	}

	private boolean checkGodsStuId() {
		godsStuId = tfGodsStuId.getText().trim();
		if(godsStuId.equals("")) {
			return false;
		} else if(!godsStuId.matches("2011\\d{8}")) {
			return false;
		}
		return true;
	}

	private boolean checkGodsId() {
		godsId = tfGodsId.getText().trim();
		if(godsId.equals("")) {
			return false;
		} else if(!godsId.matches("\\d{8}")) {
			return false;
		}
		return true;
	}

	private boolean checkGodsInTime() {
		godsInTime = tfGodsInTime.getText().trim();
		if(godsInTime.equals("")) {
			return false;
		} else if(!godsInTime.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")){
			return false;
		}
		return true;
	}

	private boolean checkGodsLevTime() {
		godsLevTime = tfGodsLevTime.getText().trim();
		if(godsLevTime.equals("")) {
			return false;
		} else if(!godsLevTime.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")){
			return false;
		}
		return true;
	}

	private boolean checkGodsWatchId() {
		godsWatchId = tfGodsLevTime.getText().trim();
		if(godsWatchId.equals("")) {
			return false;
		} else if(godsWatchId.matches("\\d{3}")) {
			return false;
		}
		return true;
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			GoodsMoveDAO goodsMoveDAO = new GoodsMoveDAO();
			GoodsMove gm = new GoodsMove();
			gm.setGodsStuId(tfGodsStuId.getText().trim());
			gm.setGodsId(tfGodsId.getText().trim());
			gm.setGodsInTime(tfGodsInTime.getText().trim());
			gm.setGodsLevTime(tfGodsLevTime.getText().trim());
			gm.setGodsWatchId(tfGodsWatchId.getText().trim());
			gm.setGodsRemark(taGodsRemark.getText().trim());
			if(goodsMoveDAO.save(gm)) {
				JOptionPane.showMessageDialog(this, "�Ǽǳɹ���"); 
			} else {
				JOptionPane.showMessageDialog(this, "�Ǽ�ʧ�ܣ�");
			}
		}
	}
	
}
