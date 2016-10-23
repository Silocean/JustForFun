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
import javax.swing.JTextField;

import com.hblg.common.Tools;
import com.hblg.dao.HouDAO;
import com.hblg.entity.Hou;

public class InsertHouInfoFrame extends JFrame {
	
	JPanel panelUp = new JPanel();
	JPanel panelDown = new JPanel();
	
	JPanel panelUp1 = new JPanel();
	JPanel panelUp2 = new JPanel();
	JPanel panelUp3 = new JPanel();
	JPanel panelUp4 = new JPanel();
	JPanel panelUp5 = new JPanel();
	JLabel lblId = new JLabel("* 楼房编号");
	JTextField tfId = new JTextField("4", 15);
	JLabel lblNum = new JLabel("* 房间数量");
	JTextField tfNum = new JTextField("140", 15);
	JLabel lblFlr = new JLabel("* 楼层数量");
	JTextField tfFlr = new JTextField("7", 15);
	JLabel lblPeo = new JLabel("* 应住人数");
	JTextField tfPeo = new JTextField("980", 15);
	JButton butSure = new JButton("确定插入");
	JButton butCancel = new JButton("取消");
	
	int index = 0;
	
	String houId = "";
	String houRoomNum = "";
	String houFlr = "";
	String houPeo = "";
	
	public InsertHouInfoFrame() {
		this.addPanelUp();
		this.add(panelUp);
		this.setTitle("楼房管理");
		this.setIconImage(Tools.img);
		this.setSize(350, 300);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
	}

	private void addPanelUp() {
		panelUp.setLayout(new GridLayout(5, 1));
		panelUp.add(panelUp1);
		panelUp.add(panelUp2);
		panelUp.add(panelUp3);
		panelUp.add(panelUp4);
		panelUp.add(panelUp5);
		panelUp1.add(lblId);
		panelUp1.add(tfId);
		panelUp2.add(lblNum);
		panelUp2.add(tfNum);
		panelUp3.add(lblFlr);
		panelUp3.add(tfFlr);
		panelUp4.add(lblPeo);
		panelUp4.add(tfPeo);
		panelUp5.add(butSure);
		panelUp5.add(butCancel);
		panelUp.setBorder(BorderFactory.createTitledBorder("插入楼房"));
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
		this.initId();
	}
	

	private boolean check() {
		if(!this.checkHouRoomNum()) {
			JOptionPane.showMessageDialog(this, "房间数量填写不正确！");
			return false;
		} else if(!this.checkHouFlr()) {
			JOptionPane.showMessageDialog(this, "楼层数量填写不正确！");
			return false;
		} else if(!this.checkHouPeo()) {
			JOptionPane.showMessageDialog(this, "应住人数填写不正确！");
			return false;
		}
		return true;
	}
	
	private boolean checkHouRoomNum() {
		houRoomNum = tfNum.getText().trim();
		if(houRoomNum.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkHouFlr() {
		houFlr = tfFlr.getText().trim();
		if(houFlr.equals("")) {
			return false;
		}
		return true;
	}

	private boolean checkHouPeo() {
		houPeo = tfPeo.getText().trim();
		if(houPeo.equals("")) {
			return false;
		}
		return true;
	}

	private void initId() {
		HouDAO houDAO = new HouDAO();
		int houId = houDAO.findMaxHouId() + 1;
		tfId.setText(houId+"");
		tfId.setEditable(false);
	}

	protected void butCancelActionPerformed(ActionEvent e) {
		this.dispose();
	}

	protected void butSureActionPerformed(ActionEvent e) {
		if(!this.check()) {
			return;
		} else {
			HouDAO houDAO = new HouDAO();
			Hou hou = new Hou();
			hou.setHouId(Integer.parseInt(tfId.getText().trim()));
			hou.setHouNum(Integer.parseInt(tfNum.getText().trim()));
			hou.setHouFlr(Integer.parseInt(tfFlr.getText().trim()));
			hou.setHouPeo(Integer.parseInt(tfPeo.getText().trim()));
			if(houDAO.save(hou)) {
				JOptionPane.showMessageDialog(this, "插入楼房成功！");
			} else {
				JOptionPane.showMessageDialog(this, "插入楼房失败！");
			}
		}
	}
	
}
