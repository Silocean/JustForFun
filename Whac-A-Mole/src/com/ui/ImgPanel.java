package com.ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import com.control.MouseMonitor;
import com.game.Hole;

public class ImgPanel extends JPanel {
	
	// 背景图片
	private BufferedImage bgImg = null;
	// 开始图片
	private BufferedImage startImg = null;
	// 老鼠图片
	public BufferedImage mouseImg = null;
	// 老鼠消失时显示的图片
	public BufferedImage mouse_bgImg = null;
	// 开始游戏按钮
	public MyButton startBut = new MyButton("开始游戏");
	// 不断重绘游戏面板的线程
	public Thread thread = null;
	// 是否已经开始游戏
	public boolean isStart = false;
	// 初始化鼠洞
	Hole[] holes = new Hole[]{
			new Hole(137, 229),
			new Hole(353, 269),
			new Hole(610, 252),
			new Hole(248, 333),
			new Hole(93, 426),
			new Hole(403, 446),
			new Hole(554, 389),
			new Hole(776, 378)
	};
	// 存放鼠洞的list
	List<Hole> list = new ArrayList<Hole>();
	// 用于产生随机数
	Random random = new Random();
	// 随机数
	private int m;
	// 随机获取的三个鼠洞
	public Hole hole;
	// 画笔
	public Graphics g;
	// 分数
	public int score = 0;
	
	public ImgPanel() {
		
		for(int i=0; i<holes.length; i++) {
			list.add(holes[i]);
		}
		
		
		try {
			bgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/bin/images/" + "bg.jpg"));
			startImg = ImageIO.read(new File(System.getProperty("user.dir") + "/bin/images/" + "start.jpg"));
			mouseImg = ImageIO.read(new File(System.getProperty("user.dir") + "/bin/images/" + "mouse.png"));
			mouse_bgImg = ImageIO.read(new File(System.getProperty("user.dir") + "/bin/images/" + "mouse_bg.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setLayout(null);
		startBut.setBounds(800, 550, 100, 50);
		startBut.addMouseListener(new MouseMonitor(this));
		this.add(startBut);
		this.addMouseListener(new MouseMonitor(this));
		
		thread = new Thread(new PaintThread());
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.g = g;
		if(isStart) {
			this.remove(startBut);
			m = random.nextInt(holes.length);
			hole = list.get(m);
			g.drawImage(bgImg, 0, 0, this.getWidth(), this.getHeight(), null);
			g.drawImage(mouseImg, hole.getX(), hole.getY(), null);
			g.drawString("Score:" + score, 50, 50);
		} else {
			g.drawImage(startImg, 0, 0, this.getWidth(), this.getHeight(), null);
		}
	}
	
	private class PaintThread implements Runnable {

		@Override
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	public boolean isStart() {
		return isStart;
	}

	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
}
