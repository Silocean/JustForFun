import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.JFrame;

public class DateDistance extends JFrame implements ActionListener{
	
	TextField t1 = new TextField(10);
	
	TextField t2 = new TextField(10);
	
	
	public DateDistance() {
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
		Calendar c = Calendar.getInstance();
		String[] s1 = {t1.getText().substring(0, 4), t1.getText().substring(4, 6), t1.getText().substring(6, 8)};
		int[] date1 = new int[3];
		for(int i=0; i<date1.length; i++) {
			date1[i] = Integer.parseInt(s1[i]);
		}
		c.set(date1[0], date1[1]-1, date1[2]);
		long time1 = c.getTimeInMillis();
		
		String[] s2 = {t1.getText().substring(8, 12), t1.getText().substring(12, 14), t1.getText().substring(14, 16)};
		int[] date2 = new int[3];
		for(int i=0; i<date2.length; i++) {
			date2[i] = Integer.parseInt(s2[i]);
		}
		c.set(date2[0], date2[1]-1, date2[2]);
		long time2 = c.getTimeInMillis();
		
		long days = 0;
		
		if(time2>time1) {
			days = (time2-time1)/(24*60*60*1000);
		} else {
			days = (time1-time2)/(24*60*60*1000);
		}
		
		t2.setText("¼ä¸ô" + days + "Ìì");
		
		/*System.out.println(time1);
		System.out.println(time2);*/
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DateDistance();
	}

}
