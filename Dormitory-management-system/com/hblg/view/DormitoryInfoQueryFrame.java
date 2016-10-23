package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.hblg.common.Tools;
import com.hblg.dao.DormitoryDAO;
import com.hblg.dao.StudentDAO;
import com.hblg.entity.Dormitory;
import com.hblg.entity.Student;
import com.hblg.view.model.DormitoryStuTableModel;
import com.hblg.view.model.DormitoryTableModel;

public class DormitoryInfoQueryFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	
	JLabel lblDormId = new JLabel("寝室号码");
	JComboBox<String> cbDormId = new JComboBox<String>();
	
	JTable table1 = new JTable();
	JTable table2 = new JTable();
	
	JScrollPane sp1 = new JScrollPane();
	JScrollPane sp2 = new JScrollPane();
	
	DormitoryTableModel  dtm = new DormitoryTableModel();
	DormitoryStuTableModel dstm = new DormitoryStuTableModel();
	
	String dormId;
	
	public DormitoryInfoQueryFrame() {
		this.initPanel();
		this.initTable();
		this.setLayout(new GridLayout(2, 1));
		this.setTitle("寝室信息查询");
		this.setIconImage(Tools.img);
		this.setSize(850, 450);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	private void initTable() {
		table1.setModel(dtm);
		table2.setModel(dstm);
		table1.getTableHeader().setReorderingAllowed(false);   //不可整列移动
		//table1.getTableHeader().setResizingAllowed(false);   //不可拉动表格
		table2.getTableHeader().setReorderingAllowed(false);   //不可整列移动
		//table2.getTableHeader().setResizingAllowed(false);   //不可拉动表格
	}

	private void initPanel() {
		this.add(panelUp);
		this.add(panelDown);
		panelUp.setLayout(new GridLayout(2, 1));
		panelUp.add(panel1);
		panelUp.add(panel2);
		panel1.setBorder(BorderFactory.createTitledBorder("选择寝室号"));
		panel2.setBorder(BorderFactory.createTitledBorder("寝室基本信息"));
		panel1.add(lblDormId);
		panel1.add(cbDormId);
		sp1.setViewportView(table1);
		sp2.setViewportView(table2);
		panel2.setLayout(new BorderLayout());
		panel2.add(sp1);
		panelDown.setBorder(BorderFactory.createTitledBorder("寝室学生信息"));
		panelDown.setLayout(new BorderLayout());
		panelDown.add(sp2);
		this.initDormId();
		cbDormId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cbDormIdItemStateChanged(e);
			}
		});
		table1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				table1MouseClicked(e);
			}
		});
		table2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				table2MouseClicked(e);
			}
		});
	}


	protected void table1MouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int row = table1.getSelectedRow();
			String dormId = (String) table1.getValueAt(row, 0);
			new UpdateDormitoryInfoFrame(this, dormId);
		}
	}

	protected void table2MouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int row = table2.getSelectedRow();
			String stuId = (String) table2.getValueAt(row, 0);
			new UpdateDormStudentInfoFrame(this, stuId);
		}
	}

	protected void cbDormIdItemStateChanged(ItemEvent e) {
		if(!e.getItem().equals("请选择寝室编号")) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				dormId = e.getItem().toString();
				this.initTable1Data();
				this.initTable2Data();
			}
		}
	}
	
	public void initTable1Data() {
		// 删除表中已有数据
		int count1 = dtm.getRowCount();
		while(count1>=1) {
			dtm.removeRow(--count1);
		}
		// dtm.fireTableStructureChanged();  //刷新table,注意只是单纯地刷新表格中的内容，并不从数据库中取数据然后刷新
		// dtm.fireTableDataChanged();
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		Dormitory dorm = dormitoryDAO.getDormInfoById(dormId);
		if(dorm.getDormId()!=null) {
			dtm.addDormitory(dorm);
		}
	}
	
	public void initTable2Data() {
		// 删除表中已有数据
		int count2 = dstm.getRowCount();
		while(count2>=1) {
			dstm.removeRow(--count2);
		}
		StudentDAO studentDAO = new StudentDAO();
		List<Student> list = studentDAO.getStuInfoByDormId(dormId);
		dstm.addStuList(list);
	}

	private void initDormId() {
		DormitoryDAO dormitoryDAO = new DormitoryDAO();
		List<String> list = dormitoryDAO.getAllDormId();
		for(int i=0; i<list.size(); i++) {
			cbDormId.addItem(list.get(i));
		}
	}

}
