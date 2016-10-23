package com.hblg.view;

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
import com.hblg.dao.DormitoryDAO;
import com.hblg.dao.EmployeeDAO;
import com.hblg.dao.HouDAO;
import com.hblg.dao.StudentDAO;
import com.hblg.entity.Dormitory;

public class UpdateDormitoryInfoFrame extends JFrame {

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
	
	JLabel lblDorId = new JLabel("* ���Һ���");
	JTextField tfDorId = new JTextField(10);
	JLabel lblDorHouId = new JLabel("* ����¥��");
	JComboBox<String> cbDorHouId = new JComboBox<String>();
	JLabel lblDorSex = new JLabel("* �����Ա�");
	JComboBox<String> cbDorSex = new JComboBox<String>();
	JLabel lblDorNum = new JLabel("* Ӧס����");
	JTextField tfDorNum = new JTextField("4", 10);
	JLabel lblDorPrice = new JLabel("ס�޷���");
	JTextField tfDorPrice = new JTextField(10);
	JLabel lblDorTel = new JLabel("��ϵ�绰");
	JTextField tfDorTel = new JTextField(10);
	JLabel lblDorRemark = new JLabel("��ע");
	JTextArea taDorRemark = new JTextArea(3, 25);

	JButton butSure = new JButton("����");
	JButton butDelete = new JButton("ɾ��");
	JButton butCancel = new JButton("ȡ��");

	JScrollPane sp = new JScrollPane(taDorRemark,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String dormId; //���ڻ�ȡ��������ݵ����Һ�
	
	DormitoryInfoQueryFrame dormitoryInfoQueryFrame; //DormitoryInfoQueryFrame�ľ�������ڲ���DormitoryInfoQueryFrame�е�table
	
	String dormHouId = "";
	String dormSex = "";
	String dormNum = "";
	String dormPrice = "";
	String dormTel = "";
	String dormRemark = "";
	
	public UpdateDormitoryInfoFrame(DormitoryInfoQueryFrame dormitoryInfoQueryFrame, String dormId) {
		this.dormitoryInfoQueryFrame = dormitoryInfoQueryFrame;
		this.dormId = dormId;
		this.initPanel();
		this.initDorHouIdData();
		this.add(panel);
		this.setTitle("����������Ϣ");
		this.setIconImage(Tools.img);
		this.setSize(410, 550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.initData();
	}
	
	private void initDorHouIdData() {
		HouDAO houDAO = new HouDAO();
		List<String> list = houDAO.getAllHouId();
		for(int i=0; i<list.size(); i++) {
			cbDorHouId.addItem(list.get(i));
		}
	}


	private void initData() {
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		Dormitory dorm = dormitoryDAO.getDormInfoByDormId(dormId);
		tfDorId.setText(dorm.getDormId());
		cbDorSex.setSelectedItem(dorm.getDormSex().trim());
		cbDorHouId.setSelectedItem(dorm.getDormHouId()+"");
		tfDorNum.setText(dorm.getDormNum()+"");
		tfDorPrice.setText(dorm.getDormPrice()+"");
		tfDorTel.setText(dorm.getDormTel());
		taDorRemark.setText(dorm.getDormRemark());
	}

	private void initPanel() {
		panel.setBorder(BorderFactory.createTitledBorder("����������Ϣ"));
		panel.setLayout(new GridLayout(2, 1));
		panel.add(panelUp);
		panel.add(panelDown);
		panelUp.setLayout(new GridLayout(3, 1));
		panelUp.add(panel1);
		panelUp.add(panel2);
		panelUp.add(panel3);
		panel1.add(lblDorId);
		panel1.add(tfDorId);
		tfDorId.setEditable(false);
		panel1.add(lblDorHouId);
		panel1.add(cbDorHouId);
		panel2.add(lblDorSex);
		panel2.add(cbDorSex);
		cbDorSex.addItem("��ѡ�������Ա�");
		cbDorSex.addItem("��");
		cbDorSex.addItem("Ů");
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
		panel5.add(butDelete);
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
		dormId = tfDorId.getText().trim();
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		StudentDAO studentDAO = new StudentDAO();
		int people = studentDAO.getStuFactNumByDormId(dormId);
		System.out.println(people);
		if(people>0) {
			JOptionPane.showMessageDialog(this, "�����һ���ѧ����ס���ݲ���ɾ����");
			return;
		} else {
			if(dormitoryDAO.deleteDormitoryByDormId(dormId)) {
				this.initTable();
				JOptionPane.showMessageDialog(this, "ɾ�����ҳɹ���");
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this, "ɾ������ʧ�ܣ�");
			}
		}
	}

	private boolean check() {
		if(!this.checkDorId()) {
			JOptionPane.showMessageDialog(this, "���Һ�����д����ȷ��");
			return false;
		} else if(!this.checkDorHouId()) {
			JOptionPane.showMessageDialog(this, "����¥����д����ȷ��");
			return false;
		} else if(!this.checkDorSex()) {
			JOptionPane.showMessageDialog(this, "�����Ա���д����ȷ��");
			return false;
		} else if(!this.checkDorNum()) {
			JOptionPane.showMessageDialog(this, "Ӧס������д����ȷ��");
			return false;
		} else if(!this.checkDorPrice()) {
			JOptionPane.showMessageDialog(this, "ס�޷�����д����ȷ��");
			return false;
		} else {
			dormId = tfDorId.getText().trim();
			dormNum = tfDorNum.getText().trim();
			dormPrice = tfDorPrice.getText().trim();
		}
		return true;
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
		if(dormHouId.equals("") || dormHouId.equals("��ѡ��¥�����")) {
			return false;
		}
		return true;
	}

	private boolean checkDorSex() {
		if(dormSex.equals("") || dormSex.equals("��ѡ�������Ա�")) {
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
			dorm.setDormPrice(Double.parseDouble(dormPrice));
			dorm.setDormTel(dormTel);
			dorm.setDormRemark(dormRemark);
			System.out.println(dorm);
			if(dormitoryDAO.updateDormInfo(dorm)) {
				this.initTable();
				JOptionPane.showMessageDialog(this, "����������Ϣ�ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "����������Ϣʧ�ܣ�");
			}
		}
	}
	
	public void initTable() {
		this.dormitoryInfoQueryFrame.initTable1Data(); //ˢ��table2�������ݿ���ȡ����Ȼ��ˢ��
	}

}
