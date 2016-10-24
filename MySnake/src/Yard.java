import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Yard extends JPanel implements KeyListener {

	public static final int ROWS = 29, COLS = 37;
	public static final int BLOCK_SIZE = 20;

	Snake s = new Snake(this);
	Egg e = new Egg();

	MainFrame mf = null;

	boolean isAlive = true;

	Thread t = null;

	public Yard(MainFrame mf) {
		this.mf = mf;
		this.addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		Color c = g.getColor();
		this.setBackground(Color.GRAY);
		g.setColor(Color.white);
		for (int i = 0; i < ROWS; i++) {
			g.drawLine(0, i * BLOCK_SIZE, (COLS - 1) * BLOCK_SIZE, i
					* BLOCK_SIZE);
		}
		for (int i = 0; i < COLS; i++) {
			g.drawLine(i * BLOCK_SIZE, 0, i * BLOCK_SIZE, (ROWS - 1)
					* BLOCK_SIZE);
		}
		s.draw(g);
		e.draw(g);
		s.eat(e);
		mf.labelScore.setText("score:   " + MainFrame.score);
		if (isAlive == false) {
			mf.labelState.setText("o(╯□╰)o");
			System.out.println("feafe");
		}
		g.setColor(c);
	}

	public void stop() {
		isAlive = false;
		mf.bStart.setEnabled(false);
		mf.bPause.setEnabled(false);
		mf.bRestart.setEnabled(true);
	}

	class PaintThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isAlive && !t.isInterrupted()) {
				repaint();
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					break; // 一旦中断线程则退出循环
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		s.keyPressed(e);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	int count = 0;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mf.bStart) {
			t = new Thread(new PaintThread());
			t.start();
			mf.bPause.setEnabled(true);
			mf.bStart.setEnabled(false);
			mf.yard.requestFocus();
		} else if (e.getSource() == mf.bPause) {
			t.interrupt();
			count++;
			if (count % 2 == 0) {
				t = new Thread(new PaintThread());
				t.start();
				mf.bPause.setIcon(mf.pause_2);
			} else {
				mf.bPause.setIcon(mf.pause_1);
			}
			mf.bStart.setEnabled(false);
			mf.bRestart.setEnabled(false);
			mf.yard.requestFocus();
		} else if (e.getSource() == mf.bRestart) {
			this.s = new Snake(this);
			isAlive = true;
			t = new Thread(new PaintThread());
			t.start();
			MainFrame.score = 0;
			mf.labelScore.setText("score:   " + MainFrame.score);
			mf.labelState.setText("(*∩_∩*)");
			mf.bStart.setEnabled(false);
			mf.bPause.setEnabled(true);
			mf.bRestart.setEnabled(false);
			mf.yard.requestFocus();
		}
	}

}
