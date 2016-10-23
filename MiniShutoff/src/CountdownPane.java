import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;


public class CountdownPane extends JPanel {
	Minishutoff mso = null;
	public CountdownPane(Minishutoff mso) {
		this.mso = mso;
		new Thread(new PaintThread()).start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.setFont(new Font("΢���ź�", Font.BOLD | Font.ITALIC, 16));
		g.drawString("����ʱ" + (mso.second--) +"��", 50, 80);
	}
	
	class PaintThread implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				repaint();
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
