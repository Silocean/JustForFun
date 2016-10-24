package com.hblg;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JDialog;


public class TankClient extends Frame {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	MenuBar mb = new MenuBar();
	Menu b1 = new Menu("游戏");
	Menu b2 = new Menu("帮助");
	Menu b3 = new Menu("关于");
	MenuItem miAbout = new MenuItem("^(oo)^");
	MenuItem miChect = new MenuItem("检查更新");
	
	private static int step = 1;
	
	int x = 100, y = 100;
	
	private static Random r = new Random();
	
	Tank myTank = new Tank(385, 550, true, Direction.STOP, this);
	
	Blood b= new Blood();
	
	Wall w1 = new Wall(250, 300, 10, 200, this);
	Wall w2 = new Wall(150, 200, 200, 10, this);
	Wall w3 = new Wall(455, 200, 200, 10, this);
	Wall w4 = new Wall(540, 300, 10, 200, this);
	Wall w5 = new Wall(375, 520, 50, 10, this);
	
	List<Missile> missiles = new ArrayList<Missile>();
	List<Explode> explodes = new ArrayList<Explode>();
	List<Tank> tanks = new ArrayList<Tank>();
	
	Image offScreenImage = null;
	
	public static void main(String[] args) {
		TankClient tc = new TankClient();
		tc.launch();
	}
	
	public void launch() {
		
		for(int i=0; i<10; i++) {
			tanks.add(new Tank(100 + 50*(i+1), 50, false, Direction.D, this));
		}
		
		b3.add(miAbout);
		b3.add(miChect);
		mb.add(b1);
		mb.add(b2);
		mb.add(b3);
		
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		setLocation((screenWidth - WINDOW_WIDTH)/ 2, (screenHeight - WINDOW_HEIGHT) / 2);
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setTitle("TankWar (by飞云)");
		setBackground(Color.black);
		setMenuBar(mb);
		setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		addKeyListener(new KeyMonitor());
		setVisible(true);
		
		new Thread(new paintThread()).start();
	}
	
	public void update(Graphics g) {
		if(offScreenImage == null) {
			offScreenImage = this.createImage(WINDOW_WIDTH, WINDOW_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c= gOffScreen.getColor();
		gOffScreen.setColor(Color.black);
		gOffScreen.fillRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	public void paint(Graphics g) {
		
		if(tanks.size() <= 0) {
			for(int i=0; i<10; i++) {
				tanks.add(new Tank(r.nextInt(799) + 1, r.nextInt(550) + 50, false, Direction.D, this));
			}
			step ++;
		}
		
		Color c = g.getColor();
		g.setColor(Color.white);
		
		g.drawString("子弹数量：" + missiles.size(), 10, 60);
		g.drawString("爆炸数量：" + explodes.size(), 10, 80);
		g.drawString("敌军坦克数量：" + tanks.size(), 10, 100);
		g.drawString("生命值：" + myTank.getLife(), 10, 120);
		g.drawString("第" + step + "关", 380, 60);
		if(step >= 5)
		g.drawString("成功突破第" + step + "关", 355, 80);
		
		myTank.draw(g);
		myTank.hitWall(w1);
		myTank.hitWall(w2);
		myTank.hitWall(w3);
		myTank.hitWall(w4);
		myTank.hitWall(w5);
		
		if(step == 3) {
			b.draw(g);
			myTank.eatBlood(b);
		}
		if(step == 5) {
			b.draw(g);
			myTank.eatBlood(b);
		}
		
		w1.draw(g);
		w2.draw(g);
		w3.draw(g);
		w4.draw(g);
		w5.draw(g);
		
		for(int i=0; i<tanks.size(); i++) {
			Tank t = tanks.get(i);
			t.hitWall(w1);
			t.hitWall(w2);
			t.hitWall(w3);
			t.hitWall(w4);
			t.hitWall(w5);
			t.collidesWithTank(tanks);
			
			t.draw(g);
		}
				
	
		for(int i=0; i<missiles.size(); i++) {
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.hitTank(myTank);
			m.hitWall(w1);
			m.hitWall(w2);
			m.hitWall(w3);
			m.hitWall(w4);
			m.hitWall(w5);
//			m.hitMissile(m);

			m.draw(g);
		}
		
		for(int i=0; i<explodes.size(); i++) {
			Explode e = explodes.get(i);
			e.draw(g);
			if(!e.isLive()) explodes.remove(i);
		}
		
		g.setColor(c);
	}
	
	private class paintThread implements Runnable {
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	private class KeyMonitor extends KeyAdapter {

		public void keyPressed(KeyEvent e) {
			myTank.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			myTank.keyReleased(e);
		}
		
	}
	
	
}













