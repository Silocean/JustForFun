package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.GoodsMoveDAO;
import com.hblg.dao.VisitDAO;
import com.hblg.entity.Visit;
import com.hblg.view.model.VisitLoginTableModel;

public class VisitLoginInfoQueryFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelCenter = new JPanel();
	JPanel panelDown = new JPanel();
	
	JLabel lblDate = new JLabel("�Ǽ�����");
	JTextField tfDate = new JTextField(10);
	JButton butSure = new JButton("��ѯ");
	
	JButton butDelete = new JButton("ɾ��");
	JButton butCancel = new JButton("ȡ��");
	
	JTable table = new JTable();
	JScrollPane sp = new JScrollPane(table);
	
	VisitLoginTableModel vltm = new VisitLoginTableModel();
	
	String date;
	
	public VisitLoginInfoQueryFrame() {
		this.initPanel();
		this.initTable();
		this.setTitle("��ѯ��Ա���õǼ���Ϣ");
		this.setIconImage(Tools.img);
		this.setSize(610, 400);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initTable() {
		table.setModel(vltm);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(panelUp, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		this.add(panelDown, BorderLayout.SOUTH);
		panelUp.setBorder(BorderFactory.createTitledBorder("ѡ��Ǽ�����"));
		panelCenter.setBorder(BorderFactory.createTitledBorder("��Ա���õǼ���Ϣ"));
		panelUp.add(lblDate);
		panelUp.add(tfDate);
		panelUp.add(butSure);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(sp);
		panelDown.add(butDelete);
		panelDown.add(butCancel);
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
		tfDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfDateActionPerformed(e);
			}
		});
	}
	
	protected void tfDateActionPerformed(ActionEvent e) {
		this.query();
	}

	protected void butDeleteActionPerformed(ActionEvent e) {
		int[] row = table.getSelectedRows();
		if(row.length == 0) {
			JOptionPane.showMessageDialog(this, "��ѡ����Ҫɾ���ļ�¼��");
			return;
		} else {
			List<Integer> autoIdList = new ArrayList<Integer>();
			for(int i=0; i<row.length; i++) {
				int autoId = ((Integer) table.getValueAt(row[i], 0));
				autoIdList.add(autoId);
			}
			VisitDAO visitDAO = new VisitDAO();
			if(visitDAO.deleteVisitInfoByAutoId(autoIdList)) {
				this.initTableData();
				JOptionPane.showMessageDialog(this, "ɾ���û��ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ���û�ʧ�ܣ�");
			}
		}
	}
	
	private void query() {
		if(this.check()) {
			date = tfDate.getText().trim();
			this.initTableData();
		}
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	private boolean check() {
		String text = tfDate.getText().trim();
		if(text.equals("")) {
			JOptionPane.showMessageDialog(this, "�㻹û��Ҫ��ѯ�������أ�����");
			return false;
		} else {
			return true;
		}
	}

	protected void butSureActionPerformed(ActionEvent e) {
		this.query();
	}
	
	public void initTableData() {
		// ɾ��������������
		int count = vltm.getRowCount();
		while(count>=1) {
			vltm.removeRow(--count);
		}
		VisitDAO visitDAO = new VisitDAO();
		List<Visit> list = visitDAO.getVisitInfoByDate(date);
		vltm.addVisitList(list);
	}

}
