package com.hblg.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.hblg.common.PublicUser;
import com.hblg.common.Tools;
import com.hblg.dao.UserDAO;
import com.hblg.entity.User;

public class LoginFrame extends JFrame {
	
	MyPanel mp = new MyPanel();
	JPanel panelDown = new JPanel();
	Image img;
	
	JLabel lblUserName = new JLabel("用户名");
	JTextField tfUserName = new JTextField(10);
	JLabel lblUserPwd = new JLabel("密码");
	JPasswordField tfUserPwd = new JPasswordField();
	
	JButton butLogin = new JButton();
	Icon icon;
	
	JLabel lblSignName = new JLabel();
	JLabel lblSignPwd = new JLabel();
	
	String userName = "";
	String userPwd = "";
	
	public LoginFrame() {
		this.initPanel();
		this.setTitle("系统登录");
		this.setIconImage(Tools.img);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initPanel() {
		try {
			img = ImageIO.read(ClassLoader.getSystemResource("images/login.jpg"));
			icon = new ImageIcon(getClass().getResource("/images/but.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		mp.drawImage(img);
		this.setLayout(null);
		this.add(mp);
		mp.setBounds(0, 0, 500, 160);
		this.add(panelDown);
		panelDown.setLayout(null);
		panelDown.setBounds(0, 160, 500, 210);
		
		lblUserName.setBounds(110, 40, 50, 20);
		panelDown.add(lblUserName);
		
		tfUserName.setBounds(190, 40, 160, 20);
		panelDown.add(tfUserName);
		
		lblSignName.setBounds(360, 40, 120, 20);
		panelDown.add(lblSignName);
		
		lblUserPwd.setBounds(110, 90, 50, 20);
		panelDown.add(lblUserPwd);
		
		tfUserPwd.setBounds(190, 90, 160, 20);
		panelDown.add(tfUserPwd);
		
		lblSignPwd.setBounds(360, 90, 120, 20);
		panelDown.add(lblSignPwd);
		
		butLogin.setBounds(175, 140, 170, 29);
		butLogin.setIcon(icon);
		panelDown.add(butLogin);
		
		butLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				butLoginActionPerformed(e);
			}
		});
		tfUserName.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblSignName.setText("");
				lblSignPwd.setText("");
			}
		});
		tfUserPwd.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				lblSignName.setText("");
				lblSignPwd.setText("");
			}
		});
		tfUserPwd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfUserPwdActionPerformed(e);
			}
		});
	}
	
	protected void tfUserPwdActionPerformed(ActionEvent e) {
		this.login();
	}

	protected void butLoginActionPerformed(ActionEvent e) {
		this.login();
	}
	
	private void login() {
		if(!this.check()) {
			return;
		} else {
			UserDAO userDAO = new UserDAO();
			// 数据库链接出问题
			if(userDAO.errorMsg == 1) {
				JOptionPane.showMessageDialog(this, "数据库链接有问题！");
				return;
			}
			List<User> list = userDAO.getAllUserInfo();
			boolean flag = false;
			for(int i=0; i<list.size(); i++) {
				User user = list.get(i);
				String name = user.getUserName();
				if(userName.equals(name)) {
					flag = true;  //用户名存在
				}
			}
			if(!flag) {
				JOptionPane.showMessageDialog(this, "用户不存在！");
				return;
			} else {
				for(int i=0; i<list.size(); i++) {
					User user = list.get(i);
					String name = user.getUserName();
					String pwd = user.getUserPwd();
					if(userName.equals(name) && userPwd.equals(pwd)) {
						PublicUser.setUserName(user.getUserName());
						PublicUser.setUserPwd(user.getUserPwd());
						PublicUser.setUserPower(user.getUserPower());
						System.out.println(user.getUserPower());
						// 登录成功
						new MainFrame();
						this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(this, "密码不对！");
			}
		}
	}

	private boolean check() {
		if(!this.checkUserName()) {
			lblSignName.setText("用户名不能为空！");
			return false;
		} else if(!this.checkUserPwd()) {
			lblSignPwd.setText("密码不能为空！");
			return false;
		}
		return true;
	}
	
	private boolean checkUserName() {
		userName = tfUserName.getText().trim();
		if(userName.equals("")) {
			return false;
		}
		return true;
	}
	
	private boolean checkUserPwd() {
		userPwd = new String(tfUserPwd.getPassword()).trim();
		if(userPwd.equals("")) {
			return false;
		}
		return true;
	}
}

class MyPanel extends JPanel {
	Image img;
	public void drawImage(Image img) {
		this.img = img;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (img != null) {
			g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
		}
	}
	
}



