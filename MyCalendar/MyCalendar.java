import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MyCalendar extends JFrame implements ItemListener, ActionListener {
	
	JTabbedPane tp = new JTabbedPane();
	
	JPanel tp1 = new JPanel(); 
	JPanel tp2 = new JPanel();
	JPanel pNorth = new JPanel();
	JPanel pCenter = new JPanel();
	JPanel pCenterNorth = new JPanel();
	JPanel pCenterCenter = new JPanel();
	JLabel yearLabel = new JLabel("年份");
	JLabel monthLabel = new JLabel("月份");
	Choice cYear = new Choice();
	Choice cMonth = new Choice();
	JButton[] butTitle = {new JButton("日"), new JButton("一"), new JButton("二"), new JButton("三"), new JButton("四"), new JButton("五"), new JButton("六")};
	JButton[][] but = new JButton[6][7];
	
	JLabel l1, l2, l3;
	JTextField tx1, tx2, tx3;
	JButton b;
	JPanel p1, p2, p3;
	
	Calendar c = Calendar.getInstance();
	
	public MyCalendar() {
		this.initFrame();
	}
	
	public void initFrame() {
		tp.add("万年历", tp1);
		tp.add("时间距离", tp2);
		for(int i=1900; i<=2100; i++) {
			cYear.add(i+"");
		}
		cYear.select(c.get(Calendar.YEAR)+"");
		for(int i=1; i<=12; i++) {
			cMonth.add(i+"");
		}
		cMonth.select(""+(c.get(Calendar.MONTH)+1));
		cYear.addItemListener(this);
		cMonth.addItemListener(this);
		pNorth.add(yearLabel);
		pNorth.add(cYear);
		pNorth.add(monthLabel);
		pNorth.add(cMonth);
		pCenter.setLayout(new BorderLayout());
		pCenterNorth.setLayout(new GridLayout(1, 7));
		pCenterCenter.setLayout(new GridLayout(6, 7));
		pCenter.add(pCenterNorth, BorderLayout.NORTH);
		pCenter.add(pCenterCenter, BorderLayout.CENTER);
		for(int i=0; i<butTitle.length; i++) {
			pCenterNorth.add(butTitle[i]);
		}
		for(int i=0; i<but.length; i++) {
			for (int j = 0; j < but[i].length; j++) {
				but[i][j] = new JButton();
				pCenterCenter.add(but[i][j]);
			}
		}
		tp1.setLayout(new BorderLayout());
		tp1.add(pNorth, BorderLayout.NORTH);
		tp1.add(pCenter, BorderLayout.CENTER);
		this.add(tp);
		
		
		l1 = new JLabel("起始日期");
		l2 = new JLabel("截止日期");
		l3 = new JLabel("间隔天数");
		tx1 = new JTextField(10);
		tx2 = new JTextField(10);
		tx3 = new JTextField(10);
		b = new JButton("go");
		b.addActionListener(this);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p1.add(l1);
		p1.add(tx1);
		p2.add(l2);
		p2.add(tx2);
		p3.add(l3);
		p3.add(tx3);
		tp2.add(p1);
		tp2.add(p2);
		tp2.add(p3);
		tp2.add(b);
		tp2.setLayout(new GridLayout(4, 1));
		
		
		this.setSize(400, 300);
		this.setTitle("日历");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(MyCalendar.class.getClassLoader().getResource("icon.png")));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pCenter.requestFocus();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new MyCalendar();
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		int year = Integer.parseInt(cYear.getSelectedItem());
		int month = Integer.parseInt((cMonth.getSelectedItem()));
		int today = c.get(Calendar.DAY_OF_MONTH);
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		int offset = 0 - c.get(Calendar.DAY_OF_WEEK) + 2;
		//在显示下月日期之前，清空按钮上的数字
		for(int i=0; i<but.length; i++) {
			for (int j = 0; j < but[i].length; j++) {
				but[i][j].setText("");
			}
		}
		for(int i=0; i<but.length; i++) {
			for (int j = 0; j < but[i].length; j++) {
				if(offset>0 && offset<=getMaxDays(year, month)) {
					if(offset == today) {
						but[i][j].setText(""+offset + "*");
					} else {
						but[i][j].setText(""+offset);
					}
				}
				offset ++;
			}
		}
	}

	private int getMaxDays(int year, int month) {
		int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if((year%4==0 && year%100!=0) || year%400==0) {
			days[1] ++;
		}
		return days[month-1];
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long timeFrom = 0;
		long timeTo = 0;
		try {
			if(tx1.getText() != null && tx2.getText() != null) {
				String[] strFrom = tx1.getText().split("\\-");
				int[] date1 = new int[strFrom.length];
				for(int i=0; i<strFrom.length; i++) {
					date1[i] = Integer.parseInt(strFrom[i]);
				}
				c.set(date1[0], date1[1]-1, date1[2]);
				timeFrom = c.getTimeInMillis();
				
				String[] strTo = tx2.getText().split("\\-");
				int[] date2 = new int[strTo.length];
				for(int i=0; i<strTo.length; i++) {
					date2[i] = Integer.parseInt(strTo[i]);
				}
				c.set(date2[0], date2[1]-1, date2[2]);
				timeTo = c.getTimeInMillis();
				
				long apartDays = (timeTo - timeFrom) / (24*60*60*1000);
				tx3.setText(apartDays + "天");
			}
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(this, "输入的日期格式不正确" + "\n" + "格式：yyyy-MM-dd");
		}
	}

}
