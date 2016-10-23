import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class TestNextDay extends JFrame implements ActionListener {

	TextField t1 = new TextField(10);
	
	TextField t2 = new TextField(10);
	
	public TestNextDay() {
		this.setLayout(new GridLayout(2, 1));
		this.add(t1);
		this.add(t2);
		t1.addActionListener(this);
		this.setSize(300, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = t1.getText();
		String[] s = str.split("-");
		int[] date = new int[s.length];
		for(int i=0; i<date.length; i++) {
			date[i] = Integer.parseInt(s[i]);
		}
		if(((date[0]%4==0)&&(date[0]%100!=0)) || (date[0]%400==0)) {
			//t2.setText(date[0] + "是闰年");
			if((date[1]==1|date[1]==3|date[1]==4|date[1]==5|date[1]==6|date[1]==7|date[1]==8|date[1]==9|date[1]==10|date[1]==11) && (date[2]==31)) {
				date[1] = date[1] + 1;
				date[2] = 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if(date[1]==12 && date[2]==31) {
				date[0] = date[0] + 1;
				date[1] = 1;
				date[2] = 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if((date[1]==1|date[1]==3|date[1]==4|date[1]==5|date[1]==6|date[1]==7|date[1]==8|date[1]==9|date[1]==10|date[1]==11|date[1]==12) && (date[2]!=31)) {
				date[2] = date[2] + 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if(date[1]==2 && date[2]==29) {
				date[1] = date[1] + 1;
				date[2] = 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if(date[1]==2 && date[2]!=29) {
				date[2] = date[2] + 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			}
		} else {
			//t2.setText(date[0] + "是平年");
			if((date[1]==1|date[1]==3|date[1]==4|date[1]==5|date[1]==6|date[1]==7|date[1]==8|date[1]==9|date[1]==10|date[1]==11) && (date[2]==31)) {
				date[1] = date[1] + 1;
				date[2] = 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if(date[1]==12 && date[2]==31) {
				date[0] = date[0] + 1;
				date[1] = 1;
				date[2] = 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if((date[1]==1|date[1]==3|date[1]==4|date[1]==5|date[1]==6|date[1]==7|date[1]==8|date[1]==9|date[1]==10|date[1]==11|date[1]==12) && (date[2]!=31)) {
				date[2] = date[2] + 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if(date[1]==2 && date[2]==28) {
				date[0] = date[0] + 1;
				date[1] = 1;
				date[2] = 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			} else if(date[0]==2 && date[2]!=28) {
				date[2] = date[2] + 1;
				t2.setText(date[0] + "-"  + date[1] + "-" + date[2]);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestNextDay();
	}


}
