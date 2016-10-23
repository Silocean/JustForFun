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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.StudentDAO;
import com.hblg.entity.Student;

public class UpdateDormStudentInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	
	JLabel lblStuId = new JLabel("ѧ��");
	JTextField tfStuId = new JTextField(13);
	JLabel lblSutName = new JLabel("����");
	JTextField tfStuName = new JTextField(10);
	JLabel lblStuDormId = new JLabel("���Һ�");
	JTextField tfStuDormId = new JTextField(10);
	JLabel lblStuSex = new JLabel("�Ա�");
	JTextField tfStuSex = new JTextField(10);
	JLabel lblStuInDate = new JLabel("��ѧ����");
	JTextField tfStuInDate = new JTextField(10);
	JLabel lblStuBirDate = new JLabel("��������");
	JTextField tfStuBirDate = new JTextField(10);
	JLabel lblStuCollege = new JLabel("����ѧԺ");
	JTextField tfStuCollege = new JTextField(10);
	JLabel lblStuClass = new JLabel("�����༶");
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
	
	String stuId; //���ڻ�ȡ��������ݵ�ѧ��
	
	DormitoryInfoQueryFrame dormitoryInfoQueryFrame; //DormitoryInfoQueryFrame�ľ�������ڲ���DormitoryInfoQueryFrame�е�table
	
	String stuId2;
	
	StudentInfoQueryFrame studentInfoQueryFrame;
	
	public UpdateDormStudentInfoFrame(DormitoryInfoQueryFrame dormitoryInfoQueryFrame, String stuId) {
		this.dormitoryInfoQueryFrame = dormitoryInfoQueryFrame;
		this.stuId = stuId;
		tfStuId.setEnabled(false);
		this.initPanel();
		this.setTitle("����ѧ����Ϣ");
		this.setIconImage(Tools.img);
		this.setSize(410, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.initData();
	}

	public UpdateDormStudentInfoFrame(StudentInfoQueryFrame studentInfoQueryFrame,String stuId2) {
		this.studentInfoQueryFrame = studentInfoQueryFrame;
		this.stuId2 = stuId2;
		tfStuId.setEnabled(false);
		this.initPanel();
		this.setTitle("����ѧ����Ϣ");
		this.setSize(410, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.initData();
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
		panel2.add(tfStuSex);
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
	
	private void initData() {
		StudentDAO studentDAO = new StudentDAO();
		Student stu = studentDAO.getStuInfoByStuId(stuId);
		//System.out.println(stu.getStuName());
		tfStuId.setText(stu.getStuId());
		tfStuName.setText(stu.getStuName());
		tfStuDormId.setText(stu.getStuDormId());
		tfStuSex.setText(stu.getStuSex());
		tfStuInDate.setText(stu.getStuInDate());
		tfStuBirDate.setText(stu.getStuBirDate());
		tfStuCollege.setText(stu.getStuCollege());
		tfStuClass.setText(stu.getStuClass());
		tfStuPolit.setText(stu.getStuPolit());
		tfStuTel.setText(stu.getStuTel());
		tfStuAddress.setText(stu.getStuAddress());
		taStuRemark.setText(stu.getStuRemark());
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		StudentDAO studentDAO = new StudentDAO();
		Student stu = new Student();
		stu.setStuId(tfStuId.getText().trim());
		stu.setStuName(tfStuName.getText().trim());
		stu.setStuDormId(tfStuDormId.getText().trim());
		stu.setStuSex(tfStuSex.getText().trim());
		stu.setStuInDate(tfStuInDate.getText().trim());
		stu.setStuBirDate(tfStuBirDate.getText().trim());
		stu.setStuCollege(tfStuCollege.getText().trim());
		stu.setStuClass(tfStuClass.getText().trim());
		stu.setStuPolit(tfStuPolit.getText().trim());
		stu.setStuTel(tfStuTel.getText().trim());
		stu.setStuAddress(tfStuAddress.getText().trim());
		stu.setStuRemark(taStuRemark.getText().trim());
		if(studentDAO.updateStuInfo(stu)) {
			dormitoryInfoQueryFrame.initTable2Data(); //ˢ��table2�������ݿ���ȡ����Ȼ��ˢ��
			JOptionPane.showMessageDialog(this, "����ѧ����Ϣ�ɹ���");
		} else {
			JOptionPane.showMessageDialog(this, "����ѧ����Ϣʧ�ܣ�");
		}
	}
	
}
