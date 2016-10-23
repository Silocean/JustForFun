import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TestCalculator extends JFrame implements ActionListener {
	
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JTextField tf = new JTextField(15);
	
	String num1_str = "";
	String num2_str = "";
	String operator = "+";
	
	boolean append = false;
	
	public TestCalculator() {
		p1.add(tf);
		this.add(p1, BorderLayout.NORTH);
		this.add(p2, BorderLayout.CENTER);
		p2.setLayout(new GridLayout(4, 4));
		String[] label = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
		for(int i=0; i<label.length; i++) {
			JButton b = new JButton(label[i]);
			p2.add(b);
			b.addActionListener(this);
		}
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCalculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String com = e.getActionCommand();
		
		//System.out.println(com);
		if("0123456789".indexOf(com) != -1) {
			if(append == false) {
				tf.setText(com);
			}
			if(append == true) {
				tf.setText(tf.getText() + com);
			}
		} else if("+-*/".indexOf(com) != -1) {
			num1_str = tf.getText();
			operator = com;
			append = false;
		} else if("=".equals(com)) {
			num2_str = tf.getText();
			if(operator.equals("+")) {
				double num1 = Double.parseDouble(num1_str);
				double num2 = Double.parseDouble(num2_str);
				tf.setText(num1 + num2 + "");
			} else if(operator.equals("-")) {
				double num1 = Double.parseDouble(num1_str);
				double num2 = Double.parseDouble(num2_str);
				tf.setText(num1 - num2 + "");
			} else if(operator.equals("*")) {
				double num1 = Double.parseDouble(num1_str);
				double num2 = Double.parseDouble(num2_str);
				tf.setText(num1 * num2 + "");
			} else if(operator.equals("/")) {
				double num1 = Double.parseDouble(num1_str);
				double num2 = Double.parseDouble(num2_str);
				tf.setText(num1 / num2 + "");
			} 
		} else if(".".equals(com)) {
			String temp = tf.getText();
			if(temp.indexOf(".") == -1) {
				tf.setText(temp + com);
				append = true;
			}
			
		}
	}

}
