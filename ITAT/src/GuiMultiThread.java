import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuiMultiThread extends JFrame {

	public GuiMultiThread() {
		MultiThreadPanel mtp = new MultiThreadPanel();
		this.add(mtp);
		this.setSize(500, 1000);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		Thread thread = new Thread(mtp);
		thread.start();
	}

	public static void main(String[] args) {
		new GuiMultiThread();
	}

}

class MultiThreadPanel extends JPanel implements Runnable {
	double x1, x2 = 0, y = 0, t = 0;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		y = 9.8 * t * t / 2;
		x2 = 26 * t;
		g.fillOval((int) x1, (int) y, 40, 40);
		g.fillOval((int) x2, (int) y, 40, 40);

	}

	public void run() {
		try {
			while (true) {
				Thread.sleep(50);
				t += 0.5;
				this.repaint();
			}

		} catch (InterruptedException i) {
			i.printStackTrace();
		}

	}

}