package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import com.hblg.entity.GoodsMove;
import com.hblg.view.model.GoodsLoginTableModel;

public class GoodsLoginInfoQueryFrame extends JFrame {
	
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
	
	GoodsLoginTableModel gltm = new GoodsLoginTableModel();
	
	String date;
	
	public GoodsLoginInfoQueryFrame() {
		this.initPanel();
		this.initTable();
		this.setTitle("��ѯ��Ʒ����Ǽ���Ϣ");
		this.setIconImage(Tools.img);
		this.setSize(610, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	private void initTable() {
		table.setModel(gltm);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void initPanel() {
		this.setLayout(new BorderLayout());
		this.add(panelUp, BorderLayout.NORTH);
		this.add(panelCenter, BorderLayout.CENTER);
		panelUp.setBorder(BorderFactory.createTitledBorder("ѡ��Ǽ�����"));
		panelCenter.setBorder(BorderFactory.createTitledBorder("��Ʒ�����Ǽ���Ϣ"));
		panelUp.add(lblDate);
		panelUp.add(tfDate);
		panelUp.add(butSure);
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(sp, BorderLayout.CENTER);
		panelCenter.add(panelDown, BorderLayout.SOUTH);
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
				tfDatelActionPerformed(e);
			}
		});
	}
	
	protected void tfDatelActionPerformed(ActionEvent e) {
		this.query();
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butDeleteActionPerformed(ActionEvent e) {
		int[] row = table.getSelectedRows();
		if(row.length == 0) {
			JOptionPane.showMessageDialog(this, "��ѡ����Ҫɾ���ļ�¼��");
			return;
		} else {
			List<String> goodsIdList = new ArrayList<String>();
			for(int i=0; i<row.length; i++) {
				String goodsId = ((String) table.getValueAt(row[i], 1)).trim();
				goodsIdList.add(goodsId);
			}
			GoodsMoveDAO goodsMoveDAO = new GoodsMoveDAO();
			if(goodsMoveDAO.deleteGodsInfoByGoodsId(goodsIdList)) {
				this.initTableData();
				JOptionPane.showMessageDialog(this, "ɾ���û��ɹ���");
			} else {
				JOptionPane.showMessageDialog(this, "ɾ���û�ʧ�ܣ�");
			}
		}
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
	
	private void query() {
		if(this.check()) {
			date = tfDate.getText().trim();
			this.initTableData();
		}
	}

	protected void butSureActionPerformed(ActionEvent e) {
		this.query();
	}
	
	public void initTableData() {
		// ɾ��������������
		int count = gltm.getRowCount();
		while(count>=1) {
			gltm.removeRow(--count);
		}
		GoodsMoveDAO goodsMoveDAO = new GoodsMoveDAO();
		List<GoodsMove> list = goodsMoveDAO.getGodsMovInfoByDate(date);
		gltm.addGodsMoveList(list);
	}

}
