import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	//定义窗体的大小
	public static final int WIN_WIDTH = 800;
	public static final int WIN_HEIGHT = 600;
	
	//定义小球的位置
	int x = 50, y = 50;
	
	//定义小球的大小
	int ball_width = 30, ball_height = 30;
	
	//定义放随机产生的小球的容器List
	List<Ball> list = new ArrayList<Ball>();
	
	//定义临时存放小球颜色的变量
	Color col = Color.blue;
	
	//定义计数器
	int count = 0;
	
	Image offScreenImage = null;
	
	public MainFrame() {
		
		//产生小球儿
		for(int i=0; i<10; i++) {
			list.add(new Ball(this));
		}
		
		this.getContentPane().setBackground(Color.black);
		this.addMouseMotionListener(new MouseMotionMonitor(this));
		this.setSize(WIN_WIDTH, WIN_HEIGHT);
		//this.setTitle("吃东西的小球儿");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		new PaintThread().start();
		
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setTitle("吃东西的小球儿     " + count);
		Color c = g.getColor();
		g.setColor(col);
		g.fillOval(x-(ball_width/2), y-(ball_height/2), ball_width, ball_height);
		g.setColor(Color.black);
		g.drawString(count+"", x, y);
		g.setColor(c);
		//画出小球儿，并判断是不是与大球相撞，如果相撞把它则从list中去除
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
