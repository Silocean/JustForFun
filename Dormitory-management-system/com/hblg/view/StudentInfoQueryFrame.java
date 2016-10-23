package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.StudentDAO;
import com.hblg.entity.Student;
import com.hblg.view.model.StudentTableModel;

public class StudentInfoQueryFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	
	JLabel lblQuery = new JLabel("请输入关键字");
	JTextField tfQuery = new JTextField(15);
	JButton butSure = new JButton("查询");
	
	ButtonGroup bg = new ButtonGroup();
	JRadioButton rbStuId = new JRadioButton("学号");
	JRadioButton rbStuName = new JRadioButton("姓名");
	JRadioButton rbStuClass = new JRadioButton("班级");
	JRadioButton rbStuDormId = new JRadioButton("寝室");
	
	JTable table = new JTable();
	
	JScrollPane sp = new JScrollPane(table);
	
	StudentTableModel stm = new StudentTableModel();
	
	int condition = 0; //查询条件
	
	String stuId;
	String stuName;
	String stuClass;
	String stuDormId;
	
	public StudentInfoQueryFrame() {
		this.initPanel();
		this.initTable();
		this.setTitle("学生信息查询");
		this.setIconImage(Tools.img);
		this.setSize(850, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void initTable() {
		table.setModel(stm);
		table.getTableHeader().setReorderingAllowed(false);
	}
	
	private boolean check() {
		if(tfQuery.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "你还没有输入关键字呢！！！");
			return false;
		} else if(condition == 0){
			JOptionPane.showMessageDialog(this, "你还没选择查询条件呢！！！");
			return false;
		}
		return true;
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(panelUp, BorderLayout.NORTH);
		this.add(panelDown, BorderLayout.CENTER);
		panelUp.setBorder(BorderFactory.createTitledBorder("按条件查询"));
		panelUp.setLayout(new GridLayout(2, 1));
		panelDown.setBorder(BorderFactory.createTitledBorder("学生基本信息"));
		panelUp.add(panel1);
		panelUp.add(panel2);
		panel1.add(lblQuery);
		panel1.add(tfQuery);
		panel1.add(butSure);
		panel2.add(rbStuId);
		panel2.add(rbStuName);
		panel2.add(rbStuClass);
		panel2.add(rbStuDormId);
		bg.add(rbStuId);
		bg.add(rbStuName);
		bg.add(rbStuClass);
		bg.add(rbStuDormId);
		panelDown.setLayout(new BorderLayout());
		panelDown.add(sp);
		rbStuId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbStuIdActonPerformed(e);
			}
		});
		rbStuName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbStuNameActonPerformed(e);
			}
		});
		rbStuClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbStuClassActonPerformed(e);
			}
		});
		rbStuDormId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rbStuDormIdActonPerformed(e);
			}
		});
		butSure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butSureActionPerformed(e);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
		tfQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfQueryActionPerformed(e);
			}
		});
	}

	protected void tfQueryActionPerformed(ActionEvent e) {
		this.query();
	}

	protected void tableMouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int row = table.getSelectedRow();
			String stuId = (String) table.getValueAt(row, 0);
			new UpdateStudentInfoFrame(this, stuId, condition);
		}
	}

	protected void butSureActionPerformed(ActionEvent e) {
		this.query();
	}

	private void query() {
		if(this.check()) {
			if(condition == 1) {
				stuId = tfQuery.getText().trim();
				this.initTableData1();
			} else if(condition == 2) {
				stuName = tfQuery.getText().trim();
				this.initTableData2();
			} else if(condition == 3) {
				stuClass = tfQuery.getText().trim();
				this.initTableData3();
			} else if(condition == 4) {
				stuDormId = tfQuery.getText().trim();
				this.initTableData4();
			}
		}
	}

	protected void rbStuDormIdActonPerformed(ActionEvent e) {
		condition = 4;
	}

	protected void rbStuClassActonPerformed(ActionEvent e) {
		condition = 3;
	}

	protected void rbStuNameActonPerformed(ActionEvent e) {
		condition = 2;
	}

	protected void rbStuIdActonPerformed(ActionEvent e) {
		condition = 1;
	}
	
	public void initTableData1() {
		// 删除表中已有数据
		int count = stm.getRowCount();
		while(count>=1) {
			stm.removeRow(--count);
		}
		StudentDAO studentDAO = new StudentDAO();
		Student stu = studentDAO.getStuInfoByStuId(stuId);
		stm.addStudent(stu);
	}
	
	public void initTableData2() {
		// 删除表中已有数据
		int count = stm.getRowCount();
		while(count>=1) {
			stm.removeRow(--count);
		}
		StudentDAO studentDAO = new StudentDAO();
		List<Student> list = studentDAO.getStuInfoByStuName(stuName);
		stm.addStuList(list);
	}
	
	public void initTableData3() {
		// 删除表中已有数据
		int count = stm.getRowCount();
		while(count>=1) {
			stm.removeRow(--count);
		}
		StudentDAO studentDAO = new StudentDAO();
		List<Student> list = studentDAO.getStuInfoByStuClass(stuClass);
		stm.addStuList(list);
	}
	
	public void initTableData4() {
		// 删除表中已有数据
		int count = stm.getRowCount();
		while(count>=1) {
			stm.removeRow(--count);
		}
		StudentDAO studentDAO = new StudentDAO();
		List<Student> list = studentDAO.getStuInfoByDormId(stuDormId);
		stm.addStuList(list);
	}

}
