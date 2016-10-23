import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	//���崰��Ĵ�С
	public static final int WIN_WIDTH = 800;
	public static final int WIN_HEIGHT = 600;
	
	//����С���λ��
	int x = 50, y = 50;
	
	//����С��Ĵ�С
	int ball_width = 30, ball_height = 30;
	
	//��������������С�������List
	List<Ball> list = new ArrayList<Ball>();
	
	//������ʱ���С����ɫ�ı���
	Color col = Color.blue;
	
	//���������
	int count = 0;
	
	Image offScreenImage = null;
	
	public MainFrame() {
		
		//����С���
		for(int i=0; i<10; i++) {
			list.add(new Ball(this));
		}
		
		this.getContentPane().setBackground(Color.black);
		this.addMouseMotionListener(new MouseMotionMonitor(this));
		this.setSize(WIN_WIDTH, WIN_HEIGHT);
		//this.setTitle("�Զ�����С���");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new PaintThread().start();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setTitle("�Զ�����С���     " + count);
		Color c = g.getColor();
		g.setColor(col);
		g.fillOval(x-(ball_width/2), y-(ball_height/2), ball_width, ball_height);
		g.setColor(Color.black);
		g.drawString(count+"", x, y);
		g.setColor(c);
		//����С��������ж��ǲ����������ײ�������ײ�������list��ȥ��
		for(int i=0; i<list.size(); i++) {
			Ball ball = list.get(i);
			ball.draw(g);
			if(ball.collideWithBall()) {
				count ++;
				ball_width += 1;
				ball_height += 1;
				col = ball.col;
				list.remove(ball);
				System.out.println(list.size());
				list.add(new Ball(this));
			}
		}
		if(ball_width>80 && ball_height>80) {
			ball_width = 50;
			ball_height = 50;
		}
		
	}
	
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(WIN_WIDTH, WIN_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.black);
		gOffScreen.fillRect(0, 0, 800, 600);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	class PaintThread extends Thread {
		
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public Rectangle getRect(){
		return new Rectangle(x-(ball_width/2), y-(ball_height/2), ball_width, ball_height);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainFrame();
	}

}
