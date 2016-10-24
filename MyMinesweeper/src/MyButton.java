import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class MyButton extends JButton {
	public MyButton() {
		this.setSize(30, 30);
		this.setBorder(BorderFactory.createRaisedBevelBorder());
		this.setBackground(Color.LIGHT_GRAY);
	}

}
