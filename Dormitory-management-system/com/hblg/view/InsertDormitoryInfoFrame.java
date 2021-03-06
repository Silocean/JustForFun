package com.hblg.view;

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
import com.hblg.dao.DormitoryDAO;
import com.hblg.dao.HouDAO;
import com.hblg.entity.Dormitory;

public class InsertDormitoryInfoFrame extends JFrame {

	JPanel panel = new JPanel();

	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();

	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	
	JLabel lblSign = new JLabel();
	
	JLabel lblDorId = new JLabel("* 寝室号码");
	JTextField tfDorId = new JTextField(10);
	JLabel lblDorHouId = new JLabel("* 所属楼栋");
	JComboBox<String> cbDorHouId = new JComboBox<String>();
	JLabel lblDorSex = new JLabel("* 寝室性别");
	JComboBox<String> cbDorSex = new JComboBox<String>();
	JLabel lblDorNum = new JLabel("* 应住人数");
	JTextField tfDorNum = new JTextField("4", 10);
	JLabel lblDorPrice = new JLabel("* 住宿费用");
	JTextField tfDorPrice = new JTextField(10);
	JLabel lblDorTel = new JLabel("联系电话");
	JTextField tfDorTel = new JTextField(10);
	JLabel lblDorRemark = new JLabel("备注");
	JTextArea taDorRemark = new JTextArea(3, 25);

	JButton butSure = new JButton("确定插入");
	JButton butCancel = new JButton("取消");

	JScrollPane sp = new JScrollPane(taDorRemark,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String dormId = "";
	String dormHouId = "";
	String dormSex = "";
	String dormNum = "";
	String dormPrice = "";
	String dormTel = "";
	String dormRemark = "";

	public InsertDormitoryInfoFrame() {
		this.initPanel();
		this.initDorHouIdData();
		this.add(panel);
		this.setTitle("寝室管理");
		this.setIconImage(Tools.img);
		this.setSize(410, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initDorHouIdData() {
		HouDAO houDAO = new HouDAO();
		List<String> list = houDAO.getAllHouId();
		for(int i=0; i<list.size(); i++) {
			cbDorHouId.addItem(list.get(i));
		}
	}

	private void initPanel() {
		panel.setBorder(BorderFactory.createTitledBorder("插入寝室"));
		panel.setLayout(new GridLayout(2, 1));
		panel.add(panelUp);
		panel.add(panelDown);
		panelUp.setLayout(new GridLayout(3, 1));
		panelUp.add(panel1);
		panelUp.add(panel2);
		panelUp.add(panel3);
		panel1.add(lblDorId);
		panel1.add(tfDorId);
		panel1.add(lblDorHouId);
		panel1.add(cbDorHouId);
		panel2.add(lblDorSex);
		panel2.add(cbDorSex);
		cbDorSex.addItem("请选择寝室性别");
		cbDorSex.addItem("男");
		cbDorSex.addItem("女");
		panel2.add(lblDorNum);
		panel2.add(tfDorNum);
		panel3.add(lblDorPrice);
		panel3.add(tfDorPrice);
		panel3.add(lblDorTel);
		panel3.add(tfDorTel);
		panelDown.setLayout(new GridLayout(3, 1));
		panelDown.add(panel4);
		panelDown.add(panel5);
		panelDown.add(panel6);
		panel4.add(lblDorRemark);
		panel4.add(sp);
		panel5.add(butSure);
		panel5.add(butCancel);
		panel6.add(lblSign);
		cbDorSex.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbDorSexItemStateChanged(e);
			}
		});
		cbDorHouId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbDorHouIdItemStateChanged(e);
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
	}
	
	private boolean check() {
		if(!this.checkDorId()) {
			JOptionPane.showMessageDialog(this, "寝室号码填写不正确！");
			return false;
		} else if(!this.checkDorHouId()) {
			JOptionPane.showMessageDialog(this, "所属楼栋填写不正确！");
			return false;
		} else if(!this.checkDorSex()) {
			JOptionPane.showMessageDialog(this, "寝室性别填写不正确！");
			return false;
		} else if(!this.checkDorNum()) {
			JOptionPane.showMessageDialog(this, "应住人数填写不正确！");
			return false;
		} else if(!this.checkDorPrice()) {
			JOptionPane.showMessageDialog(this, "住宿费用填写不正确！");
			return false;
		} else if(!this.checkIfDorIdExisted()) {
			JOptionPane.showMessageDialog(this, "该寝室已存在！");
			return false;
		} else {
			dormId = tfDorId.getText().trim();
			dormNum = tfDorNum.getText().trim();
			dormPrice = tfDorPrice.getText().trim();
		}
		return true;
	}

	private boolean checkIfDorIdExisted() {
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		List<String> list = dormitoryDAO.getAllDormId();
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfDorId.getText().trim())) {
				flag = true;
			}
		}
		if(flag) {
			return false; //寝室存在
		}
		return true; //寝室不存在
	}

	private boolean checkDorId() {
		dormId = tfDorId.getText().trim();
		if(dormId.equals("")) {
			return false;
		} else if(!dormId.matches("\\d{4}")) {
			return false;
		}
		return true;
	}

	private boolean checkDorHouId() {
		if(dormHouId.equals("") || dormHouId.equals("请选择楼房编号")) {
			return false;
		}
		return true;
	}

	private boolean checkDorSex() {
		if(dormSex.equals("") || dormSex.equals("请选择寝室性别")) {
			return false;
		}
		return true;
	}

	private boolean checkDorNum() {
		dormNum = tfDorNum.getText().trim();
		if(dormNum.equals("")) {
			return false;
		} else if(!dormNum.matches("\\d")){
			return false;
		}
		return true;
	}

	private boolean checkDorPrice() {
		dormPrice = tfDorPrice.getText().trim();
		if(dormPrice.equals("")) {
			return false;
		} else if(!dormPrice.matches("\\d*.\\d*")) {
			return false;
		}
		return true;
	}

	protected void cbDorHouIdItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			dormHouId = e.getItem().toString();
		}
	}

	protected void cbDorSexItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			dormSex = e.getItem().toString();
		}
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			DormitoryDAO dormitoryDAO = new DormitoryDAO();
			Dormitory dorm = new Dormitory();
			dorm.setDormId(dormId);
			dorm.setDormHouId(Integer.parseInt(dormHouId));
			dorm.setDormSex(dormSex);
			dorm.setDormNum(Integer.parseInt(dormNum));
			String price = dormPrice;
			dorm.setDormPrice(Double.parseDouble(dormPrice));
			dorm.setDormTel(dormTel);
			dorm.setDormRemark(dormRemark);
			if(dormitoryDAO.save(dorm)) {
				JOptionPane.showMessageDialog(this, "插入寝室成功！");
			} else {
				JOptionPane.showMessageDialog(this, "插入寝室失败！");
			}
		}
	}
}
