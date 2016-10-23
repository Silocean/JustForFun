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
import com.hblg.dao.StudentDAO;
import com.hblg.dao.UserDAO;
import com.hblg.entity.Student;

public class UpdateStudentInfoFrame extends JFrame {
	
	JPanel panel = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();
	JPanel panel6 = new JPanel();
	JPanel panel7 = new JPanel();
	JPanel panel8 = new JPanel();
	
	JLabel lblStuId = new JLabel("* 学号");
	JTextField tfStuId = new JTextField(13);
	JLabel lblSutName = new JLabel("* 姓名");
	JTextField tfStuName = new JTextField(10);
	JLabel lblStuDormId = new JLabel("* 寝室号");
	JTextField tfStuDormId = new JTextField(10);
	JLabel lblStuSex = new JLabel("* 性别");
	JComboBox<String> cbStuSex = new JComboBox<String>();
	JLabel lblStuInDate = new JLabel("* 入学日期");
	JTextField tfStuInDate = new JTextField(10);
	JLabel lblStuBirDate = new JLabel("* 出生日期");
	JTextField tfStuBirDate = new JTextField(10);
	JLabel lblStuCollege = new JLabel("* 所属学院");
	JTextField tfStuCollege = new JTextField(10);
	JLabel lblStuClass = new JLabel("* 所属班级");
	JTextField tfStuClass= new JTextField(10);
	JLabel lblStuPolit = new JLabel("政治面貌");
	JTextField tfStuPolit = new JTextField(10);
	JLabel lblStuTel = new JLabel("联系电话");
	JTextField tfStuTel = new JTextField(10);
	JLabel lblStuAddress = new JLabel("家庭住址");
	JTextField tfStuAddress = new JTextField(25);
	JLabel lblStuRemark = new JLabel("备注");
	JTextArea taStuRemark = new JTextArea(2, 25);
	JButton butSure = new JButton("确定");
	JButton butDelete = new JButton("删除");
	JButton butCancel = new JButton("取消");
	
	JLabel lblSign = new JLabel();
	
	JScrollPane sp = new JScrollPane(taStuRemark, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
	String stuId; //用于获取表格中数据的学号
	
	StudentInfoQueryFrame studentInfoQueryFrame; //studentInfoQueryFrame的句柄，用于操作studentInfoQueryFrame中的table
	
	int condition; //在刷新表格的时候用于获知要刷新哪一类数据(table1, table2, table3, table4)
	
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
	
	public UpdateStudentInfoFrame(StudentInfoQueryFrame studentInfoQueryFrame,String stuId, int condition) {
		this.studentInfoQueryFrame = studentInfoQueryFrame;
		this.stuId = stuId;
		this.condition = condition;
		tfStuId.setEnabled(false);
		this.initPanel();
		this.setTitle("更改学生信息");
		this.setIconImage(Tools.img);
		this.setSize(410, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.initData();
	}

	private void initPanel() {
		panel.setLayout(new GridLayout(8, 1));
		panel.setBorder(BorderFactory.createTitledBorder("更改学生信息"));
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
		cbStuSex.addItem("请选择学生性别");
		cbStuSex.addItem("男");
		cbStuSex.addItem("女");
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
		panel8.add(butDelete);
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
		stuId = tfStuId.getText().trim();
		StudentDAO studentDAO = new StudentDAO();
		if(studentDAO.deleteStudentByStuId(stuId)) {
			this.initTable();
			JOptionPane.showMessageDialog(this, "删除学生成功！");
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "删除学生失败！");
		}
	}

	protected void cbStuSexItemStateChanged(ItemEvent e) {
		if(e.getStateChange() == ItemEvent.SELECTED) {
			stuSex = e.getItem().toString();
		}
	}
	
	private void initData() {
		StudentDAO studentDAO = new StudentDAO();
		Student stu = studentDAO.getStuInfoByStuId(stuId);
		//System.out.println(stu.getStuName());
		tfStuId.setText(stu.getStuId());
		tfStuName.setText(stu.getStuName());
		tfStuDormId.setText(stu.getStuDormId());
		cbStuSex.setSelectedItem(stu.getStuSex());
		tfStuInDate.setText(stu.getStuInDate());
		tfStuBirDate.setText(stu.getStuBirDate());
		tfStuCollege.setText(stu.getStuCollege());
		tfStuClass.setText(stu.getStuClass());
		tfStuPolit.setText(stu.getStuPolit());
		tfStuTel.setText(stu.getStuTel());
		tfStuAddress.setText(stu.getStuAddress());
		taStuRemark.setText(stu.getStuRemark());
	}
	
	private boolean check() {
		if(!this.checkStuId()) {
			JOptionPane.showMessageDialog(this, "学号填写不正确！");
			return false;
		} else if(!this.checkStuName()) {
			JOptionPane.showMessageDialog(this, "姓名填写不正确！");
			return false;
		} else if(!this.checkStuDormId()) {
			JOptionPane.showMessageDialog(this, "寝室号填写不正确！");
			return false;
		} else if(!this.checkStuSex()) {
			JOptionPane.showMessageDialog(this, "性别填写不正确！");
			return false;
		} else if(!this.checkStuInDate()) {
			JOptionPane.showMessageDialog(this, "入学日期填写不正确！");
			return false;
		} else if(!this.checkStuBirDate()) {
			JOptionPane.showMessageDialog(this, "出生日期填写不正确！");
			return false;
		} else if(!this.checkStuCollege()) {
			JOptionPane.showMessageDialog(this, "所属学院填写不正确！");
			return false;
		} else if(!this.checkStuClass()) {
			JOptionPane.showMessageDialog(this, "所属班级填写不正确！");
			return false;
		} else if(this.checkIfStuDormExisted()) {
			JOptionPane.showMessageDialog(this, "该寝室不存在！");
			return false;
		} else if(this.checkIfStuDormIsFullOfStu()) {
			JOptionPane.showMessageDialog(this, "该寝室已满人！");
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
			return false; //没有满人
		}
		return true; //已经满人
	}
	
	private boolean checkIfStuDormExisted() {
		StudentDAO studentDAO = new StudentDAO();
		List<String> list = studentDAO.getAllStuId(); 
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).equals(tfStuId.getText().trim())) {
				return false;
			}
		}
		return true;
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
		if(stuSex.equals("") || stuSex.equals("请选择学生性别")) {
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
			if(studentDAO.updateStuInfo(stu)) {
				this.initTable();
				JOptionPane.showMessageDialog(this, "更改学生信息成功！");
			} else {
				JOptionPane.showMessageDialog(this, "更改学生信息失败！");
			}
		}
	}
	
	public void initTable() {
		if(condition == 1) {
			studentInfoQueryFrame.initTableData1(); //刷新table，从数据库中取数据然后刷新
		} else if(condition == 2) {
			studentInfoQueryFrame.initTableData2(); //刷新table，从数据库中取数据然后刷新
		} else if(condition == 3) {
			studentInfoQueryFrame.initTableData3(); //刷新table，从数据库中取数据然后刷新
		} else if(condition == 4) {
			studentInfoQueryFrame.initTableData4(); //刷新table，从数据库中取数据然后刷新
		}
	}
}
