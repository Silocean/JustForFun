package com.ui;
import javax.swing.JFrame;


public class MainFrame extends JFrame {
	
	// ������ʾͼƬ�����
	private ImgPanel panel = new ImgPanel();
	
	/*
	 * ���캯�������ڳ�ʼ������
	 */
	public MainFrame() {
		this.initFrame();
	}
	
	/*
	 * ��ʼ����
	 */
	private void initFrame() {
		this.add(panel);
		this.setTitle("�����");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		// ��������Ч��
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
