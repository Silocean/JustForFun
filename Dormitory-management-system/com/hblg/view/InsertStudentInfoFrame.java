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
import javax.swing.plaf.basic.BasicComboBoxEditor;

import com.hblg.common.Tools;
import com.hblg.dao.DormitoryDAO;
import com.hblg.dao.StudentDAO;
import com.hblg.entity.Student;

public class InsertStudentInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	
	JLabel lblStuId = new JLabel("* ѧ��");
	JTextField tfStuId = new JTextField(13);
	JLabel lblSutName = new JLabel("* ����");
	JTextField tfStuName = new JTextField(10);
	JLabel lblStuDormId = new JLabel("* ���Һ�");
	JTextField tfStuDormId = new JTextField(10);
	JLabel lblStuSex = new JLabel("* �Ա�");
	JComboBox<String> cbStuSex = new JComboBox<String>();
	JLabel lblStuInDate = new JLabel("* ��ѧ����");
	JTextField tfStuInDate = new JTextField(10);
	JLabel lblStuBirDate = new JLabel("* ��������");
	JTextField tfStuBirDate = new JTextField(10);
	JLabel lblStuCollege = new JLabel("* ����ѧԺ");
	JTextField tfStuCollege = new JTextField(10);
	JLabel lblStuClass = new JLabel("* �����༶");
	JTextField tfStuClass= new JTextField(10);
	JLabel lblStuPolit = new JLabel("������ò");
	JTextField tfStuPolit = new JTextField(10);
	JLabel lblStuTel = new JLabel("��ϵ�绰");
	JTextField tfStuTel = new JTextField(10);
	JLabel lblStuAddress = new JLabel("��ͥסַ");
	JTextField tfStuAddress = new JTextField(25);
	JLabel lblStuRemark = new JLabel("��ע");
	JTextArea taStuRemark = new JTextArea(2, 25);
	JButton butSure = new JButton("ȷ������");
	JButton butCancel = new JButton("ȡ��");
	
	JLabel lblSign = new JLabel();
	
	JScrollPane sp = new JScrollPane(taStuRemark, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String stuId = "";
	String stuName = "";
	String stuDormId = "";
	String stuSex = "";
	String stuInDate = "";
	String stuBirDate = "";
	String stuCollege = "";
	String stuClass = "";
	String stuPolit = "";
	String stuTel = "";
	String stuAddress = "";
	String stuRemark = "";
	
	public InsertStudentInfoFrame() {
		this.initPanel();
		this.setTitle("������ס");
		this.setIconImage(Tools.img);
		this.setSize(410, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initPanel() {
		panel.setLayout(new GridLayout(8, 1));
		panel.setBorder(BorderFactory.createTitledBorder("����ѧ����Ϣ"));
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		panel.add(panel4);
		panel.add(panel5);
		panel.add(panel6);
		panel.add(panel7);
		panel.add(panel8);
		panel1.add(lblStuId);
		panel1.add(tfStuId);
		panel1.add(lblSutName);
		panel1.add(tfStuName);
		panel2.add(lblStuDormId);
		panel2.add(tfStuDormId);
		panel2.add(lblStuSex);
		panel2.add(cbStuSex);
		cbStuSex.addItem("��ѡ��ѧ���Ա�");
		cbStuSex.addItem("��");
		cbStuSex.addItem("Ů");
		panel3.add(lblStuInDate);
		panel3.add(tfStuInDate);
		panel3.add(lblStuBirDate);
		panel3.add(tfStuBirDate);
		panel4.add(lblStuCollege);
		panel4.add(tfStuCollege);
		panel4.add(lblStuClass);
		panel4.add(tfStuClass);
		panel5.add(lblStuPolit);
		panel5.add(tfStuPolit);
		panel5.add(lblStuTel);
		panel5.add(tfStuTel);
		panel6.add(lblStuAddress);
		panel6.add(tfStuAddress);
		panel7.add(lblStuRemark);
		panel7.add(sp);
		panel8.add(butSure);
		panel8.add(butCancel);
		panel8.add(lblSign);
		this.add(panel);
		cbStuSex.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbStuSexItemStateChanged(e);
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
		if(!this.checkStuId()) {
			JOptionPane.showMessageDialog(this, "ѧ����д����ȷ��");
			return false;
		} else if(!this.checkStuName()) {
			JOptionPane.showMessageDialog(this, "������д����ȷ��");
			return false;
		} else if(!this.checkStuDormId()) {
			JOptionPane.showMessageDialog(this, "���Һ���д����ȷ��");
			return false;
		} else if(!this.checkStuSex()) {
			JOptionPane.showMessageDialog(this, "�Ա���д����ȷ��");
			return false;
		} else if(!this.checkStuInDate()) {
			JOptionPane.showMessageDialog(this, "��ѧ������д����ȷ��");
			return false;
		} else if(!this.checkStuBirDate()) {
			JOptionPane.showMessageDialog(this, "����������д����ȷ��");
			return false;
		} else if(!this.checkStuCollege()) {
			JOptionPane.showMessageDialog(this, "����ѧԺ��д����ȷ��");
			return false;
		} else if(!this.checkStuClass()) {
			JOptionPane.showMessageDialog(this, "�����༶��д����ȷ��");
			return false;
		} else if(!this.checkIfStuExisted()){
			JOptionPane.showMessageDialog(this, "��ѧ���Ѵ��ڣ�");
			return false;
		} else if(this.checkIfStuDormExisted()) {
			JOptionPane.showMessageDialog(this, "�����Ҳ����ڣ�");
			return false;
		} else if(this.checkIfStuDormIsFullOfStu()) {
			JOptionPane.showMessageDialog(this, "�����������ˣ�");
			return false;
		} else {
			stuId = tfStuId.getText().trim();
			stuName = tfStuName.getText().trim();
			stuDormId = tfStuDormId.getText().trim();
			stuInDate = tfStuInDate.getText().trim();
			stuBirDate = tfStuBirDate.getText().trim();
			stuCollege = tfStuCollege.getText().trim();
			stuClass = tfStuClass.getText().trim();
			stuPolit = tfStuPolit.getText().trim();
			stuTel = tfStuTel.getText().trim();
			stuAddress = tfStuAddress.getText().trim();
			stuRemark = taStuRemark.getText().trim();
		}
		return true;
	}

	private boolean checkIfStuDormIsFullOfStu() {
		StudentDAO studentDAO = new StudentDAO();
		int num = studentDAO.getStuFactNumByDormId(stuDormId);
		if(num<4) {
			return false; //û������
		}
		return true; //�Ѿ�����
	}

	private boolean checkIfStuExisted() {
		StudentDAO studentDAO = new StudentDAO();
		List<String> list = studentDAO.getAllStuId(); 
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfStuId.getText().trim())) {
				return false;
			}
		}
		return true;
	}
	
	private boolean checkIfStuDormExisted() {
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		List<String> list = dormitoryDAO.getAllDormId();
		boolean flag = false;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfStuDormId.getText().trim())) {
				flag = true;
			}
		}
		if(flag) {
			return false; //�����Ҵ���
		}
		return true; //�����Ҳ�����
	}

	private boolean checkStuId() {
		stuId = tfStuId.getText().trim();
		if(stuId.equals("")) {
			return false;
		} else if(!stuId.matches("2011\\d{8}")) {
			return false;
		}
		return true;
	}

	private boolean checkStuName() {
		stuName = tfStuName.getText().trim();
		if(stuName.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkStuDormId() {
		stuDormId = tfStuDormId.getText().trim();
		if(stuDormId.equals("")) {
			return false;
		} else if(!stuDormId.matches("\\d{4}")) {
			return false;
		}
		return true;
	}
	
	private boolean checkStuSex() {
		if(stuSex.equals("") || stuSex.equals("��ѡ��ѧ���Ա�")) {
			return false;
		}
		return true;
	}

	private boolean checkStuInDate() {
		stuInDate = tfStuInDate.getText().trim();
		if(stuInDate.equals("")) {
			return false;
		} else if(!stuInDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
			return false;
		}
		return true;
	}

	private boolean checkStuBirDate() {
		stuBirDate = tfStuBirDate.getText().trim();
		if(stuBirDate.equals("")) {
			return false;
		} else if(!stuBirDate.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
			return false;
		}
		return true;
	}

	private boolean checkStuCollege() {
		stuCollege = tfStuCollege.getText().trim();
		if(stuCollege.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkStuClass() {
		stuClass = tfStuClass.getText().trim();
		if(stuClass.equals("")) {
			return false;
		}
		return true;
	}

	protected void cbStuSexItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			stuSex = e.getItem().toString();
		}
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			StudentDAO studentDAO = new StudentDAO();
			Student stu = new Student();
			stu.setStuId(stuId);
			stu.setStuName(stuName);
			stu.setStuDormId(stuDormId);
			stu.setStuSex(stuSex);
			stu.setStuInDate(stuInDate);
			stu.setStuBirDate(stuBirDate);
			stu.setStuCollege(stuCollege);
			stu.setStuClass(stuClass);
			stu.setStuPolit(stuPolit);
			stu.setStuTel(stuTel);
			stu.setStuAddress(stuAddress);
			stu.setStuRemark(stuRemark);
			if(studentDAO.save(stu)) {
				JOptionPane.showMessageDialog(this, "ѧ����ס�ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "ѧ����סʧ�ܣ�");
			}
		}
	}

}
