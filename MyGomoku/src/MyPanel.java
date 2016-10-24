import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyPanel extends JPanel implements MouseListener, ActionListener {

	Image bgImg = null;
	Image blackImg = null;
	Image whiteImg = null;

	MyButton startBut = new MyButton("开始");
	MyButton regretBut = new MyButton("悔棋");
	MyButton giveUpBut = new MyButton("认输");
	MyButton setBut = new MyButton("设置");
	MyButton exitBut = new MyButton("退出");
	MyButton aboutBut = new MyButton("关于");
	// 保存鼠标点击位置的坐标
	int x, y;
	// 用二维数组标示各个下棋点，0代表空位，1代表黑棋，2代表白棋
	int[][] chessPoint = new int[19][19];
	// 用于保存所下棋子记录
	Stack<Point> chessStack = new Stack<Point>();
	// 是否黑方下棋
	boolean isBlack = true;
	// 游戏是否可玩
	boolean canPlay = false;
	// 黑方游戏时间
	int blackTimeLeft = 0;
	// 白方游戏时间
	int whiteTimeLeft = 0;
	// 输入的时间
	int time = 0;
	// 黑方游戏时间，显示在面板上
	String blackStringTime = "无限制";
	// 黑方游戏时间，显示在面板上
	String whiteStringTime = "无限制";
	// 时间线程
	Thread t = null;

	Toolkit tk = Toolkit.getDefaultToolkit();

	// 是否重新开始

	@SuppressWarnings("deprecation")
	public MyPanel() {
		/*
		 * bgImg = ImageIO.read(new File(System.getProperty("user.dir") +
		 * "/bin/" + "bg.png")); blackImg = ImageIO.read(new
		 * File(System.getProperty("user.dir") + "/bin/" + "black.png"));
		 * whiteImg = ImageIO.read(new File(System.getProperty("user.dir") +
		 * "/bin/" + "white.png"));
		 */
		bgImg = tk.getImage(MyPanel.class.getClassLoader()
				.getResource("bg.png"));
		blackImg = tk.getImage(MyPanel.class.getClassLoader().getResource(
				"black.png"));
		whiteImg = tk.getImage(MyPanel.class.getClassLoader().getResource(
				"white.png"));
		for (int i = 0; i < chessPoint.length; i++) {
			for (int j = 0; j < chessPoint[i].length; j++) {
				chessPoint[i][j] = 0;
			}
		}
		this.setLayout(null);
		startBut.setBounds(20 + 21 * 20, 20, 4 * 20, 2 * 20);
		regretBut.setBounds(20 + 21 * 20, 20 + 4 * 20, 4 * 20, 2 * 20);
		giveUpBut.setBounds(20 + 21 * 20, 20 + 8 * 20, 4 * 20, 2 * 20);
		setBut.setBounds(20 + 21 * 20, 20 + 12 * 20, 4 * 20, 2 * 20);
		exitBut.setBounds(20 + 21 * 20, 20 + 16 * 20, 4 * 20, 2 * 20);
		aboutBut.setBounds(20 + 21 * 20, 20 + 19 * 20, 4 * 20, 2 * 20);
		this.add(startBut);
		this.add(regretBut);
		this.add(giveUpBut);
		this.add(setBut);
		this.add(exitBut);
		this.add(aboutBut);
		startBut.addActionListener(this);
		regretBut.addActionListener(this);
		giveUpBut.addActionListener(this);
		setBut.addActionListener(this);
		exitBut.addActionListener(this);
		aboutBut.addActionListener(this);
		this.addMouseListener(this);

		t = new Thread(new TimeCountThread());
		t.start();
		t.suspend();
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(bgImg, 0, 0, this.getWidth(), this.getHeight(), null);

		this.drawChessPanel(g);

		for (int i = 0; i < chessPoint.length; i++) {
			for (int j = 0; j < chessPoint[i].length; j++) {
				if (chessPoint[i][j] == 1) {
					g.drawImage(blackImg, i * 20 + 20 - 10, j * 20 + 20 - 10,
							null);
				}
				if (chessPoint[i][j] == 2) {
					g.drawImage(whiteImg, i * 20 + 20 - 10, j * 20 + 20 - 10,
							null);
				}
			}
		}

	}

	private void drawChessPanel(Graphics g) {
		g.setColor(Color.white);
		for (int i = 0; i <= 18; i++) {
			g.drawLine(20 + i * 20, 20, 20 + i * 20, 20 + 18 * 20);
			g.drawLine(20, 20 + i * 20, 20 + 18 * 20, 20 + i * 20);
		}
		g.fillOval(20 + 3 * 20 - 2, 20 + 3 * 20 - 2, 4, 4);
		g.fillOval(20 + 3 * 20 - 2, 20 + 15 * 20 - 2, 4, 4);
		g.fillOval(20 + 15 * 20 - 2, 20 + 15 * 20 - 2, 4, 4);
		g.fillOval(20 + 15 * 20 - 2, 20 + 3 * 20 - 2, 4, 4);
		g.fillOval(20 + 9 * 20 - 2, 20 + 9 * 20 - 2, 4, 4);

		g.setFont(new Font("华康少女文字W5(P)", Font.BOLD, 16));
		if (blackTimeLeft != 0 || whiteTimeLeft != 0) {
			int blackMinute = blackTimeLeft / 60;
			int blackSecond = blackTimeLeft - blackMinute * 60;
			blackStringTime = blackMinute + ":" + blackSecond;
			if (blackMinute < 10) {
				blackStringTime = "0" + blackMinute + ":" + blackSecond;
			}
			if (blackSecond < 10) {
				blackStringTime = blackMinute + ":" + "0" + blackSecond;
			}
			int whiteMinute = whiteTimeLeft / 60;
			int whiteSecond = whiteTimeLeft - whiteMinute * 60;
			whiteStringTime = whiteMinute + ":" + whiteSecond;
			if (whiteMinute < 10) {
				whiteStringTime = "0" + whiteMinute + ":" + whiteSecond;
			}
			if (whiteSecond < 10) {
				whiteStringTime = whiteMinute + ":" + "0" + whiteSecond;
			}
		}
		if (isBlack) {
			g.setColor(Color.black);
			g.drawRect(20, 20 + 18 * 20 + 20, 8 * 20, 2 * 20);
			g.drawString("黑方：" + blackStringTime, 20 + 10, 20 + 18 * 20 + 20
					+ 25);
			g.setColor(Color.white);
			g.drawRect(20 + 10 * 20, 20 + 18 * 20 + 20, 8 * 20, 2 * 20);
			g.drawString("白方：" + whiteStringTime, 20 + 10 * 20 + 10, 20 + 18
					* 20 + 20 + 25);
		} else {
			g.setColor(Color.white);
			g.drawRect(20, 20 + 18 * 20 + 20, 8 * 20, 2 * 20);
			g.drawString("黑方：" + blackStringTime, 20 + 10, 20 + 18 * 20 + 20
					+ 25);
			g.setColor(Color.black);
			g.drawRect(20 + 10 * 20, 20 + 18 * 20 + 20, 8 * 20, 2 * 20);
			g.drawString("白方：" + whiteStringTime, 20 + 10 * 20 + 10, 20 + 18
					* 20 + 20 + 25);
		}
	}

	/*
	 * 判定输赢的方法
	 */
	private boolean checkWin() {
		boolean flag = false;
		int color = chessPoint[x][y];

		int a1 = 1;
		int a2 = 1;
		int count1 = 1;
		while (x + a1 >= 0 && x + a1 <= 18 && chessPoint[x + a1][y] == color) {
			count1++;
			a1++;
		}
		while (x - a2 >= 0 && x - a2 <= 18 && chessPoint[x - a2][y] == color) {
			count1++;
			a2++;
		}
		if (count1 >= 5) {
			flag = true;
		}

		int b1 = 1;
		int b2 = 1;
		int count2 = 1;
		while (y + b1 >= 0 && y + b1 <= 18 && chessPoint[x][y + b1] == color) {
			count2++;
			b1++;
		}
		while (y - b2 >= 0 && y - b2 <= 18 && chessPoint[x][y - b2] == color) {
			count2++;
			b2++;
		}
		if (count2 >= 5) {
			flag = true;
		}

		int c1 = 1;
		int c2 = 1;
		int count3 = 1;
		while (x + c1 >= 0 && x + c1 <= 18 && y - c1 >= 0 && y - c1 <= 18
				&& chessPoint[x + c1][y - c1] == color) {
			count3++;
			c1++;
		}
		while (x - c2 >= 0 && x - c2 <= 18 && y + c2 >= 0 && y + c2 <= 18
				&& chessPoint[x - c2][y + c2] == color) {
			count3++;
			c2++;
		}
		if (count3 >= 5) {
			flag = true;
		}

		int d1 = 1;
		int d2 = 1;
		int count4 = 1;
		while (x + d1 >= 0 && x + d1 <= 18 && y + d1 >= 0 && y + d1 <= 18
				&& chessPoint[x + d1][y + d1] == color) {
			count4++;
			d1++;
		}
		while (x - d2 >= 0 && x - d2 <= 18 && y - d2 >= 0 && y - d2 <= 18
				&& chessPoint[x - d2][y - d2] == color) {
			count4++;
			d2++;
		}
		if (count4 >= 5) {
			flag = true;
		}

		return flag;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		if (canPlay) {
			if (x >= 20 && x <= 20 + 18 * 20 + 10 && y >= 20
					&& y <= 20 + 18 * 20 + 10) {
				x = (x - 20) / 20;
				y = (y - 20) / 20;
				chessStack.push(new Point(x, y));
				if (chessPoint[x][y] != 0) {
					JOptionPane.showMessageDialog(this, "这儿已经下过棋子了，亲！");
				} else {
					if (isBlack) {
						chessPoint[x][y] = 1;
						isBlack = false;
					} else {
						chessPoint[x][y] = 2;
						isBlack = true;
					}
					if (checkWin()) {
						JOptionPane.showMessageDialog(this,
								chessPoint[x][y] == 1 ? "黑方胜利" : "白方胜利");
						canPlay = false;
					}
				}
			}
		}

		System.out.println(x + " " + y);
		this.repaint();
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == startBut) {
			JOptionPane.showMessageDialog(this, "游戏开始");
			canPlay = true;
			for (int i = 0; i < chessPoint.length; i++) {
				for (int j = 0; j < chessPoint[i].length; j++) {
					chessPoint[i][j] = 0;
				}
			}
			this.repaint();
		} else if (e.getSource() == regretBut) {
			if (canPlay) {
				if (!chessStack.isEmpty()) {
					Point p = chessStack.pop();
					chessPoint[p.x][p.y] = 0;
					if (isBlack) {
						isBlack = false;
					} else {
						isBlack = true;
					}
					this.repaint();
				}
			}
		} else if (e.getSource() == giveUpBut) {
			if (canPlay) {
				canPlay = false;
				if (isBlack) {
					JOptionPane.showMessageDialog(this, "黑方认输");
				} else {
					JOptionPane.showMessageDialog(this, "白方认输");
				}
			}
		} else if (e.getSource() == setBut) {
			if (canPlay) {
				try {
					time = Integer.parseInt(JOptionPane.showInputDialog(this,
							"输入下棋时间（分钟）")) * 60;
					blackTimeLeft = time;
					whiteTimeLeft = time;
					t.resume();
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(this, "格式不对，重新输入");
				}
			}
		} else if (e.getSource() == exitBut) {
			System.exit(0);
		} else if (e.getSource() == aboutBut) {
			JOptionPane.showMessageDialog(
					this,
					"一个简单的单机版五子棋游戏" + "\n" + "by 你聼的到",
					"关于",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(FiveChess.class.getClassLoader().getResource(
							"0.gif")));
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * 计时线程
	 */
	private class TimeCountThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (canPlay) {
				while (true) {
					repaint();
					if (isBlack) {
						blackTimeLeft--;
						if (blackTimeLeft == 0) {
							JOptionPane.showMessageDialog(null, "黑方时间到，已输！");
							canPlay = false;
						}
					} else {
						whiteTimeLeft--;
						if (whiteTimeLeft == 0) {
							JOptionPane.showMessageDialog(null, "白方时间到，已输！");
							canPlay = false;
						}
					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

}
