package com.hblg.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.hblg.common.PublicUser;
import com.hblg.common.Tools;

public class MainFrame extends JFrame {
	
	JMenuBar menuBar;
	JMenu menuSysMgr;
		JMenuItem menuItemUserMgr;
		JMenuItem menuItemPwdAlter;
		JMenuItem menuItemReLogIn;
		JMenuItem menuItemExit;
		
	JMenu menuDormMgr;
		JMenuItem menuItemHouMgr;
		JMenuItem menuItemDormitoryMgr;
		JMenuItem menuItemAddEmp;
		
	JMenu menuStuInfoInsert;
		JMenuItem menuItemStuInfoInsert;
		
	JMenu menuLogin;
		JMenuItem menuItemGoodsLogin;
		JMenuItem menuItemVisitLogin;
	
	JMenu menuInfoQuery;
		JMenuItem menuItemStuInfoQuery;
		JMenuItem menuItemEmpInfoQuery;
		JMenu menuLoginInfoQuery;
			JMenuItem menuItemGoodsLoginInfoQuery;
			JMenuItem menuItemVisitLoginInfoQuery;
		JMenuItem menuItemHouInfoQuery;
		JMenuItem menuItemDormitoryInfoQuery;
		
	JMenu menuAbout;
		JMenuItem menuItemAbout;
		
	JLabel imgLabel;
	Icon img;
	
	JLabel timeLabel;
	
	public MainFrame() {
		this.initMenu();
		this.initOthers();
		this.judgeUserPower();
	}
	
	/*
	 * �����û�Ȩ�ް���Ӧ�ؼ���Ϊ���ɱ༭
	 */
	private void judgeUserPower() {
		int userPower = PublicUser.getUserPower();
		if(userPower == 1) {
			this.menuItemUserMgr.setEnabled(false);
			this.menuItemHouMgr.setEnabled(false);
			this.menuItemDormitoryMgr.setEnabled(false);
			this.menuItemAddEmp.setEnabled(false);
			this.menuItemStuInfoInsert.setEnabled(false);
			this.menuItemGoodsLogin.setEnabled(false);
			this.menuItemVisitLogin.setEnabled(false);
		}
	}

	private void initMenu() {
		menuBar = new JMenuBar();
		this.initSysMgrMenu();
		this.initDormMgrMenu();
		this.initStuInfoMenu();
		this.initLoginMenu();
		this.initInfoQueryMenu();
		this.initAboutMenu();
		this.setJMenuBar(menuBar);
	}
	
