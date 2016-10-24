
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

import javax.swing.JButton;

/**
 * 
 * @author Sun
 *
 */
@SuppressWarnings("serial")
class MyButton extends JButton {

	BufferedImage buttonImage = null;

	/** Creates a new instance of TranslucentButton */
	public MyButton(String label) {
		super(label);
		setOpaque(false);
		this.setFont(new Font("华康少女文字W5(P)", Font.PLAIN, 12));
	}

	@Override
	public void paint(Graphics g) {
		// Create an image for the button graphics if necessary
		if (buttonImage == null || buttonImage.getWidth() != getWidth()
				|| buttonImage.getHeight() != getHeight()) {
			buttonImage = getGraphicsConfiguration().createCompatibleImage(
					getWidth(), getHeight(), Transparency.TRANSLUCENT);
		}
		Graphics gButton = buttonImage.getGraphics();
		Graphics2D g2d = (Graphics2D) gButton;
		Composite oldComposite = g2d.getComposite();
		g2d.setComposite(AlphaComposite.Clear);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setComposite(oldComposite);
		gButton.setClip(g.getClip());

		// Have the superclass render the button for us
		super.paint(gButton);

		// Make the graphics object sent to this paint() method translucent
		g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));

		// Copy the button's image to the destination graphics, translucently
		g2d.drawImage(buttonImage, 0, 0, null);
	}

}