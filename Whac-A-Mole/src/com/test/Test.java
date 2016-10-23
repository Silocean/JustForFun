package com.test;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame {
	
	JButton b = new JButton("ad");
	
	public Test() {
		b.setBounds(100, 50, 100, 100);
		this.add(b);
		this.setSize(400, 300);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Test();
	}

}
