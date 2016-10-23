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
	
	// ����ͼƬ
	private BufferedImage bgImg = null;
	// ��ʼͼƬ
	private BufferedImage startImg = null;
	// ����ͼƬ
	public BufferedImage mouseImg = null;
	// ������ʧʱ��ʾ��ͼƬ
	public BufferedImage mouse_bgImg = null;
	// ��ʼ��Ϸ��ť
	public MyButton startBut = new MyButton("��ʼ��Ϸ");
	// �����ػ���Ϸ�����߳�
	public Thread thread = null;
	// �Ƿ��Ѿ���ʼ��Ϸ
	public boolean isStart = false;
	// ��ʼ����
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
	// ����󶴵�list
	List<Hole> list = new ArrayList<Hole>();
	// ���ڲ��������
	Random random = new Random();
	// �����
	private int m;
	// �����ȡ��������
	public Hole hole;
	// ����
	public Graphics g;
	// ����
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
