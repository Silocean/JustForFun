import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Minishutoff extends JFrame implements ActionListener {
	
	int hour = 0, minute = 0;
	String info = null;
	long second = 0L;
	
	JPanel pTop = new JPanel();
	JLabel imageLabel = new JLabel();
	JTextField txHour = new JTextField(5);
	JTextField txMinute = new JTextField(5);
	JLabel lHour = new JLabel("小时");
	JLabel lMinute = new JLabel("分钟后执行");
	
	JPanel pCenter = new JPanel();
	JPanel pCenterLeft = new JPanel();
	CountdownPane pCenterRight = new CountdownPane(this);
	JRadioButton rbShutdown = new JRadioButton("关机");
	JRadioButton rbRestart = new JRadioButton("重启");
	JRadioButton rbLogout = new JRadioButton("注销");
	
	JPanel pBottom = new JPanel();
	JButton bSure = new JButton("确定计划");
	JButton bCancel = new JButton("取消");
	
	ButtonGroup bg = new ButtonGroup();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public Minishutoff() {
		Icon imageClock = new ImageIcon(Minishutoff.class.getResource("images/clock.jpg"));
		imageLabel.setIcon(imageClock);
		try {
			this.setContentPane(new ImagePanel(ImageIO.read(ClassLoader.getSystemResource("images/bg.jpg"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setLayout(new BorderLayout());
		this.add(pTop, BorderLayout.NORTH);
		String dateStr = sdf.format(new Date());
		pTop.setBorder(BorderFactory.createTitledBorder("实际时间  " + dateStr));
		pTop.add(imageLabel);
		pTop.add(txHour);
		pTop.add(lHour);
		pTop.add(txMinute);
		pTop.add(lMinute);
		
		this.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(1, 2));
		pCenter.add(pCenterLeft);
		pCenterLeft.setLayout(new GridLayout(3, 1));
		pCenterLeft.add(rbShutdown);
		pCenterLeft.add(rbRestart);
		pCenterLeft.add(rbLogout);
		bg.add(rbShutdown);
		bg.add(rbRestart);
		bg.add(rbLogout);
		rbShutdown.addActionListener(this);
		rbRestart.addActionListener(this);
		rbLogout.addActionListener(this);
		
		this.add(pBottom, BorderLayout.SOUTH);
		pBottom.add(bSure);
		pBottom.add(bCancel);
		bSure.addActionListener(this);
		bCancel.addActionListener(this);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(Minishutoff.class.getResource("images/icon.png")));
		this.setSize(400, 300);
		this.setTitle("定时关机");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		new Minishutoff();
	}
	
	public boolean confirmInfo() {
		if(!txHour.getText().equals("")&&!txMinute.getText().equals("")) {
			try {
				hour = Integer.parseInt(txHour.getText());
				minute = Integer.parseInt(txMinute.getText());
				if(hour>24 || hour<0 || minute >60 || minute<0) {
					return false;
				} else {
					return true;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		} 
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == rbShutdown) {
			info = "shutdown";
		} else if(e.getSource() == rbRestart) {
			info = "restart";
		} else if(e.getSource() == rbLogout) {
			info = "logout";
		}
		if(e.getSource() == bSure) {
			if(confirmInfo()) {
				second = hour*60*60 + minute*60;
				if(info == null) {
					JOptionPane.showMessageDialog(this, "请选择你想要执行的操作");
				} else {
					if(info.equals("shutdown")) {
						if(JOptionPane.showConfirmDialog(this, "确定执行此操作么") == JOptionPane.OK_OPTION) {
							try {
								Runtime.getRuntime().exec("shutdown -s -t " + second);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							pCenter.add(pCenterRight);
							this.setVisible(true);
							JOptionPane.showMessageDialog(this, "系统将在" + hour + "小时" + minute + "分后关闭");
						}
					} else if(info.equals("restart")) {
						if(JOptionPane.showConfirmDialog(this, "确定执行此操作么") == JOptionPane.OK_OPTION) {
							try {
								Runtime.getRuntime().exec("shutdown -r -t " + second);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							pCenter.add(pCenterRight);
							this.setVisible(true);
							JOptionPane.showMessageDialog(this, "系统将在" + hour + "小时" + minute + "分后重启");
						}
					} else if(info.equals("logout")) {
						if(JOptionPane.showConfirmDialog(this, "确定执行此操作么") == JOptionPane.OK_OPTION) {
							try {
								Runtime.getRuntime().exec("shutdown -l");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(this, "系统正在注销……");
						}
					}
				}
			} else {
				JOptionPane.showMessageDialog(this, "输入格式有误！" + "\n" + "小时：0—12       分：0—60");
			}
		}
		if(e.getSource() == bCancel) {
			System.exit(0);
		}
	}


}
