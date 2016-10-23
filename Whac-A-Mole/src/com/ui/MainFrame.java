package com.ui;
import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	// 用于显示图片的面板
	private ImgPanel panel = new ImgPanel();
	
	/*
	 * 构造函数，用于初始化界面
	 */
	public MainFrame() {
		this.initFrame();
	}
	
	/*
	 * 初始界面
	 */
	private void initFrame() {
		this.add(panel);
		this.setTitle("打地鼠");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// 窗口缩放效果
		for(int i=0; i<1000; i+=20) {
			this.setSize(i, i*700/1000);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
