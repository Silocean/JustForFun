import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TestCaiQuan extends JFrame implements ActionListener{
	
	JLabel l1 = new JLabel("����һ�����֣�0-10��");
	JLabel l2 = new JLabel("׼���ò¸�������");
	JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
	JTextField tf = new JTextField(10);
	
	int num = (int)(Math.random()*10);
	
	int countNum = 0;
	
	public TestCaiQuan() {
		this.setLayout(new GridLayout(3, 1));
		this.add(p1);
		p1.add(l1);
		this.add(p1);
		this.add(p2);
		p2.add(tf);
		this.add(p2);
		this.add(p3);
		p3.add(l2);
		this.add(p3);
		tf.addActionListener(this);
		this.setSize(400,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		//System.out.println(num);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestCaiQuan();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		int number = Integer.parseInt(tf.getText());
		if(number < num) {
			countNum ++;
			l2.setText("��С�˰���(*^__^*) ��������");
		} else if(number > num) {
			countNum ++;
			l2.setText("�´���Ŷ���ٺ�,������������!!!");
		} else {
			countNum ++;
			l2.setText("����Ŷ����¶���!  " + "��һ������" + countNum + "��");
		}
	}

}
