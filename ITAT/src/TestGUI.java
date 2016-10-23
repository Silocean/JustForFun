import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TestGUI extends JFrame implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ta.setText(tf.getText()+'\n'+tf.getText()+'\n'+tf.getText());
	}

	JTextField tf = new JTextField();
	JTextArea ta = new JTextArea();
	JButton b = new JButton("Çå¿Õ");
	
	public TestGUI() {
		this.setLayout(new GridLayout(3, 1));
		this.add(tf);
		this.add(ta);
		this.add(b);
		b.addActionListener(new ButtonListener());
		tf.addActionListener(this);
		this.setBounds(300,200,600,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestGUI();
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tf.setText("");
			ta.setText(null);
		}
		
	}

}