	private void initAboutMenu() {
		menuAbout = new JMenu("����");
		menuItemAbout = new JMenuItem("����");
		menuAbout.add(menuItemAbout);
		menuBar.add(menuAbout);
		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemAboutActionPerformed(e);
			}
		});
	}
	
	protected void menuItemAboutActionPerformed(ActionEvent e) {
		this.showAboutDialog();
	}

	private void showAboutDialog() {
		JOptionPane.showMessageDialog(
				this,
				"�������ϵͳ",
				"^(oo)^",
				JOptionPane.INFORMATION_MESSAGE,
				new ImageIcon(Toolkit.getDefaultToolkit().getImage(
						MainFrame.class.getClassLoader().getResource(
								"images/0.gif"))));
	}

	private void initStuInfoMenu() {
		menuStuInfoInsert = new JMenu("������ס");
		menuItemStuInfoInsert = new JMenuItem("����ѧ����Ϣ");
		menuStuInfoInsert.add(menuItemStuInfoInsert);
		menuStuInfoInsert.add(menuItemStuInfoInsert);
		menuBar.add(menuStuInfoInsert);
		menuItemStuInfoInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemStuInfoInsertActionPerformed(e);
			}
		});
	}

	protected void menuItemStuInfoInsertActionPerformed(ActionEvent e) {
		new InsertStudentInfoFrame();
	}

	private void initLoginMenu() {
		menuLogin = new JMenu("����Ǽ�");
		menuItemGoodsLogin = new JMenuItem("��Ʒ����Ǽ�");
		menuItemVisitLogin = new JMenuItem("��Ա���õǼ�");
		menuLogin.add(menuItemGoodsLogin);
		menuLogin.add(menuItemVisitLogin);
		menuBar.add(menuLogin);
		menuItemGoodsLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuItemGoodsLoginActionPerformed(e);
			}
		});
		menuItemVisitLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				menuItemVisitLoginActionPerformed(e);
			}
		});
	}

	protected void menuItemVisitLoginActionPerformed(ActionEvent e) {
		new InsertVisitInfoFrame();
	}

	protected void menuItemGoodsLoginActionPerformed(ActionEvent e) {
		new InsertGoodsMoveInfoFrame();
	}

	private void initInfoQueryMenu() {
		menuInfoQuery = new JMenu("��Ϣ��ѯ");
		menuItemStuInfoQuery = new JMenuItem("ѧ����Ϣ��ѯ");
		menuItemEmpInfoQuery = new JMenuItem("Ա����Ϣ��ѯ");
		menuLoginInfoQuery = new JMenu("�Ǽ���Ϣ��ѯ");
		menuItemGoodsLoginInfoQuery = new JMenuItem("��Ʒ�Ǽ���Ϣ��ѯ");
		menuItemVisitLoginInfoQuery = new JMenuItem("��Ա�Ǽ���Ϣ��ѯ");
		menuItemHouInfoQuery = new JMenuItem("¥����Ϣ��ѯ");
		menuItemDormitoryInfoQuery = new JMenuItem("������Ϣ��ѯ");
		menuInfoQuery.add(menuItemStuInfoQuery);
		menuInfoQuery.add(menuItemEmpInfoQuery);
		menuInfoQuery.add(menuLoginInfoQuery);
		menuLoginInfoQuery.add(menuItemGoodsLoginInfoQuery);
		menuLoginInfoQuery.add(menuItemVisitLoginInfoQuery);
		menuInfoQuery.add(menuItemHouInfoQuery);
		menuInfoQuery.add(menuItemDormitoryInfoQuery);
		menuBar.add(menuInfoQuery);
		menuItemDormitoryInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemDormitoryInfoQueryActionPerformed(e);
			}
		});
		menuItemHouInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemDormInfoQueryActionPerformed(e);
			}
		});
		menuItemEmpInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemEmpInfoQueryActionPerformed(e);
			}
		});
		menuItemGoodsLoginInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemGoodsLoginInfoQueryActionPerformed(e);
			}
		});
		menuItemVisitLoginInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemVisitLoginInfoQueryActionPerformed(e);
			}
		});
		menuItemStuInfoQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuStuInfoQueryActionPerformed(e);
			}
		});
	}

	protected void menuItemVisitLoginInfoQueryActionPerformed(ActionEvent e) {
		new VisitLoginInfoQueryFrame();
	}

	protected void menuItemGoodsLoginInfoQueryActionPerformed(ActionEvent e) {
		new GoodsLoginInfoQueryFrame();
	}

	protected void menuStuInfoQueryActionPerformed(ActionEvent e) {
		new StudentInfoQueryFrame();
	}

	protected void menuItemEmpInfoQueryActionPerformed(ActionEvent e) {
		new EmployeeInfoQueryFrame();
	}

	protected void menuItemDormInfoQueryActionPerformed(ActionEvent e) {
		new HouInfoQueryFrame();
	}

	protected void menuItemDormitoryInfoQueryActionPerformed(ActionEvent e) {
		new DormitoryInfoQueryFrame();
	}

	private void initDormMgrMenu() {
		menuDormMgr = new JMenu("��Ԣ����");
		menuItemHouMgr = new JMenuItem("¥������");
		menuItemDormitoryMgr = new JMenuItem("���ҹ���");
		menuItemAddEmp = new JMenuItem("���Ա��");
		menuDormMgr.add(menuItemHouMgr);
		menuDormMgr.add(menuItemDormitoryMgr);
		menuDormMgr.add(menuItemAddEmp);
		menuBar.add(menuDormMgr);
		menuItemHouMgr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemHouMgrActionPerformed(e);
			}
		});
		menuItemDormitoryMgr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemDormitoryMgrActionPerformed(e);
			}
		});
		menuItemAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemAddEmpActionPerformed(e);
			}
		});
	}
	
	protected void menuItemAddEmpActionPerformed(ActionEvent e) {
		new InsertEmployeeInfoFrame();
	}

	protected void menuItemDormitoryMgrActionPerformed(ActionEvent e) {
		new InsertDormitoryInfoFrame();
	}

	protected void menuItemHouMgrActionPerformed(ActionEvent e) {
		new InsertHouInfoFrame();
	}

	private void initSysMgrMenu() {
		menuSysMgr = new JMenu("ϵͳ����");
		menuItemUserMgr = new JMenuItem("�û�����");
		menuItemPwdAlter = new JMenuItem("�û���Ϣ�޸�");
		menuItemReLogIn = new JMenuItem("���µ�¼");
		menuItemExit = new JMenuItem("�˳�ϵͳ");
		menuSysMgr.add(menuItemUserMgr);
		menuSysMgr.add(menuItemPwdAlter);
		menuSysMgr.add(menuItemReLogIn);
		menuSysMgr.addSeparator();
		menuSysMgr.add(menuItemExit);
		menuBar.add(menuSysMgr);
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemExitActionPerformed(e);
			}
		});
		menuItemUserMgr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemUserMgrActionPerformed(e);
			}
		});
		menuItemReLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemReLogInActionPerformed(e);
			}
		});
		menuItemPwdAlter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuItemPwdAlterActionListener(e);
			}
		});
	}

	protected void menuItemReLogInActionPerformed(ActionEvent e) {
		this.setVisible(false);
		new LoginFrame();
	}

	protected void menuItemPwdAlterActionListener(ActionEvent e) {
		new UserInfoQueryFrame();
	}

	protected void menuItemUserMgrActionPerformed(ActionEvent e) {
		new UserManageFrame();
	}

	protected void menuItemExitActionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	private void initOthers() {
		imgLabel = new JLabel();
		img = new ImageIcon("images/background.jpg");
		imgLabel.setIcon(img);
		timeLabel = new JLabel("", JLabel.RIGHT);
		this.add(imgLabel, BorderLayout.CENTER);
		this.add(timeLabel, BorderLayout.SOUTH);
		this.setTitle("�������������ϵͳ");
		this.setIconImage(Tools.img);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		new Thread(new ShowTime()).start();
	}
	
	class ShowTime implements Runnable {

		public void run() {
			while(true) {
				Date date = new Date();
				String time = Tools.convertToString(date);
				timeLabel.setText(time+"  ");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
