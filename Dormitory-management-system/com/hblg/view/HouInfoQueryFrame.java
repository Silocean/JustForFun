package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
import com.hblg.dao.HouDAO;
import com.hblg.entity.Hou;
import com.hblg.view.model.HouTableModel;

public class HouInfoQueryFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	JLabel lblHouId = new JLabel("楼房编号");
	JComboBox<String> cbHouId = new JComboBox<String>();
	
	JTable table = new JTable();
	
	JScrollPane sp = new JScrollPane(table);
	
	HouTableModel htm = new HouTableModel();
	
	int houId;
	
	public HouInfoQueryFrame() {
		this.initPanel();
		this.initHouId();
		this.initTable();
		this.setTitle("楼栋信息查询");
		this.setIconImage(Tools.img);
		this.setSize(400, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initTable() {
		table.setModel(htm);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(panelUp, BorderLayout.NORTH);
		this.add(panelDown, BorderLayout.CENTER);
		panelUp.setBorder(BorderFactory.createTitledBorder("选择楼房编号"));
		panelDown.setBorder(BorderFactory.createTitledBorder("楼房基本信息"));
		panelUp.add(lblHouId);
		panelUp.add(cbHouId);
		panelDown.setLayout(new BorderLayout());
		panelDown.add(sp);
		cbHouId.addItemListener(new ItemListener(){
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
			new UpdateHouInfoFrame(this, houId);
		}
	}

	protected void cbHouIdItemStateChanged(ItemEvent e) {
		if(!e.getItem().equals("请选择楼房编号")) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				houId = Integer.parseInt(e.getItem().toString());
				this.initTableData();
			}
		}
	}

	public void initTableData() {
		// 删除表中已有数据
		int count = htm.getRowCount();
		while(count>=1) {
			htm.removeRow(--count);
		}
		HouDAO houDAO = new HouDAO();
		Hou hou = houDAO.getHouInfoById(houId);
		if(hou.getHouId()!=0) {
			htm.addDormitory(hou);
		}
	}

	private void initHouId() {
		HouDAO houDAO = new HouDAO();
		List<String> list = houDAO.getAllHouId();
		for(int i=0; i<list.size(); i++) {
			cbHouId.addItem(list.get(i));
		}
	}

}
