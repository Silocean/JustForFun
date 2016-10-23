package com.hblg.view;

import java.awt.BorderLayout;
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
import com.hblg.dao.EmployeeDAO;
import com.hblg.dao.HouDAO;
import com.hblg.entity.Employee;
import com.hblg.view.model.EmployeeTableModel;

public class EmployeeInfoQueryFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	JLabel lblEmpHouId = new JLabel("Ա������¥�����");
	JComboBox<String> cbEmpHouId = new JComboBox<String>();
	
	JTable table = new JTable();
	
	JScrollPane sp = new JScrollPane(table);
	
	EmployeeTableModel etm = new EmployeeTableModel();
	
	int empHouId;
	
	public EmployeeInfoQueryFrame() {
		this.initPanel();
		this.initHouId();
		this.initTable();
		this.setTitle("Ա����Ϣ��ѯ");
		this.setIconImage(Tools.img);
		this.setSize(700, 450);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initTable() {
		table.setModel(etm);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(panelUp, BorderLayout.NORTH);
		this.add(panelDown, BorderLayout.CENTER);
		panelUp.setBorder(BorderFactory.createTitledBorder("ѡ��Ա������¥�����"));
		panelDown.setBorder(BorderFactory.createTitledBorder("Ա��������Ϣ"));
		panelUp.add(lblEmpHouId);
		panelUp.add(cbEmpHouId);
		panelDown.setLayout(new BorderLayout());
		panelDown.add(sp);
		cbEmpHouId.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				cbHouIdItemStateChanged(e);
			}
		});
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				tableMouseClicked(e);
			}
		});
	}
	
	protected void tableMouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2) {
			int row = table.getSelectedRow();
			String empId = ((String) table.getValueAt(row, 0)).trim();
			new UpdateEmployeeInfoFrame(this, empId);
		}
	}

	protected void cbHouIdItemStateChanged(ItemEvent e) {
		if(!e.getItem().equals("��ѡ��¥�����")) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				empHouId = Integer.parseInt(e.getItem().toString());
				this.initTableData();
			}
		}
	}

	public void initTableData() {
		// ɾ��������������
		int count = etm.getRowCount();
		while(count>=1) {
			etm.removeRow(--count);
		}
		EmployeeDAO employeeDAO = new EmployeeDAO();
		List<Employee> list = employeeDAO.getEmpInfoByEmpId(empHouId);
		etm.addEmpList(list);
	}

	private void initHouId() {
		HouDAO houDAO = new HouDAO();
		List<String> list = houDAO.getAllHouId();
		for(int i=0; i<list.size(); i++) {
			cbEmpHouId.addItem(list.get(i));
		}
	}


}
