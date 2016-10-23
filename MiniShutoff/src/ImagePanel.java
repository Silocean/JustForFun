import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;


public class ImagePanel extends JPanel{
	private Image image = null;
	public ImagePanel(Image image) {
		super();
		this.image = image;
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
}
