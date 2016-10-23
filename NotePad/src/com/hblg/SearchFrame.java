package com.hblg;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SearchFrame extends Dialog implements WindowListener,ActionListener {
	
	JPanel p1, p2, p3;
	JLabel lSearch, lReplace;
	JTextField tSearch, tReplace;
	JButton b;
	
	
	public SearchFrame(Frame arg0, String arg1, boolean arg2) {
		super(arg0, arg1, arg2);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		b = new JButton("确定");
		lSearch = new JLabel("查找");
		lReplace = new JLabel("替换");
		tSearch = new JTextField(12);
		tReplace = new JTextField(12);
		p1.add(lSearch);
		p1.add(tSearch);
		p2.add(lReplace);
		p2.add(tReplace);
		p3.setLayout(new FlowLayout(FlowLayout.CENTER));
		p3.add(b);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		b.addActionListener(this);
		this.addWindowListener(this);
		this.setSize(300, 200);
		this.setModal(true);
		this.setLayout(new GridLayout(3, 1));
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String string = NotePad.ta.getText();
		String toFind = this.tSearch.getText();
		if(!toFind.equals("")) {
			int index = string.indexOf(toFind);
			int count = 0;
			while (index != -1) {
				//String str = string.substring(index, index+toFind.length());
				NotePad.ta.replaceRange(this.tReplace.getText(), index, index+toFind.length());
				index = string.indexOf(toFind, index+toFind.length());
				count ++;
			}
			System.out.println(count);
		} else {
			JOptionPane.showMessageDialog(this, "`(*∩_∩*)′，什么都没写啊！");
		}
	}
	
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
	}


	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	
}
