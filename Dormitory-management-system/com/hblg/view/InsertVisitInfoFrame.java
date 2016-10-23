package com.hblg.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import com.hblg.dao.DormitoryDAO;
import com.hblg.dao.EmployeeDAO;
import com.hblg.dao.VisitDAO;
import com.hblg.entity.Visit;

public class InsertVisitInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	
	JLabel lblVisName = new JLabel("* 来访人姓名");
	JTextField tfVisName = new JTextField(10);
	JLabel lblVisHost = new JLabel("被访人姓名");
	JTextField tfVisHost = new JTextField(10);
	JLabel lblVisDormId = new JLabel("访问寝室号");
	JTextField tfVisDormId = new JTextField(10);
	JLabel lblVisWatchId = new JLabel("* 值班人编号");
	JTextField tfVisWatchId = new JTextField(10);
	JLabel lblVisInTime = new JLabel("* 来访时间");
	JTextField tfVisInTime = new JTextField(11);
	JLabel lblVisLevTime = new JLabel("* 离开时间");
	JTextField tfVisLevTime = new JTextField(12);
	JLabel lblVisCred = new JLabel("身份证号");
	JTextField tfVisCred = new JTextField(29);
	JLabel lblVisRemark = new JLabel("备注");
	JTextArea taVisRemark = new JTextArea(3, 27);
	
	JButton butSure = new JButton("确定登记");
	JButton butCancel = new JButton("取消");
	
	JScrollPane sp = new JScrollPane(taVisRemark,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	int autoId = 0;
	String visName = "";
	String visHost = "";
	String visDormId = "";
	String visWatchId = "";
	String visInTime = "";
	String visLevTime = "";
	String visCred = "";
	String visRemark = "";
	
	public InsertVisitInfoFrame() {
		this.initPanel();
		this.setTitle("登记人员来访登记信息");
		this.setIconImage(Tools.img);
		this.setSize(437, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initPanel() {
		panel.setBorder(BorderFactory.createTitledBorder("来访人员登记信息"));
		panel.setLayout(new GridLayout(6, 1));
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel1.add(lblVisName);
		panel1.add(tfVisName);
		panel1.add(lblVisHost);
		panel1.add(tfVisHost);
		panel2.add(lblVisDormId);
		panel2.add(tfVisDormId);
		panel2.add(lblVisWatchId);
		panel2.add(tfVisWatchId);
		panel3.add(lblVisInTime);
		panel3.add(tfVisInTime);
		panel3.add(lblVisLevTime);
		panel3.add(tfVisLevTime);
		panel4.add(lblVisCred);
		panel4.add(tfVisCred);
		panel5.add(lblVisRemark);
		panel5.add(sp);
		panel6.add(butSure);
		panel6.add(butCancel);
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
		if(!this.checkVisName()) {
			JOptionPane.showMessageDialog(this, "来访人姓名填写不正确！");
			return false;
		} else if(!this.checkVisHost()) {
			JOptionPane.showMessageDialog(this, "被访人姓名填写不正确！");
			return false;
		} else if(!this.checkVisDormId()) {
			JOptionPane.showMessageDialog(this, "访问寝室号填写不正确！");
			return false;
		} else if (!this.checkVisWatchId()) {
			JOptionPane.showMessageDialog(this, "值班人编号填写不正确！");
			return false;
		} else if(!this.checkVisInTime()) {
			JOptionPane.showMessageDialog(this, "来访时间填写不正确！");
			return false;
		} else if(!this.checkVisLevTime()) {
			JOptionPane.showMessageDialog(this, "离开时间填写不正确！");
			return false;
		} else if(this.checkIfStuDormExisted()) {
			JOptionPane.showMessageDialog(this, "访问寝室不存在！");
			return false;
		} else if(this.checkIfgodsWatchIdExisted()) {
			JOptionPane.showMessageDialog(this, "该值班人不存在！");
			return false;
		} else{
			this.setAutoId();
			visName = tfVisName.getText().trim();
			visHost = tfVisHost.getText().trim();
			visDormId = tfVisDormId.getText().trim();
			visWatchId = tfVisWatchId.getText().trim();
			visInTime = tfVisInTime.getText().trim();
			visLevTime = tfVisLevTime.getText().trim();
			visCred = tfVisCred.getText().trim();
			visRemark = taVisRemark.getText().trim();
		}
		return true;
	}
	
	private boolean checkIfStuDormExisted() {
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		List<String> list = dormitoryDAO.getAllDormId();
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfVisDormId.getText().trim())) {
				flag = true;
			}
		}
		if(flag) {
			return false; //该寝室存在
		}
		return true; //该寝室不存在
	}
	
	private boolean checkIfgodsWatchIdExisted() {
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<String> list = employeeDAO.getAllEmpId();
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfVisWatchId.getText().trim())) {
				flag = true;
			}
		}
		if(flag) {
			return false; //该值班人ID存在
		}
		return true; //该值班人ID不存在
	}

	private boolean checkVisName() {
		visName = tfVisName.getText().trim();
		if(visName.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkVisHost() {
		visHost = tfVisHost.getText().trim();
		if(visHost.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkVisDormId() {
		visDormId = tfVisDormId.getText().trim();
		if(visDormId.equals("")) {
			return false;
		} else if(!visDormId.matches("\\d{4}")) {
			return false;
		}
		return true;
	}

	private boolean checkVisWatchId() {
		visWatchId = tfVisWatchId.getText().trim();
		if(visWatchId.equals("")) {
			return false;
		} else if(!visWatchId.matches("\\d{3}")) {
			return false;
		}
		return true;
	}

	private boolean checkVisInTime() {
		visInTime = tfVisInTime.getText().trim();
		if(visInTime.equals("")) {
			return false;
		} else if(!visInTime.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")){
			return false;
		}
		return true;
	}

	private boolean checkVisLevTime() {
		visLevTime = tfVisLevTime.getText().trim();
		if(visLevTime.equals("")) {
			return false;
		} else if(!visLevTime.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}")){
			return false;
		}
		return true;
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}
	
	private void setAutoId() {
		VisitDAO visitDAO = new VisitDAO();
		autoId = visitDAO.getMaxId() + 1;
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			VisitDAO visitDAO = new VisitDAO();
			Visit vis = new Visit();
			vis.setAutoId(autoId);
			vis.setVisName(visName);
			vis.setVisHost(visHost);
			vis.setVisDormId(visDormId);
			vis.setVisWatchId(visWatchId);
			vis.setVisInTime(visInTime);
			vis.setVisLevTime(visLevTime);
			vis.setVisCred(visCred);
			vis.setVisRemark(visRemark);
			if(visitDAO.save(vis)) {
				JOptionPane.showMessageDialog(this, "登记人员来访信息成功！");
			} else {
				JOptionPane.showMessageDialog(this, "登记人员来访信息失败！");
			}
		}
	}

}
